<%@include file="template/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@include file="template/footer.jsp" %>