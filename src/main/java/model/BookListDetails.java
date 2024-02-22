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
	private LocalDate tripDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private BookListOwner bookListOwner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER) 
	private List<BookListItems> listOfItems;	

	public BookListDetails() {
		super();
	}

	public BookListDetails(int id, String listName, LocalDate tripDate, BookListOwner bookListOwner, List<BookListItems> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.bookListOwner = bookListOwner;
		this.listOfItems = listOfItems;
	}

	public BookListDetails(String listName, LocalDate tripDate, BookListOwner bookListOwner, List<BookListItems> listOfItems) {
		this.listName = listName;
		this.tripDate = tripDate;
		this.bookListOwner = bookListOwner;
		this.listOfItems = listOfItems;
	}

	public BookListDetails(String listName, LocalDate tripDate, BookListOwner bookListOwner) {
		this.listName = listName;
		this.tripDate = tripDate;
		this.bookListOwner = bookListOwner;
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

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public BookListOwner getShopper() {
		return bookListOwner;
	}

	public void setShopper(BookListOwner bookListOwner) {
		this.bookListOwner = bookListOwner;
	}

	public void setListOfItems(List<BookListItems> listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	public List<BookListItems> getListOfItems() {
		return listOfItems;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", shopper=" + bookListOwner
				+ ", listOfItems=" + listOfItems + "]";
	}

}
