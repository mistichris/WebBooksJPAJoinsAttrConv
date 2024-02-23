package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BookListDetailsHelper;
import controller.BookListItemsHelper;
import model.BookListDetails;

/**
 * Servlet implementation class NavigationAllListsServlet
 */
@WebServlet("/NavigationAllListsServlet")
public class NavigationAllListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationAllListsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookListDetailsHelper dao = new BookListDetailsHelper();
		String act = request.getParameter("doThisToList");

		if (act == null) { // no button has been selected
			getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
		} else if (act.equals("Delete List")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				BookListDetails listToDelete = dao.searchForBookListDetailsById(tempId);
				dao.deleteList(listToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		} else if (act.equals("Edit List")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				BookListDetails listToEdit = dao.searchForBookListDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
//				request.setAttribute("month", listToEdit.getTripDate().getMonthValue());
//				request.setAttribute("date", listToEdit.getTripDate().getDayOfMonth());
//				request.setAttribute("year", listToEdit.getTripDate().getYear());
				BookListItemsHelper daoForItems = new BookListItemsHelper();
				request.setAttribute("allBooks", daoForItems.showAllBooks());
				if (daoForItems.showAllBooks().isEmpty()) {
					request.setAttribute("allBooks", " ");
				}
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
			}
		} else if (act.equals("Add Book to List")) {
			getServletContext().getRequestDispatcher("/new-list.html").forward(request, response);
		}
	}
}
