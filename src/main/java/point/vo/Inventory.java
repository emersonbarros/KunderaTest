package point.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "inventory", schema = "kunderaexamples@cassandra_pu")
public class Inventory {

	@Id
	private String idItem;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "idContext")
	private Context context;

	@Column(name = "factory_capacity")
	private Integer factoryCapacity;

	@Column(name = "availability_date")
	private String availabilityDate;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "backorder_quantity")
	private Integer backorderQuantity;

	@Column(name = "preorder_quantity")
	private Integer preorderQuantity;

	/*
	 * Inventory - GETTER AND SETTERS
	 */
	public String getIdItem() {
		return idItem;
	}

	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public Integer getFactoryCapacity() {
		return factoryCapacity;
	}

	public void setFactoryCapacity(Integer factoryCapacity) {
		this.factoryCapacity = factoryCapacity;
	}

	public String getAvailabilityDate() {
		return availabilityDate;
	}

	public void setAvailabilityDate(String availabilityDate) {
		this.availabilityDate = availabilityDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getBackorderQuantity() {
		return backorderQuantity;
	}

	public void setBackorderQuantity(Integer backorderQuantity) {
		this.backorderQuantity = backorderQuantity;
	}

	public Integer getPreorderQuantity() {
		return preorderQuantity;
	}

	public void setPreorderQuantity(Integer preorderQuantity) {
		this.preorderQuantity = preorderQuantity;
	}

	/*
	 * Context - GETTERS AND SETTERS
	 */

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}