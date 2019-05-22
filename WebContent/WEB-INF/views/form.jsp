<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
 	<table>
		<tr>
			<th>Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Status</th>
		</tr>
		
			<tr>
				<td>${students.sName}</td>
				<td>${students.lName}</td>
				<td>${students.sAge}</td>
				<td>${students.activoDelegate}</td>
			</tr>
	</table>
	
	<br>
	
	<form:form action="${pageContext.request.contextPath}/formData" method="POST" modelAttribute="students">
 
 	<label>Ingrese un nombre:</label>
 	<form:input type="text" name="name" path="sName"/><br><br>
 	
 	<label>Ingrese un apellido:</label>
 	<form:input type="text" name="lname" path="lName"/><br><br>
 	
 	<label>Ingrese edad:</label>
 	<form:input type="number" name="age" path="sAge"/><br><br>
 	
 	<label>Estado del estudiante</label>
 	<form:radiobutton name="status" path="bActivo" value="true"/><label>ACTIVO</label>
 	<form:radiobutton name="status" path="bActivo" value="false"/><label>INACTIVO</label><br><br>
 	
 	<input type="submit" value="AGREGAR ESTUDIANTE">
 
 </form:form>
</body>
</html>
</html>

