<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Song List</title>
		<link rel="stylesheet" type="text/css" 
		href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
	</head>
	<body>
		<div class="container">
			<table class="table">
				<thead class="thead">
					<tr class="tr">
						<th class="th">
							<form action="SongController">
								<input class="button is-info" type="submit" name="btnNew" value="New">
							</form>
						</th>
						<th>ID</th>
						<th>Name</th>
						<th>Artist</th>
						<th>Album</th>
						<th>Release Date</th>
						<th>Gender</th>
					</tr>
				</thead>
				<tbody class="tbody">
					<c:forEach var="song" items="${songs}">
					<tr>
						<td>
							<form action="SongController">
								<input type="hidden" name="id" value="${song.id}">
								<input class="button is-warning" type="submit" name="btnEdit" value="Edit">
								<input class="button is-danger" type="submit" name="btnDelete" value="Delete">
							</form>
						</td>
						<td>${song.id}</td>
						<td>${song.name}</td>
						<td>${song.artist}</td>
						<td>${song.album}</td>
						<td>${song.releaseDate}</td>
						<td>${song.gender}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>