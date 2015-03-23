package point.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "Partner", schema = "kunderaexamples@cassandra_pu")
public class Partner {

	@Id
	private String idPartner;

	@Column(name = "name")
	private String name;

	/*
	 * GETTERS AND SETTERS
	 */
	public String getIdPartner() {
		return idPartner;
	}

	public void setIdPartner(String idPartner) {
		this.idPartner = idPartner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Partner() {
	}

	public Partner(String name) {
		setName(name);
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
