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
		<div>
			<table>
				<c:forEach items="${requestScope.allItems}" var="currentbook">
					<tr>
						<td>c<input type="checkbox" name="id"
							value="${currentbook.id}"></td>
						<td>a${currentbook.book}</td>
						<td>c${currentbook.author}</td>
						<td>a${currentbook.genre}</td>
						<td>cRating: <input type="text" name="rating"
							placeholder="1-5"></td>
						<td>aFinished Reading Date: <input type="text" name="month"
							placeholder="mm">size="4"> <input type="text" name="day"
							placeholder="dd" size="4">, <input type="text"
							name="year" placeholder="yyyy" size="4"></td>
						<td>c</td>
					</tr>
					<!-- 	<div>
						Trip date: <input type="text" name="month" placeholder="mm"
							size="4"> <input type="text" name="day" placeholder="dd"
							size="4">, <input type="text" name="year"
							placeholder="yyyy" size="4">
					</div> -->
				</c:forEach>
			</table>
		</div>
		<input type="submit" value="Create List and Add Items">
	</form>
	<a href="index.html">Go add new items instead.</a>

</body>
</html>