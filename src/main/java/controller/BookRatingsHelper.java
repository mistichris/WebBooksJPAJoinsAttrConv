package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BookRatings;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Feb 22, 2024
 */
public class BookRatingsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBooksJPAJoinsAttributeConv");
	
	public void insertBookRatings(BookRatings li) {							
		EntityManager em = emfactory.createEntityManager();			//creates a new instance of the Entity Manager
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();													//closes Entity Manager
	}
	
	@SuppressWarnings("unchecked")
	public List<BookRatings> showAllRatings(){
		EntityManager em = emfactory.createEntityManager();											//creates a new instance of the Entity Manager
		List<BookRatings> allRatings = em.createQuery("SELECT i FROM BookRatings i").getResultList();		//retrieves all instances of the item from the table
		return allRatings;
		}
	
	//delete an book from the database
	@SuppressWarnings("unused")
	public void deleteBook(BookRatings toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookRatings> typedQuery = em.createQuery("Select li from ListBook li where li.id = :selectedId", 
				BookRatings.class);
		typedQuery.setParameter("selectedId", toDelete.getId());

		// we only want on result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list book
		BookRatings result = typedQuery.getSingleResult();					//creating a ListBook object for the results

		// remove it
		em.remove(result);					//removing result/book from table in database
		em.getTransaction().commit();
		em.close();							//closing the Entity Manager
	}
	//update book in database script
	public void updateBook(BookRatings toEdit) {
		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
		em.getTransaction().begin();
		em.merge(toEdit);				//merging edits with current item in database using toEdit object from ListBook created in Start Program created in editABook method
		em.getTransaction().commit();
		em.close();						//closing the Entity Manager
		}
	
		//search for book by author script
	public List<BookRatings> searchForBookByAuthor(String authorName) {			//from StartProgram editABook method
		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
		em.getTransaction().begin();
		TypedQuery<BookRatings> typedQuery = em.createQuery("select li from ListBook li where li.author = :selectedAuthor", BookRatings.class);		//returns an object of a given parameter to a new list titled 'typedQuery'
		typedQuery.setParameter("selectedAuthor", authorName);			//set new parameters for the typedQuery list
		List<BookRatings> foundRatings = typedQuery.getResultList();			//returns a list of books that matched the search criteria
		em.close();														//closing the Entity Manager
		return foundRatings;
		}
	
		//search for book by name script
	public List<BookRatings> searchForBookByTitle(String bookTitle) {			//from StartProgram editABook method
		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
		em.getTransaction().begin();
		TypedQuery<BookRatings> typedQuery = em.createQuery("select li from ListBook li where li.book = :selectedBook", BookRatings.class);		//returns an object of a given parameter to a new list titled 'typedQuery'
		typedQuery.setParameter("selectedBook", bookTitle);			//set new parameters for the typedQuery list
		List<BookRatings> foundRatings = typedQuery.getResultList();		//returns a list of books that matched the search criteria
		em.close();													//closing the Entity Manager
		return foundRatings;
		}
	
	//Search for Book by ID script
	public BookRatings searchForBookById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();				//new instance of Entity Manager Factory
		em.getTransaction().begin();
		BookRatings found = em.find(BookRatings.class, idToEdit);				
		em.close();														//closing the Entity Manager
		return found;
		}

	
	//closing Entity Manager Factory
	public void cleanUp(){
		emfactory.close();
		}
}
