package point;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import point.vo.Item;
import point.vo.Product;
import point.vo.ProductOption;
import point.vo.ProductOptionValue;
import point.vo.ProductOptionValuePrice;

public class Main {

	private static EntityManager em;

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cassandra_pu");
		em = factory.createEntityManager();

		em.getTransaction().begin();

		Product p = new Product();
		p.setIdProduct("1000");

		Item item = new Item();
		item.setIdItem("1001");
		item.setImage("image");
		item.setLongDescription("Long Description");
		item.setName("Name");
		item.setShortDescription("Short Description");
		p.setItem(item);
		
		List<ProductOption> options = new ArrayList<ProductOption>();
		ProductOption po = new ProductOption();
		po.setIdProductOption("1003");
		
		List<ProductOptionValue> optValues = new ArrayList<ProductOptionValue>();
		ProductOptionValue optValue = new ProductOptionValue();
		optValue.setIdProductOptionValue("1004");
		optValue.setItem(item);
		ProductOptionValuePrice optValuePrice = new ProductOptionValuePrice();
		optValuePrice.setIdProductOptionValuePrice("1005");
				
		optValues.add(optValue);
		po.setProductOptionValue(optValues);

		options.add(po);
		p.setOptions(options);
		
		em.persist(p);
		em.persist(optValuePrice);

		em.getTransaction().commit();

		Product o = em.find(Product.class, "1000");
		System.out.println(o);
		
		ProductOptionValuePrice povp = em.find(ProductOptionValuePrice.class, "1000");
		System.out.println(povp);


		/*
		 * Query q = em.createQuery("select o FROM Order o");
		 * System.out.println("Total Orders: " + q.getResultList());
		 * 
		 * q = em.createQuery("select o FROM Order o "); List<Order> results =
		 * q.getResultList(); for (Order p1 : results) { System.out.println(p1);
		 * }
		 */

		// Close the database connection:
		em.close();
	}

}