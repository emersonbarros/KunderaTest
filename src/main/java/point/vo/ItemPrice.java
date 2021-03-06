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
@Table(name = "ItemPrice", schema = "kunderaexamples@cassandra_pu")
public class ItemPrice {

	public ItemPrice() {
	}

	@Id
	private String idItemPrice;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private ProductOptionValue productOptionValue;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "idContext")
	private Context context;

	@Column(name = "currency_code")
	private String currencyCode;

	@Column(name = "value")
	private Integer value;

	/*
	 * ItemPrice - GETTERS AND SETTERS
	 */

	public String getIdItemPrice() {
		return idItemPrice;
	}

	public void setIdItemPrice(String idItemPrice) {
		this.idItemPrice = idItemPrice;
	}

	public ProductOptionValue getProductOptionValue() {
		return productOptionValue;
	}

	public void setProductOptionValue(ProductOptionValue productOptionValue) {
		this.productOptionValue = productOptionValue;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	/*
	 * Product - GETTERS AND SETTERS
	 */

	/*
	 * ProductOptionValue - GETTERS AND SETTERS
	 */

	/*
	 * Context - GETTERS AND SETTERS
	 */

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}