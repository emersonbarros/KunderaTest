package point.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "Locale", schema = "kunderaexamples@cassandra_pu")
public class Locale {

	@Id
	@Column(name = "idLocale")
	private String idLocale;

	@Column(name = "name")
	private String name;

	@Column(name = "language")
	private String language;

	@Column(name = "country")
	private String country;

	/*
	 * GETTERS AND SETTERS
	 */
	public String getIdLocale() {
		return idLocale;
	}

	public void setIdLocale(String idLocale) {
		this.idLocale = idLocale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Locale() {
	}

	public Locale(String name, String language, String country) {
		setName(name);
		setLanguage(language);
		setCountry(country);
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}