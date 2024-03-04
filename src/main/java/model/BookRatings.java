package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Feb 22, 2024
 */
@Entity	//creates a new table
@Table(name="BookRatings")		//names the table
public class BookRatings {
	@Id
	@GeneratedValue
	private int id;
	private LocalDate readDate;
	private int rating;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private BookListItems book;

	public BookRatings() {
		super();
	}

	public BookRatings(int rating, LocalDate readDate, BookListItems book) {
		this.rating = rating;
		this.readDate = readDate;
		this.book = book;
	}
	
	public BookRatings(int rating, BookListItems book) {
		this.rating = rating;
		this.book = book;
	}
	
	public BookRatings(LocalDate readDate, BookListItems book) {
		this.readDate = readDate;
		this.book = book;
	}
	
	public BookRatings(BookListItems book) {
		this.book = book;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getReadDate() {
		return readDate;
	}

	public void setReadDate(LocalDate readDate) {
		this.readDate = readDate;
	}
	
	public BookListItems getBook() {
		return book;
	}

	public void setBook(BookListItems book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "BookRatings [id=" + id + ", rating=" + rating + ", readDate=" + readDate + "]";
	}
	
}
