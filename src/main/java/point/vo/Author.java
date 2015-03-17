package point.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Author {

	@Column(name = "idAuthor")
	private String idAuthor;

	@Column(name = "name")
	private String name;

	public String getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(String idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if (name.length() > 255) {
			throw new Exception();
		}

		this.name = name;
	}

	public Author() {
	}

	public Author(String idAuthor, String name) throws Exception {
		setIdAuthor(idAuthor);
		setName(name);
	}
}