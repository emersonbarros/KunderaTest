package points;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.vidageek.mirror.dsl.Mirror;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import point.vo.Context;
import point.vo.Item;
import point.vo.ItemPrice;
import point.vo.Mode;
import point.vo.Product;
import point.vo.ProductOption;
import point.vo.ProductOptionValue;
import point.vo.ProductOptionValuePrice;
import com.impetus.client.cassandra.common.CassandraConstants;

/**
 * Junit tests for Cassandra/Kundera
 * 
 * @author jgustavo@motorola.com
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KunderaQueryTest {

	private static EntityManager em;

	@Before
	public void setup() {

		Map<String, String> propertyMap = new HashMap<String, String>();
		propertyMap.put(CassandraConstants.CQL_VERSION,
				CassandraConstants.CQL_VERSION_2_0);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory(
				"cassandra_pu", propertyMap);

		em = factory.createEntityManager();
	}

	public Item populateItem() {

		Item item = new Item();
		item.setIdItem("1001");
		item.setImage("image");
		item.setLongDescription("Long Description");
		item.setName("Name");
		item.setShortDescription("Short Description");
		return item;
	}

	public ProductOptionValue populateProductOptionValue(Item pItem) {
		ProductOptionValue pov = new ProductOptionValue();

		pov.setIdProductOptionValue("1004");
		pov.setItem(pItem);
		return pov;
	}

	public ProductOptionValuePrice populateProductOptionValuePrice(
			ProductOptionValue pOptValue) throws Exception {

		ItemPrice itemPrice = new ItemPrice();
		Context context = new Context();
		Mode mode = new Mode();
		ProductOptionValuePrice optValuePrice = new ProductOptionValuePrice();
		optValuePrice.setIdProductOptionValuePrice("1005");

		mode.setIdMode("1007");
		mode.setName("Name");

		context.setIdContext("1006");
		context.setMode(mode);

		itemPrice.setContext(context);
		itemPrice.setCurrencyCode("R");
		itemPrice.setIdItemPrice("1008");
		itemPrice.setProductOptionValue(pOptValue);
		itemPrice.setValue(1000);

		optValuePrice.setItemPrice(itemPrice);

		persistGroup(optValuePrice);

		return optValuePrice;
	}

	public Product populateProduct(ProductOptionValue pProductOptionValue,
			Item pItem) throws Exception {

		Product p = new Product();

		List<ProductOption> options = new ArrayList<ProductOption>();

		ProductOption po = new ProductOption();

		List<ProductOptionValue> optValues = new ArrayList<ProductOptionValue>();

		p.setIdProduct("1000");

		p.setItem(pItem);
		po.setIdProductOption("1003");

		optValues.add(pProductOptionValue);
		po.setProductOptionValue(optValues);

		options.add(po);
		p.setOptions(options);

		persistGroup(p);

		return p;
	}

	/**
	 * Scenario: Insert a product - Will be successful performed.
	 */
	@Test
	public void stage0_testInsertProduct() {

		try {
			em.getTransaction().begin();

			Item item = populateItem();
			ProductOptionValue productOptionValue = populateProductOptionValue(item);
			Product product = populateProduct(productOptionValue, item);
			ProductOptionValuePrice povp = populateProductOptionValuePrice(productOptionValue);

			em.getTransaction().commit();

			em.getTransaction().begin();

			System.out.println("RESULT FLAT OBJECT: " + product);

			product = em.find(Product.class, "1000");

			assertProduct(product);
			assertProductOptionValuePrice(povp);

			System.out.println("RESULT FIND_BY_ID: " + product);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Scenario: Retrieve all products - Will be successful performed.
	 */
	@Test
	public void stage1_testAssertFindAll() throws Exception {

		em.getTransaction().begin();

		Item item = populateItem();
		ProductOptionValue productOptionValue = populateProductOptionValue(item);
		Product product = populateProduct(productOptionValue, item);
		populateProductOptionValuePrice(productOptionValue);

		em.getTransaction().commit();

		em.getTransaction().begin();

		product = em.find(Product.class, "1000");
		assertTrue(product != null);
		em.getTransaction().commit();

		assertProductFindAll();
	}

	/**
	 * Scenario: Update a product - Will be successful performed.
	 */
	@Test
	public void stage2_testUpdateProductItem() throws Exception {
		em.getTransaction().begin();

		Item item = populateItem();
		ProductOptionValue productOptionValue = populateProductOptionValue(item);
		Product product = populateProduct(productOptionValue, item);
		populateProductOptionValuePrice(productOptionValue);

		em.getTransaction().commit();
		em.getTransaction().begin();

		product = em.find(Product.class, "1000");
		product.getItem().setImage("i.png");
		mergeGroup(product);

		em.getTransaction().commit();

		assertTrue(product != null);
		assertTrue(product.getItem().getImage().equals("i.png"));

	}

	@Test
	public void stage3_testDeleteProduct() throws Exception {

		em.getTransaction().begin();
		Item item = populateItem();
		ProductOptionValue productOptionValue = populateProductOptionValue(item);
		Product product = populateProduct(productOptionValue, item);
		populateProductOptionValuePrice(productOptionValue);
		
		em.getTransaction().commit();

		assertTrue(product != null);

		em.getTransaction().begin();

		deleteGroup(product);

		em.getTransaction().commit();

		em.getTransaction().begin();
		product = em.find(Product.class, "1000");
		em.getTransaction().commit();

		assertTrue(product == null);
		em.close();
	}

	public void assertProductFindAll() {

		List<Object> products = findAll(Product.class);
		
		assertTrue(!products.isEmpty());
		assertTrue(products!=null);
		
		for (Object obj : products) {
			Product prd = (Product) obj;
			System.out.println("Product choosen:" + prd);
			assertProduct(prd);

		}
	}

	public void assertProduct(final Product pProduct) {

		System.out.println("Product assert init");
		assertTrue(pProduct != null);
		assertTrue(pProduct.getIdProduct().equals("1000"));
		assertTrue(pProduct.getItem() != null);
		assertTrue(pProduct.getItem().getIdItem().equals("1001"));
		assertTrue(pProduct.getOptions() != null);
		assertTrue(pProduct.getOptions().size() == 1);
		assertTrue(pProduct.getOptions().get(0).getProductOptionValue() != null);
		System.out.println("Product assert passed");

	}

	public void assertProductOptionValuePrice(
			final ProductOptionValuePrice pProductOptionValuePrice) {

		assertTrue(pProductOptionValuePrice.getIdProductOptionValuePrice()
				.equals("1005"));
		assertTrue(pProductOptionValuePrice.getItemPrice() != null);
		assertTrue(pProductOptionValuePrice.getItemPrice().getContext() != null);
		assertTrue(pProductOptionValuePrice.getItemPrice().getContext()
				.getIdContext() != null);
		assertTrue(pProductOptionValuePrice.getItemPrice().getContext()
				.getIdContext().equals("1006"));

	}

	/**
	 * Generic method to retrieve all records
	 * 
	 * @param clazz
	 * @return List of objects containing all records from given type
	 */
	@SuppressWarnings("unchecked")
	public List<Object> findAll(final Class<?> clazz) {
		return em.createQuery("select ".concat(clazz.getSimpleName().substring(0, 1)).concat(" from ").concat(clazz.getSimpleName().concat(" ").concat(clazz.getSimpleName().substring(0, 1)))).getResultList();
	}

	/**
	 * Generic method to print all records
	 * 
	 * @param clazz
	 *            - Generic class type
	 */
	public void printAll(final Class<?> clazz) {

		Mirror m = new Mirror();

		for (Object p1 : findAll(clazz)) {
			System.out.println("Json: ".concat(String.valueOf(m.on(p1).invoke()
					.method("toString").withoutArgs())));
		}
	}

	/**
	 * Multi update method
	 * 
	 * @param args
	 *            - Entity classes
	 */
	public void mergeGroup(final Object... args) {

		if (args.length == 0)
			return;

		for (Object obj : args) {
			em.merge(obj);
		}

	}

	public void persistGroup(final Object... args) {

		if (args.length == 0)
			return;

		for (Object obj : args) {
			em.persist(obj);
		}
	}

	/**
	 * Remove 1 or N entities
	 * 
	 * @param args
	 */
	public static void deleteGroup(final Object... args) {

		if (args.length == 0)
			return;

		for (Object obj : args) {
			em.remove(obj);
		}

	}

}
