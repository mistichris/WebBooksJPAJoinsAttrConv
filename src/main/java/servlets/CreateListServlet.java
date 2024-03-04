package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
 * Servlet implementation class CreateListServlet
 */
@WebServlet("/createListServlet")
public class CreateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookListItemsHelper blih = new BookListItemsHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		String ownerFName = request.getParameter("firstName");
		String ownerLName = request.getParameter("lastName");
		
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


		BookListOwner owner = new BookListOwner(ownerFName, ownerLName);
		
		BookListDetails bld = new BookListDetails(listName, owner);
//		bld.setListOfItems(selectedItemsInList);
//		bld.setListOfRatings(bookListItemRatings);
		BookListDetailsHelper bldh = new BookListDetailsHelper();
		bldh.insertBookListDetails(bld);

		System.out.println("New List and Owner created");
		System.out.println(bld.toString());
		request.setAttribute("listToEdit", bld);
		
		BookListItemsHelper daoForItems = new BookListItemsHelper();
		request.setAttribute("allItems", daoForItems.showAllBooks());

		getServletContext().getRequestDispatcher("/add-ratings.jsp").forward(request, response);
//		getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
