package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BookListOwner;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Feb 22, 2024
 */
public class BookListOwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBooksJPAJoinsAttributeConv");
	
	public void insertBookListOwner(BookListOwner li) {							
		EntityManager em = emfactory.createEntityManager();			//creates a new instance of the Entity Manager
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();													//closes Entity Manager
	}
	
	@SuppressWarnings("unchecked")
	public List<BookListOwner> showAllOwners(){
		EntityManager em = emfactory.createEntityManager();											//creates a new instance of the Entity Manager
		List<BookListOwner> allOwners = em.createQuery("SELECT i FROM ListBook i").getResultList();		//retrieves all instances of the item from the table
		return allOwners;
		}
	
	//delete an book from the database
	@SuppressWarnings("unused")
	public void deleteBook(BookListOwner toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookListOwner> typedQuery = em.createQuery("Select li from ListBook li where li.id = :selectedId", 
				BookListOwner.class);
		typedQuery.setParameter("selectedId", toDelete.getId());

		// we only want on result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list book
		BookListOwner result = typedQuery.getSingleResult();					//creating a ListBook object for the results

		// remove it
		em.remove(result);					//removing result/book from table in database
		em.getTransaction().commit();
		em.close();							//closing the Entity Manager
	}
	
	//update book in database script
	public void updateBook(BookListOwner toEdit) {
		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
		em.getTransaction().begin();
		em.merge(toEdit);				//merging edits with current item in database using toEdit object from ListBook created in Start Program created in editABook method
		em.getTransaction().commit();
		em.close();						//closing the Entity Manager
		}
	
		//search for book by author script
	public List<BookListOwner> searchForBookByAuthor(String authorName) {			//from StartProgram editABook method
		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
		em.getTransaction().begin();
		TypedQuery<BookListOwner> typedQuery = em.createQuery("select li from ListBook li where li.author = :selectedAuthor", BookListOwner.class);		//returns an object of a given parameter to a new list titled 'typedQuery'
		typedQuery.setParameter("selectedAuthor", authorName);			//set new parameters for the typedQuery list
		List<BookListOwner> foundOwner = typedQuery.getResultList();			//returns a list of books that matched the search criteria
		em.close();														//closing the Entity Manager
		return foundOwner;
		}
	
		//search for book by name script
	public List<BookListOwner> searchForBookByTitle(String bookTitle) {			//from StartProgram editABook method
		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
		em.getTransaction().begin();
		TypedQuery<BookListOwner> typedQuery = em.createQuery("select li from ListBook li where li.book = :selectedBook", BookListOwner.class);		//returns an object of a given parameter to a new list titled 'typedQuery'
		typedQuery.setParameter("selectedBook", bookTitle);			//set new parameters for the typedQuery list
		List<BookListOwner> foundOwner = typedQuery.getResultList();		//returns a list of books that matched the search criteria
		em.close();													//closing the Entity Manager
		return foundOwner;
		}
	
	//Search for Book by ID script
	public BookListOwner searchForBookById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();				//new instance of Entity Manager Factory
		em.getTransaction().begin();
		BookListOwner found = em.find(BookListOwner.class, idToEdit);				
		em.close();														//closing the Entity Manager
		return found;
		}

	
	//closing Entity Manager Factory
	public void cleanUp(){
		emfactory.close();
		}
	
	
}
