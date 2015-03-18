package points.unit.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import point.vo.Context;
import point.vo.Item;
import point.vo.ItemPrice;
import point.vo.Mode;
import point.vo.Product;
import point.vo.ProductOption;
import point.vo.ProductOptionValue;
import point.vo.ProductOptionValuePrice;

import com.impetus.client.cassandra.common.CassandraConstants;
import com.objectdb.o.SLV.T;

public class KunderaQueryTest {
	private EntityManager em;

	@Before
	public void setup() {

		Map<String, String> propertyMap = new HashMap<String, String>();
		propertyMap.put(CassandraConstants.CQL_VERSION,
				CassandraConstants.CQL_VERSION_2_0);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(
				"cassandra_pu", propertyMap);
		em = factory.createEntityManager();
	}

	@Test
	public void testQueryProducts() {

		try {

			em.getTransaction().begin();

			em.setProperty("cql.version", "2.0.0");

			Product p = new Product();

			Context context = new Context();

			Item item = new Item();
			ItemPrice itemPrice = new ItemPrice();

			List<ProductOption> options = new ArrayList<ProductOption>();
			ProductOption po = new ProductOption();

			List<ProductOptionValue> optValues = new ArrayList<ProductOptionValue>();

			ProductOptionValue optValue = new ProductOptionValue();
			ProductOptionValuePrice optValuePrice = new ProductOptionValuePrice();

			Mode mode = new Mode();

			p.setIdProduct("1000");

			item.setIdItem("1001");
			item.setImage("image");
			item.setLongDescription("Long Description");
			item.setName("Name");
			item.setShortDescription("Short Description");

			p.setItem(item);

			po.setIdProductOption("1003");

			optValue.setIdProductOptionValue("1004");
			optValue.setItem(item);

			optValues.add(optValue);
			po.setProductOptionValue(optValues);

			options.add(po);
			p.setOptions(options);

			em.persist(p);

			optValuePrice.setIdProductOptionValuePrice("1005");

			context.setIdContext("1006");

			mode.setIdMode("1007");
			mode.setName("Name");

			context.setMode(mode);

			itemPrice.setContext(context);
			itemPrice.setCurrencyCode("R");
			itemPrice.setIdItemPrice("1008");
			itemPrice.setProductOptionValue(optValue);
			itemPrice.setValue(1000);

			optValuePrice.setItemPrice(itemPrice);

			em.persist(optValuePrice);

			em.getTransaction().commit();

			Product persistedProduct = em.find(Product.class, "1000");

			assertTrue(persistedProduct != null);
			assertTrue(persistedProduct.getIdProduct().equals("1000"));
			assertTrue(persistedProduct.getItem() != null);
			assertTrue(persistedProduct.getItem().getIdItem().equals("1001"));
			assertTrue(!persistedProduct.getOptions().isEmpty());
			assertTrue(persistedProduct.getOptions().size() == 1);

			System.out.println(persistedProduct);

			ProductOptionValuePrice persistedProductOptValuePrice = em.find(
					ProductOptionValuePrice.class, "1005");

			assertTrue(persistedProductOptValuePrice.getItemPrice() != null);
			assertTrue(persistedProductOptValuePrice.getItemPrice()
					.getContext() != null);
			assertTrue(persistedProductOptValuePrice.getItemPrice()
					.getContext().getIdContext() != null);
			assertTrue(persistedProductOptValuePrice.getItemPrice()
					.getContext().getIdContext().equals("1006"));

			System.out.println(persistedProductOptValuePrice);

			Query q = em.createQuery("select o FROM Product o");
			
			System.out.println("Total Orders: " + q.getResultList().size());
			
			q = em.createQuery("select o FROM Product o ");
			
			List<Product> results = q.getResultList();

			for (Product p1 : results) {
				System.out.println(p1);
			}

		} catch (Exception e) {
			fail(e.getMessage());
		} finally {
			em.close();
		}

	}
}
