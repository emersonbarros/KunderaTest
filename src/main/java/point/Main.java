package point;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

	private static EntityManager em;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("cassandra_pu");
		em = factory.createEntityManager();

		// Store 1000 Order objects in the database:
		em.getTransaction().begin();
		for (int i = 0; i < 1000; i++) {
			Order p = new Order();
			p.setId(UUID.randomUUID().toString());
			List<ItemOrder> items = new ArrayList<ItemOrder>();
			ItemOrder item = new ItemOrder();
			item.setDescription("description " + i);
			item.setIdItemOrder(UUID.randomUUID().toString());
			ItemPrice price = new ItemPrice();
			price.setIdItemPrice(UUID.randomUUID().toString());
			price.setCurrency("Real");
			price.setValue(new BigDecimal(1000*1/2.5));
			item.setPrice(price);
			items.add(item);
			p.setItems(items);
			em.persist(p);
		}
		em.getTransaction().commit();

		Query q = em.createQuery("select o FROM Order o");
		System.out.println("Total Orders: " + q.getResultList());

		q = em.createQuery("select o FROM Order o ");
		List<Order> results = q.getResultList();
		for (Order p1 : results) {
			System.out.println(p1);
		}

		// Close the database connection:
		em.close();
	}

}