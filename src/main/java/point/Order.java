package point;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Order", schema = "Order@cassandra_pu")
public class Order {

	@Id
	private String id;

	@Column
	private String nameOrder;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "idItemOrder")
	private List<ItemOrder> items;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameOrder() {
		return nameOrder;
	}

	public void setNameOrder(String nameOrder) {
		this.nameOrder = nameOrder;
	}

	public List<ItemOrder> getItems() {
		return items;
	}

	public void setItems(List<ItemOrder> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + nameOrder + ", items=" + items + "]";
	}
}
