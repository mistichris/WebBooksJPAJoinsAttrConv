package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BookListItemsHelper;
import model.BookListItems;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBookServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book = request.getParameter("book");
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");		
		BookListItems li = new BookListItems(author, book, genre);
		BookListItemsHelper doa = new BookListItemsHelper();
		doa.insertBook(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
