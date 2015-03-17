package point;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ItemOrder", schema = "Order@cassandra_pu")
public class ItemOrder {

	@Id
	private String idItemOrder;

	@Column
	private String description;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idItemPrice")
	private ItemPrice price;

	public String getIdItemOrder() {
		return idItemOrder;
	}

	public void setIdItemOrder(String idItemOrder) {
		this.idItemOrder = idItemOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ItemPrice getPrice() {
		return price;
	}

	public void setPrice(ItemPrice price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemOrder [idItemOrder=" + idItemOrder + ", description="
				+ description + ", price=" + price + "]";
	}

}
