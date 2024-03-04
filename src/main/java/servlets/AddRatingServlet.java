package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BookListDetailsHelper;
import controller.BookListItemsHelper;
import controller.BookRatingsHelper;
import model.BookListDetails;
import model.BookListItems;
import model.BookListOwner;
import model.BookRatings;

/**
 * Servlet implementation class AddRatingServlet
 */
@WebServlet("/AddRatingServlet")
public class AddRatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddRatingServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookListItemsHelper blih = new BookListItemsHelper();
		
		BookRatingsHelper brh = new BookRatingsHelper();
		String listId= request.getParameter("listid");
		String bookId= request.getParameter("bookid");
		String rating= request.getParameter("rating");
		String date= request.getParameter("date");
		
		//change rating into int
		int bookRating = Integer.parseInt(rating);
		
		//change date into localdate	
		LocalDate localDate = LocalDate.parse(date);
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Date localDate = format.parse(date);
		
		
		//create booklistdetailshelper
		BookListDetailsHelper bldh = new BookListDetailsHelper();
		
		//parse listid and bookid to an int--validate id's are valid
		int intListId = Integer.parseInt(listId);
		int intBookId = Integer.parseInt(bookId);
		BookListDetails listToEdit = bldh.searchForBookListDetailsById(intListId);
		BookListItems bookToAdd = blih.searchForBookById(intBookId);
		
		BookRatings br = new BookRatings(bookRating, localDate, bookToAdd);
		
		//add rating into list in listdetails via helper	
		listToEdit.getListOfRatings().add(br);
			
		//create array of ratings
		//create array of books
		
		//insert rating, date, string of books into rating string
		
		
		
//		String[] ratings = request.getParameterValues("rating");
//		String[]dates = request.getParameterValues("date");
//		
//		BookRatingsHelper brh = new BookRatingsHelper();
//		List<BookRatings> bookListItemRatings = new ArrayList<BookRatings>();
//		
//		
//		if (inputRatings != null && inputRatings.length > 0) {
//			for (int i = 0; i < inputRatings.length; i++) {
//				System.out.println(inputRatings[i]);
//				BookRatings c = brh.searchForBookById(Integer.parseInt(inputRatings[i]));
//				bookListItemRatings.add(c);
//			}
//		}
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
//		formatter = formatter.withLocale(null);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
//		LocalDate readDate = LocalDate.parse("2005-nov-12", formatter);
		
		
//		String[] selectedItems = request.getParameterValues("allItemsToAdd");
////		List<BookListItems> selectedItemsInList = new ArrayList<BookListItems>();
//		// make sure something was selected – otherwise we get a null pointer exception
//		if (selectedItems != null && selectedItems.length > 0) {
//			for (int i = 0; i < selectedItems.length; i++) {
//				System.out.println(selectedItems[i]);
//				BookListItems c = blih.searchForBookById(Integer.parseInt(selectedItems[i]));
//				selectedItemsInList.add(c);
//			}
//		}
		
//		String[] inputRatings = request.getParameterValues("ratingsToAdd");


//		BookListOwner owner = new BookListOwner(ownerFName, ownerLName);
//		
//		BookListDetails bld = new BookListDetails(listName, owner);
////		bld.setListOfItems(selectedItemsInList);
////		bld.setListOfRatings(bookListItemRatings);
//		bldh.insertBookListDetails(bld);
//
//		System.out.println("Success!");
//		System.out.println(bld.toString());
//		request.setAttribute("listToEdit", bld);
		
		request.setAttribute("allItems", blih.showAllBooks());
		request.setAttribute("listToEdit", listToEdit);

		getServletContext().getRequestDispatcher("/add-ratings.jsp").forward(request, response);
//		getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}

/*
 * <form action="AddRatingServlet" method="post"> <h1>Add Ratings and Read Dates
 * to Books</h1> <!-- List Details: Owner: List Name: Created Date --> <!-- List
 * books in Read Books list --> <input type="hidden" name="listid"
 * value="${requestScope.listToEdit.id}">
 * <h2>${requestScope.listToEdit.listName}</h2> Created By:
 * ${requestScope.listToEdit.bookListOwner} On:
 * ${requestScope.listToEdit.createdDate} <select> <option
 * value="default">Default Option</option> <c:forEach
 * items="${requestScope.allItems}" var="currentItem"> <option
 * value="${currentItem.id}" id="bookid">${currentItem.book}| ${currentItem.author} |
 * ${currentItem.genre}</option> </c:forEach> </select> <!-- Make fields to
 * enter date and ratings --> <label for="rating">Rate Book: </label><input
 * type="number" name="rating" placeholder="1-5"> <label
 * for="date"></label><input type="date" name="date"><input type="submit"
 * value="Add Book/Continue" name="addRatings">
 * 
 * </form>
 */