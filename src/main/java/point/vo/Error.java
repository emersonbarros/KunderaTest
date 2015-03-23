package point.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "error", schema = "kunderaexamples@cassandra_pu")
public class Error {

	@Id
	private String idError;

	@Column(name = "code")
	private Integer code;

	@Column(name = "message")
	private String message;

	@Column(name = "fields")
	private String fields;

	/*
	 * GETTERS AND SETTERS
	 */
	public String getIdError() {
		return idError;
	}

	public void setIdError(String idError) {
		this.idError = idError;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}
}