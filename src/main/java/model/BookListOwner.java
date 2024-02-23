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
	private String ownerFName;
	private String ownerLName;

	public BookListOwner() {
		super();
	}

	public BookListOwner(int id, String ownerFName, String ownerLName) {
		super();
		this.id = id;
		this.ownerFName = ownerFName;
		this.ownerLName = ownerLName;
	}

	public BookListOwner(String ownerFName, String ownerLName) { // extra Shopper class that will let DB auto-generate next id#
		super();
		this.ownerFName = ownerFName;
		this.ownerLName = ownerLName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopperName() {
		return ownerFName;
	}

	public void setShopperName(String ownerFName) {
		this.ownerFName = ownerFName;
	}
	
	public String getOwnerLName() {
		return ownerLName;
	}

	public void setOwnerLName(String ownerLName) {
		this.ownerLName = ownerLName;
	}

	@Override
	public String toString() {
		return "BookListOwner [id=" + id + ", ownerFName=" + ownerFName + ", ownerLName=" + ownerLName + "]";
	}

}
