<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Price finder</title>
</head>
<body>
	<h2 color="red"> Price Finder </h2><hr/>
	<form action="getPrice">
		<label for="name"> Enter the game name </label>
		<input name="name" type="text"/>
		<button type="submit"> GetPrice </button>
	</form>
</body>
</html>