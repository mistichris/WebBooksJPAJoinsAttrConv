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
	<form action="CreateListServlet" method="post">
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

		<h2>Available Items:</h2>
		<select name="allItemsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.book}|
					${currentitem.author}|${currentitem.genre}</option>
			</c:forEach>
		</select> <input type="submit" value="Create List and Add Items">
	</form>
	<button onclick="window.location.href='add-book.jsp'">Add
		Books Instead</button>
	<!-- 	<a href="add-book.jsp">Go add new items instead.</a> -->

</body>
</html>

<!-- 	<div>
						Trip date: <input type="text" name="month" placeholder="mm"
							size="4"> <input type="text" name="day" placeholder="dd"
							size="4">, <input type="text" name="year"
							placeholder="yyyy" size="4">
					</div> -->