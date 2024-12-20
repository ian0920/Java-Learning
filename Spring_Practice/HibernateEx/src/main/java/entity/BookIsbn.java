package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookisbn")
public class BookIsbn {
	@Id
	@Column(name = "bid")
	private Integer bid;
	
	@Column(name = "isbn")
	private String isbn;

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Category [bid=" + bid + ", isbn=" + isbn + "]";
	}
	
}
