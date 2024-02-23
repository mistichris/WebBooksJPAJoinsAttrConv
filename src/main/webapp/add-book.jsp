<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add To Book LIst</title>
</head>
<body>
<form action="AddBookServlet" method="post">
		<h2>Add a Book to Book List</h2>
		<p>
			Book Title: <input type="text" name="book">
		</p>
		<p>
			Author: <input type="text" name="author">
		</p>
				<p>
			Genre: <input type="text" name="genre">
		</p>
		<input type="submit" name="Add Item">
	</form>
</body>
</html>