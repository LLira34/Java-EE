<%@include file="template/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">

	<table class="table is-bordered">
		<thead class="thead">
			<tr class="tr">
				<th class="th">
					<form action="RecordController">
						<input class="button is-info" type="submit" name="btnNew" value="New">
					</form>
				</th>
				<th>ID</th>
				<th>Name</th>
				<th>Foundation</th>
				<th>Country</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach var="record" items="${records}">
			<tr>
				<td>
					<form action="RecordController">
						<input type="hidden" name="id" value="${record.id}">
						<input class="button is-warning" type="submit" name="btnEdit" value="Edit">
						<input class="button is-danger" type="submit" name="btnDelete" value="Delete">
					</form>
				</td>
				<td>${record.id}</td>
				<td>${record.name}</td>
				<td>${record.foundation}</td>
				<td>${record.country}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>
<%@include file="template/footer.jsp" %>