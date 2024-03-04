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

/**
 * @author Misti Christianson - mchristianson CIS175 - Spring 2024 Feb 21, 2024
 */
@Entity
public class BookListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private BookListOwner bookListOwner;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<BookRatings> listOfRatings;
	private LocalDate createdDate;

	public BookListDetails() {
		super();
	}

	public BookListDetails(String listName, BookListOwner bookListOwner, List<BookListItems> listOfItems,
			List<BookRatings> listOfRatings) {
		super();
		this.listName = listName;
		this.bookListOwner = bookListOwner;
//		this.listOfItems = listOfItems;
		this.listOfRatings = listOfRatings;
		createdDate =  LocalDate.now();
	}

	public BookListDetails(String listName, BookListOwner bookListOwner, List<BookListItems> listOfItems) {
		super();
		this.listName = listName;
		this.bookListOwner = bookListOwner;
//		this.listOfItems = listOfItems;
		createdDate =  LocalDate.now();
	}

	public BookListDetails(String listName, BookListOwner bookListOwner) {
		this.listName = listName;
		this.bookListOwner = bookListOwner;
		createdDate =  LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public BookListOwner getBookListOwner() {
		return bookListOwner;
	}

	public void getBookListOwner(BookListOwner bookListOwner) {
		this.bookListOwner = bookListOwner;
	}

//	public void setListOfItems(List<BookListItems> listOfItems) {
//		this.listOfItems = listOfItems;
//	}
//
//	public List<BookListItems> getListOfItems() {
//		return listOfItems;
//	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		createdDate =  LocalDate.now();
	}
	
	public List<BookRatings> getListOfRatings() {
		return listOfRatings;
	}

	public void setListOfRatings(List<BookRatings> listOfRatings) {
		this.listOfRatings = listOfRatings;
	}

	public void setBookListOwner(BookListOwner bookListOwner) {
		this.bookListOwner = bookListOwner;
	}

	@Override
	public String toString() {
		return "BookListDetails [id=" + id + ", listName=" + listName + ", bookListOwner=" + bookListOwner
				+ " createdDate=" + createdDate + "]";
	}

}
