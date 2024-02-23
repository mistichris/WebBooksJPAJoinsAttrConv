<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Lists Page</title>
</head>
<body>
	//list all lists with radio buttons for submission
	<h1>Books Read Database List</h1>
	<form method="post" action="NavigationAllListsServlet">
		<table>
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
		</table>
		<input type="submit" value="Edit List" name="doThisToList"> <input
			type="submit" value="Delete List" name="doThisToList"> <input
			type="submit" value="Add a New List" name="doThisToList">
	</form>
	<br />

	<form>
		<table>
		</table>
		<input type="submit" name="Add Item">
	</form>


<!-- Additional Navigation Buttons -->
	<form action="ViewAllBooksServlet" method="get">
		<button type="submit">View Books List</button>
	</form>
	<button onclick="window.location.href='index.html'">Main Menu</button>
	
</body>
</html>