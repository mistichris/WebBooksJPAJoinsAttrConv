<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Ratings to New List Page</title>
</head>
<body>
	<form action="AddRatingServlet" method="get">
		<h1>Add Ratings and Read Dates to Books</h1>
		<!-- List Details: Owner: List Name: Created Date -->
		<!-- List books in Read Books list -->
		<input type="hidden" name="listid" value="${requestScope.listToEdit.id}">
		<h2>${requestScope.listToEdit.listName}</h2>
		Created By: ${requestScope.listToEdit.bookListOwner} On:
		${requestScope.listToEdit.createdDate} <select name="bookid">
			<option value="default">Default Option</option>
			<c:forEach items="${requestScope.allItems}" var="currentItem">
				<option value="${currentItem.id}" id="bookid"s>${currentItem.book}|
					${currentItem.author} | ${currentItem.genre}</option>
			</c:forEach>
		</select>
		<!-- Make fields to enter date and ratings -->
 		<label for="rating">Rate Book: </label><input type="number"
			name="rating" placeholder="1-5"> <label for="date"></label><input
			type="date" name="date"><input
			type="submit" value="Add Book/Continue" name="addRatings"> 
			
	</form>
	<form action="ViewAllListsServlet" method="get">
		<button type="submit">Finish/Return To All Lists Page</button>
	</form>
	<form action="ViewAllBooksServlet" method="get">
		<button type="submit">View Books List</button>
	</form>
	
</body>
</html>
