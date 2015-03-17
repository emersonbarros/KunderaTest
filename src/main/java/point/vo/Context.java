package point.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Context",  schema = "kunderaexamples@cassandra_pu")
public class Context {
	
	@Id
	@Column(name = "idContext")
	private String idContext;
	
	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "idMode")
	private Mode mode;
	
	public String getIdContext() {
		return idContext;
	}

	public void setIdContext(String idContext) {
		this.idContext = idContext;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	
	public Context() throws Exception {
		super();
	}
	
	public Context(Mode mode) throws Exception {
		super();
		setMode(mode);
	}
	
}
