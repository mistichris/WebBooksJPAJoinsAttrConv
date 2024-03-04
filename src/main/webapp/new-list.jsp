<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Books Read List</title>
</head>
<body>
	<form action="createListServlet" method="post">
		<div>
			<label for="listName">List Name</label> <input type="text"
				name="listName">
		</div>
		<div>
			<label for="firstName">List Owner First Name</label> <input
				type="text" name="firstName">
		</div>
		<div>
			<label for="lastName">List Owner Last Name</label> <input type="text"
				name="lastName">
		</div>

<%-- 		<h2>Select Books and add Ratings:</h2>
		<!-- for loop inside a for loop; add one at a time-->
		<div>
		<c:forEach items="${requestScope.allItems}" var="currentItem">
				<input type="checkbox" id="allItemsToAdd" name="allItemsToAdd"
					value="${currentItem.id}">
				<table>
					<tr>
						<td></td>
						<td colspan="2">Title: ${currentItem.book}</td>
						<td colspan="2">Author: ${currentItem.author}</td>
						<td colspan="2">Genre: ${currentItem.genre}</td>
					</tr>
				</table>
			</c:forEach>
		</div> --%>
		
		
		<input type="submit" name="createList"  value="Continue to Add Books">
	</form>
	
	<form action="ViewAllBooksServlet" method="get">
		<button type="submit">View Books List</button>
	</form>
		<form action="ViewAllListsServlet" method="get">
		<button type="submit">View Books Read Lists</button>
	</form>
	
	<!-- 	<a href="add-book.jsp">Go add new items instead.</a> -->

</body>
</html>


<%-- 				
					<form>
						<td></td>
						<input type="hidden" id="" value="${}>
						<td colspan="3">Rating: <input type="text" id="ratingToAdd" name="rating" placeholder="1-5"></td>
						<td colspan="3">Read On: <input type="date" id="ratingToAdd" name="date"></td>
					</form> --%>
<!-- 	<div>
						Trip date: <input type="text" name="month" placeholder="mm"
							size="4"> <input type="text" name="day" placeholder="dd"
							size="4">, <input type="text" name="year"
							placeholder="yyyy" size="4">
					</div> -->