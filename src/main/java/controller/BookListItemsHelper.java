package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BookListItems;

public class BookListItemsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBooksJPAJoinsAttributeConv");		//creating a global instance of the Entity Manager Factory

	public void insertBook(BookListItems li) {							//add an book to the database/table
		EntityManager em = emfactory.createEntityManager();			//creates a new instance of the Entity Manager
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();													//closes Entity Manager
	}

	//show all books in the database/table
	@SuppressWarnings("unchecked")
	public List<BookListItems> showAllBooks(){
		EntityManager em = emfactory.createEntityManager();											//creates a new instance of the Entity Manager
		List<BookListItems> allBooks = em.createQuery("SELECT i FROM BookListItems i").getResultList();		//retrieves all instances of the item from the table
		return allBooks;
		}

	//delete an book from the database
	public void deleteBook(BookListItems toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookListItems> typedQuery = em.createQuery("Select li from BookListItems li where li.id = :selectedId", 
				BookListItems.class);
//		TypedQuery<BookListItems> typedQuery = em.createQuery(				//returns an object of a given parameter to a new list titled 'typedQuery'
//				"Select li from BookListItems li where li.author = :selectedAuthor and li.book = :selectedBook",
//				BookListItems.class);

		// Substitute parameter with actual data from the toDelete book
		typedQuery.setParameter("selectedId", toDelete.getId());
//		typedQuery.setParameter("selectedAuthor", toDelete.getAuthor());			//toDelete BookListItems object created from StartProgram and getAuthor method from BookListItems
//		typedQuery.setParameter("selectedBook", toDelete.getBook());				//toDelete BookListItems object created from StartProgram and getBook method from BookListItems

		// we only want on result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list book
		BookListItems result = typedQuery.getSingleResult();					//creating a BookListItems object for the results

		// remove it
		em.remove(result);					//removing result/book from table in database
		em.getTransaction().commit();
		em.close();							//closing the Entity Manager
	}
	
		//update book in database script
	public void updateBook(BookListItems toEdit) {
		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
		em.getTransaction().begin();
		em.merge(toEdit);				//merging edits with current item in database using toEdit object from BookListItems created in Start Program created in editABook method
		em.getTransaction().commit();
		em.close();						//closing the Entity Manager
		}
	
		//search for book by author script
	public List<BookListItems> searchForBookByAuthor(String authorName) {			//from StartProgram editABook method
		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
		em.getTransaction().begin();
		TypedQuery<BookListItems> typedQuery = em.createQuery("select li from BookListItems li where li.author = :selectedAuthor", BookListItems.class);		//returns an object of a given parameter to a new list titled 'typedQuery'
		typedQuery.setParameter("selectedAuthor", authorName);			//set new parameters for the typedQuery list
		List<BookListItems> foundBooks = typedQuery.getResultList();			//returns a list of books that matched the search criteria
		em.close();														//closing the Entity Manager
		return foundBooks;
		}
	
		//search for book by name script
	public List<BookListItems> searchForBookByTitle(String bookTitle) {			//from StartProgram editABook method
		EntityManager em = emfactory.createEntityManager();			//new instance of Entity Manager Factory
		em.getTransaction().begin();
		TypedQuery<BookListItems> typedQuery = em.createQuery("select li from BookListItems li where li.book = :selectedBook", BookListItems.class);		//returns an object of a given parameter to a new list titled 'typedQuery'
		typedQuery.setParameter("selectedBook", bookTitle);			//set new parameters for the typedQuery list
		List<BookListItems> foundBooks = typedQuery.getResultList();		//returns a list of books that matched the search criteria
		em.close();													//closing the Entity Manager
		return foundBooks;
		}
	
	//Search for Book by ID script
	public BookListItems searchForBookById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();				//new instance of Entity Manager Factory
		em.getTransaction().begin();
		BookListItems found = em.find(BookListItems.class, idToEdit);				
		em.close();														//closing the Entity Manager
		return found;
		}

	
	//closing Entity Manager Factory
	public void cleanUp(){
		emfactory.close();
		}
}
