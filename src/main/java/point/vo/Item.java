package point.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "Item", schema = "kunderaexamples@cassandra_pu")
public class Item {
	@Id
	private String idItem;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "long_description")
	private String longDescription;

	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private String image;

	// @Column(name = "context")
	// private Context context;
	//
	// @Column(name = "inventory")
	// private Inventory inventory;
	//
	// @Column(name = "price")
	// private ItemPrice price;

	/*
	 * GETTERS AND SETTERS
	 */
	public String getIdItem() {
		return idItem;
	}

	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	// public Context getContext() {
	// return context;
	// }
	//
	// public void setContext(Context context) {
	// this.context = context;
	// }
	//
	// public Inventory getInventory() {
	// return inventory;
	// }
	//
	// public void setInventory(Inventory inventory) {
	// this.inventory = inventory;
	// }
	//
	// public ItemPrice getPrice() {
	// return price;
	// }
	//
	// public void setPrice(ItemPrice price) {
	// this.price = price;
	// }

	public Item() {
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
