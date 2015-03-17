package point;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ItemPrice", schema = "Order@cassandra_pu")
public class ItemPrice {

	@Id
	private String idItemPrice;

	@Column
	private BigDecimal value;

	@Column
	private String currency;

	public String getIdItemPrice() {
		return idItemPrice;
	}

	public void setIdItemPrice(String idItemPrice) {
		this.idItemPrice = idItemPrice;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
