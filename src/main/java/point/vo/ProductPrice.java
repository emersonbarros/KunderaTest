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
@Table(name = "ProductPrice",  schema = "kunderaexamples@cassandra_pu")
public class ProductPrice {
	
	public ProductPrice() {

	}
	
	/*
	 * ProductPrice - ATRIBUTES
	 * */

	@Id
	@Column(name = "idProductPrice")
	private String idProductPrice;
	
	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "idItemPrice")
	private ItemPrice itemPrice;


	/*
	 * ProductPrice - GETTERS AND SETTERS
	 * */
	
	public String getIdProductPrice() {
		return idProductPrice;
	}

	public void setIdProductPrice(String idProductPrice) {
		this.idProductPrice = idProductPrice;
	}

	public ItemPrice getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(ItemPrice itemPrice) {
		this.itemPrice = itemPrice;
	}

	/*
	 * ItemPrice - GETTERS AND SETTERS
	 * */
		
	/*public String getIdItemPrice() {
		return itemPrice.getIdItemPrice();
	}

	public void setIdItemPrice(String idItemPrice) {
		this.itemPrice.setIdItemPrice(idItemPrice);
	}
	
	public Product getProduct() {
		return itemPrice.getProduct();
	}

	public void setProduct(Product product) {
		this.itemPrice.setProduct(product);
	}
	
	public ProductOptionValue getProductOptionValue() {
		return itemPrice.getProductOptionValue();
	}

	public void setProductOptionValue(ProductOptionValue productOptionValue) {
		this.itemPrice.setProductOptionValue(productOptionValue);
	}
	
	public Context getContext() {
		return itemPrice.getContext();
	}

	public void setContext(Context context) {
		this.itemPrice.setContext(context);
	}

	public String getCurrencyCode() {
		return itemPrice.getCurrencyCode();
	}

	public void setCurrencyCode(String currencyCode) {
		this.itemPrice.setCurrencyCode(currencyCode);
	}

	public Integer getValue() {
		return itemPrice.getValue();
	}

	public void setValue(Integer value) {
		this.itemPrice.setValue(value);
	}*/
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
