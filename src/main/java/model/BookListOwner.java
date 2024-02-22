package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Misti Christianson - mchristianson CIS175 - Spring 2024 Feb 20, 2024
 */
//package and import statements
@Entity
@Table(name = "listOwner")
public class BookListOwner {
	@Id
	@GeneratedValue
	private int id;
	private String listOwner;

	public BookListOwner() {
		super();
	}

	public BookListOwner(int id, String listOwner) {
		super();
		this.id = id;
		this.listOwner = listOwner;
	}

	public BookListOwner(String listOwner) { // extra Shopper class that will let DB auto-generate next id#
		super();
		this.listOwner = listOwner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopperName() {
		return listOwner;
	}

	public void setShopperName(String listOwner) {
		this.listOwner = listOwner;
	}

	@Override
	public String toString() {
		return "BookListOwner [id=" + id + ", listOwner=" + listOwner + "]";
	}

}
