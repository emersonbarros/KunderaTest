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
@Table(name = "ProductOptionValue", schema = "kunderaexamples@cassandra_pu")
public class ProductOptionValue {
	@Id
	@Column(name = "idProductOptionValue")
	private String idProductOptionValue;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "idItem", table = "Item")
	private Item item;

	public String getIdProductOptionValue() {
		return idProductOptionValue;
	}

	public void setIdProductOptionValue(String idProductOptionValue) {
		this.idProductOptionValue = idProductOptionValue;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public ProductOptionValue() {
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}