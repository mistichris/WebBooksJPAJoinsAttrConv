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
	<form action="EnterRatingsServlet" method="post">
		<h1>Add Ratings and Read Dates to Books</h1>
		<!-- List Details: Owner: List Name: Created Date -->
		<!-- List books in Read Books list -->
		<table>
			<tr>
				<td><input type="hidden" name="id"
					value="${requestScope.listToEdit.id}"></td>
				<td colspan="2"><h2>${requestScope.listToEdit.listName}</h2></td>
			</tr>
			<tr>
				<td colspan="4">Created By: ${requestScope.listToEdit.bookListOwner}
					On: ${requestScope.listToEdit.createdDate}</td>
			</tr>
			<tr>
				<c:forEach items="${currentlist.allBooks}" var="bookList">
					<tr>
						<td colspan="5">Title Author Genre Rating DateRead</td>
						<td colspan="">${bookList.book},${bookLIst.author},
							${bookList.genre} <input type="text" name="" placeholder="1-5">
							<input>
						</td>
						<!-- Make fields to enter date and ratings -->
						<td colspan="2"><label for="rating">Rate Book: </label><input
							type="text" name="rating" placeholder="1-5"></td>
						<td colspan="2"><label for="date"></label><input type="text"
							name="date" placeholder="MM/DD/YYYY"></td>
						<td></td>
					</tr>
				</c:forEach>
			</tr>
		</table>
		<input type="submit" value="Enter Ratings" name="addRatings">
	</form>

</body>
</html>

<c:forEach items="${requestScope.allLists}" var="currentlist">
	<tr>
		<td><input type="radio" name="id" value="${currentlist.id}"></td>
		<td><h2>${currentlist.listName}</h2></td>
	</tr>
	<tr>
		<td colspan="3">Trip Date: ${currentlist.ownerFName}
			${currentlist.ownerLName}</td>
	</tr>
	<c:forEach items="${currentlist.listOfItems}" var="listVal">
		<tr>
			<td></td>
			<td colspan="3">${listVal.book},${listVal.author},
				${listVal.genre}</td>
		</tr>
	</c:forEach>
</c:forEach>