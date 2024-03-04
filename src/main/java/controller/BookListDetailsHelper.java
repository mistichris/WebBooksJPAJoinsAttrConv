package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BookListDetails;
import model.BookRatings;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Feb 22, 2024
 */
public class BookListDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBooksJPAJoinsAttributeConv");
	
	public void insertBookListDetails(BookListDetails li) {						
		EntityManager em = emfactory.createEntityManager();			//creates a new instance of the Entity Manager
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();													//closes Entity Manager
	}
	
	public void insertBookListRatings(BookRatings li) {						
		EntityManager em = emfactory.createEntityManager();			//creates a new instance of the Entity Manager
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();													//closes Entity Manager
	}
	
	public List<BookListDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<BookListDetails> allDetails = em.createQuery("SELECT d FROM BookListDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(BookListDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookListDetails> typedQuery = em.createQuery("select detail from BookListDetails	detail where detail.id = :selectedId", BookListDetails.class);
		
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		// we only want one result
		typedQuery.setMaxResults(1);
		
		// get the result and save it into a new list item
		BookListDetails result = typedQuery.getSingleResult();
		
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateList(BookListDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		}
//	@SuppressWarnings("unchecked")
//	public List<BookListDetails> showAllBookListDetails(){
//		EntityManager em = emfactory.createEntityManager();											//creates a new instance of the Entity Manager
//		List<BookListDetails> allDetails = em.createQuery("SELECT i FROM ListBook i").getResultList();		//retrieves all instances of the item from the table
//		return allDetails;
//		}
//	
//	//delete an book from the database
//	public void deleteBook(BookListDetails toDelete) {
//		EntityManager em = emfactory.createEntityManager();
//		em.getTransaction().begin();
//		TypedQuery<BookListDetails> typedQuery = em.createQuery("Select li from ListBook li where li.id = :selectedId", 
//				BookListDetails.class);
//		typedQuery.setParameter("selectedId", toDelete.getId());
//
//		// we only want on result
//		typedQuery.setMaxResults(1);
//
//		// get the result and save it into a new list book
//		BookListDetails result = typedQuery.getSingleResult();					//creating a ListBook object for the results
//
//		// remove it
//		em.remove(result);					//removing result/book from table in database
//		em.getTransaction().commit();
//		em.close();							//closing the Entity Manager
//	}
//	
//	//update book in database script
//	public void updateBook(BookListDetails toEdit) {
//		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
//		em.getTransaction().begin();
//		em.merge(toEdit);				//merging edits with current item in database using toEdit object from ListBook created in Start Program created in editABook method
//		em.getTransaction().commit();
//		em.close();						//closing the Entity Manager
//		}
//	
//		//search for book by author script
//	public List<BookListDetails> searchForBookLIstDetailsByAuthor(String authorName) {			//from StartProgram editABook method
//		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
//		em.getTransaction().begin();
//		TypedQuery<BookListDetails> typedQuery = em.createQuery("select li from ListBook li where li.author = :selectedAuthor", BookListDetails.class);		//returns an object of a given parameter to a new list titled 'typedQuery'
//		typedQuery.setParameter("selectedAuthor", authorName);			//set new parameters for the typedQuery list
//		List<BookListDetails> foundDetails = typedQuery.getResultList();			//returns a list of books that matched the search criteria
//		em.close();														//closing the Entity Manager
//		return foundDetails;
//		}
//	
//		//search for book by name script
//	public List<BookListDetails> searchForBookLIstDetailsByTitle(String bookTitle) {			//from StartProgram editABook method
//		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
//		em.getTransaction().begin();
//		TypedQuery<BookListDetails> typedQuery = em.createQuery("select li from ListBook li where li.book = :selectedBook", BookListDetails.class);		//returns an object of a given parameter to a new list titled 'typedQuery'
//		typedQuery.setParameter("selectedBook", bookTitle);			//set new parameters for the typedQuery list
//		List<BookListDetails> foundDetails = typedQuery.getResultList();		//returns a list of books that matched the search criteria
//		em.close();													//closing the Entity Manager
//		return foundDetails;
//		}
//	
	//Search for List Details by ID script
	public BookListDetails searchForBookListDetailsById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();				//new instance of Entity Manager Factory
		em.getTransaction().begin();
		BookListDetails found = em.find(BookListDetails.class, idToEdit);				
		em.close();														//closing the Entity Manager
		return found;
		}
	
	//closing Entity Manager Factory
	public void cleanUp(){
		emfactory.close();
		}
}
