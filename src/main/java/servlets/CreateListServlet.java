package servlets;

import java.io.IOException;
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
import model.BookListDetails;
import model.BookListItems;
import model.BookListOwner;

/**
 * Servlet implementation class CreateListServlet
 */
@WebServlet("/CreateListServlet")
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

		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<BookListItems> selectedItemsInList = new ArrayList<BookListItems>();
		// make sure something was selected – otherwise we get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				BookListItems c = blih.searchForBookById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}

		BookListOwner owner = new BookListOwner(ownerFName, ownerLName);
		BookListDetails bld = new BookListDetails(listName, owner, selectedItemsInList);
		bld.setListOfItems(selectedItemsInList);
		BookListDetailsHelper bldh = new BookListDetailsHelper();
		bldh.insertBookListDetails(bld);

		System.out.println("Success!");
		System.out.println(bld.toString());
		request.setAttribute("listToEdit", bld);

		getServletContext().getRequestDispatcher("/add-ratings.jsp").forward(request, response);
//		getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
