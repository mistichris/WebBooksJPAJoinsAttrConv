package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BookListItemsHelper;
import model.BookListItems;

@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NavigationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookListItemsHelper displayAll = new BookListItemsHelper();
		String act = request.getParameter("doThisToBook");
		//after all changes, we should redirect to the viewAllBooks servlet
		//The only time we don't is if they select to add a new book or edit
		String path = "/ViewAllBooksServlet";
				
		if(act.equals("Delete")) {
			try {
				
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			BookListItems bookToDelete = displayAll.searchForBookById(tempId);
			displayAll.deleteBook(bookToDelete);
			} catch (NumberFormatException e){
				System.out.println("Forgot to select a book");
			}
		}else if (act.equals("Edit")) {							//redirect to edit-book jsp/Edit Book Servlet than circles back around to View all books servlet/booklist
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			BookListItems bookToEdit = displayAll.searchForBookById(tempId);
			request.setAttribute("bookToEdit", bookToEdit);
			path = "/edit-book.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a Book");
			}
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);			//redirects back to the view all books servlet/booklist jsp after delete
		
		
	}

	}

