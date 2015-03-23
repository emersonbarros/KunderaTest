package point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import point.vo.Context;
import point.vo.Item;
import point.vo.ItemPrice;
import point.vo.Mode;
import point.vo.Product;
import point.vo.ProductOption;
import point.vo.ProductOptionValue;
import point.vo.ProductOptionValuePrice;

import com.impetus.client.cassandra.common.CassandraConstants;

public class Main {

//	private static EntityManager em;
//
//	public static void main(String[] args) throws Exception {
//		Map<String, String> propertyMap = new HashMap<String, String>();
//		propertyMap.put(CassandraConstants.CQL_VERSION,
//				CassandraConstants.CQL_VERSION_2_0);
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory(
//				"cassandra_pu", propertyMap);
//		em = factory.createEntityManager();
//
//		em.getTransaction().begin();
//
//		Product p = new Product();
//		p.setIdProduct("1000");
//
//		Item item = new Item();
//		item.setIdItem("1001");
//		item.setImage("image");
//		item.setLongDescription("Long Description");
//		item.setName("Name");
//		item.setShortDescription("Short Description");
//		p.setItem(item);
//
//		List<ProductOption> options = new ArrayList<ProductOption>();
//		ProductOption po = new ProductOption();
//		po.setIdProductOption("1003");
//
//		List<ProductOptionValue> optValues = new ArrayList<ProductOptionValue>();
//		ProductOptionValue optValue = new ProductOptionValue();
//		optValue.setIdProductOptionValue("1004");
//		optValue.setItem(item);
//
//		optValues.add(optValue);
//		po.setProductOptionValue(optValues);
//
//		options.add(po);
//		p.setOptions(options);
//
//		em.persist(p);
//
//		ProductOptionValuePrice optValuePrice = new ProductOptionValuePrice();
//		optValuePrice.setIdProductOptionValuePrice("1005");
//		ItemPrice itemPrice = new ItemPrice();
//		Context context = new Context();
//		context.setIdContext("1006");
//		Mode mode = new Mode();
//		mode.setIdMode("1007");
//		mode.setName("Name");
//		context.setMode(mode);
//		itemPrice.setContext(context);
//		itemPrice.setCurrencyCode("R");
//		itemPrice.setIdItemPrice("1008");
//		// itemPrice.setProduct(p);
//		itemPrice.setProductOptionValue(optValue);
//		itemPrice.setValue(1000);
//		optValuePrice.setItemPrice(itemPrice);
//
//		em.persist(optValuePrice);
//
//		em.getTransaction().commit();
//
//		Product o = em.find(Product.class, "1000");
//		System.out.println(o);
//
//		ProductOptionValuePrice povp = em.find(ProductOptionValuePrice.class,
//				"1005");
//		System.out.println(povp);
//
//		Query q = em.createQuery("select o FROM Product o");
//		System.out.println("Total Orders: " + q.getResultList().size());
//
//		q = em.createQuery("select o FROM Product o ");
//		List<Product> results = q.getResultList();
//		for (Product p1 : results) {
//			System.out.println(p1);
//		}
//
//		// Close the database connection:
//		em.close();
//	}

}