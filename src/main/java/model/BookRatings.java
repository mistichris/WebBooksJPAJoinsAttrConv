package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	public BookRatings() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BookRatings(int id, int rating, LocalDate readDate) {
		super();
		this.id = id;
		this.rating = rating;
		this.readDate = readDate;
	}
	
	public BookRatings(int rating, LocalDate readDate) {
		super();
		this.rating = rating;
		this.readDate = readDate;
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

	@Override
	public String toString() {
		return "BookRatings [id=" + id + ", rating=" + rating + ", readDate=" + readDate + "]";
	}
	
}
