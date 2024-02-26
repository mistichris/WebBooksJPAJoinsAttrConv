package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BookListDetailsHelper;
import controller.BookListItemsHelper;
import controller.BookListOwnerHelper;
import controller.BookRatingsHelper;
import model.BookListDetails;

/**
 * Servlet implementation class EnterRatingsServlet
 */
@WebServlet("/EnterRatingsServlet")
public class EnterRatingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EnterRatingsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create instance of ListDetails via ListDetailsHelper -- includes ID, owner,
		// list of Items, date created
		BookListDetailsHelper daoDetailsHelper = new BookListDetailsHelper();
		// Pull Details with request.setAttribute
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		BookListDetails listToEdit = daoDetailsHelper.searchForBookListDetailsById(tempId);
//		request.setAttribute("listToEdit", listToEdit);
		// Get list of books for list
		BookListItemsHelper blih = new BookListItemsHelper();
		List<BookListDetails> abc = blih.showAllBooks();
		request.setAttribute("allLists", abc);
		
		
		BookRatingsHelper brh = new BookRatingsHelper();

		BookListOwnerHelper bloh = new BookListOwnerHelper();

		// doGet(request, response);

	}

}
