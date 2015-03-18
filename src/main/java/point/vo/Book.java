package point.vo;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "Book", schema = "kunderaexamples@cassandra_pu")
public class Book {
	@Id
	private String idBook;

	@Embedded
	public Author author;

	@Column(name = "collection")
	public String collection;

	@Column(name = "other")
	public String other;

	@Column(name = "title")
	public String title;

	@ElementCollection
	@CollectionTable(name = "Reader")
	public List<Reader> readers;

	public String getIdBook() {
		return idBook;
	}

	public void setIdBook(String id) {
		this.idBook = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) throws Exception {
		if (author == null) {
			throw new Exception();
		}

		this.author = author;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) throws Exception {

		if (collection.length() > 255) {
			throw new Exception();
		}

		this.collection = collection;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) throws Exception {
		if (other.length() > 255) {
			throw new Exception();
		}

		this.other = other;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws Exception {

		if (title.length() > 255) {
			throw new Exception();
		}

		this.title = title;
	}

	public List<Reader> getReaders() {
		return readers;
	}

	public void setReaders(List<Reader> readers) throws Exception {
		if (readers.size() == 0) {
			throw new Exception();
		}

		this.readers = readers;
	}

	public Book() {
	};

	public Book(String idBook, Author author, String collection, String other,
			String title, List<Reader> readers) throws Exception {
		super();
		setIdBook(idBook);
		setAuthor(author);
		setCollection(collection);
		setOther(other);
		setTitle(title);
		setReaders(readers);
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
