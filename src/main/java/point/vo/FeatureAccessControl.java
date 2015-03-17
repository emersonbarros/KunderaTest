package point.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "FeatureAccessControl", schema = "motomakerV1_0@cassandra_pu_version1")
public class FeatureAccessControl {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "isEnabled")
	private boolean isEnabled;

	@Column(name = "path")
	private String path;

	@Column(name = "method")
	private MethodEnum method;

	@Column(name = "lastUpdatedOn")
	private String lastUpdatedOn;

	@Column(name = "lastUpdatedBy")
	private String lastUpdatedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(String lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public FeatureAccessControl() {
	}

	public MethodEnum getMethod() {
		return method;
	}

	public void setMethod(MethodEnum method) {
		this.method = method;
	}

	public FeatureAccessControl(String name, Boolean enabled, String path,
			MethodEnum method) {
		setName(name);
		setEnabled(enabled);
		setPath(path);
		setMethod(method);
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}