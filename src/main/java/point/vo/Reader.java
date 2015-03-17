package point.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Reader {

	@Column(name = "idReader")
	private String idReader;

	@Column(name = "nameReader")
	private String nameReader;

	public String getIdReader() {
		return idReader;
	}

	public void setIdReader(String idReader) {
		this.idReader = idReader;
	}

	public String getName() {
		return nameReader;
	}

	public void setName(String nameReader) throws Exception {

		this.nameReader = nameReader;
	}

	public Reader() {
	}

	public Reader(String idReader, String nameReader) throws Exception {
		setIdReader(idReader);
		setName(nameReader);
	}
}