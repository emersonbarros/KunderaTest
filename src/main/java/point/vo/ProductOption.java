package point.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "ProductOption", schema = "kunderaexamples@cassandra_pu")
public class ProductOption {
	@Id
	private String idProductOption;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<ProductOptionValue> productOptionValue;

	public String getIdProductOption() {
		return idProductOption;
	}

	public void setIdProductOption(String idProductOption) {
		this.idProductOption = idProductOption;
	}

	public List<ProductOptionValue> getProductOptionValue() {
		return productOptionValue;
	}

	public void setProductOptionValue(
			List<ProductOptionValue> productOptionValues) {
		this.productOptionValue = productOptionValues;
	}

	public ProductOption() {
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}