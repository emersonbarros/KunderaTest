package point.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "Mode", schema = "kunderaexamples@cassandra_pu")
public class Mode {

	@Id
	private String idMode;

	@Column(name = "name")
	private String name;

	/*
	 * GETTERS AND SETTERS
	 */
	public String getIdMode() {
		return idMode;
	}

	public void setIdMode(String idMode) {
		this.idMode = idMode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		
		this.name = name;
	}

	public Mode() {
	}

	public Mode(String name) throws Exception {
		setName(name);
	}
	
	public Mode(String IdMode ,String name) throws Exception {
		setName(name);
		setIdMode(IdMode);
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}