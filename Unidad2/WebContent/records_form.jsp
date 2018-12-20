<%@include file="template/header.jsp" %>
<div class="container">
	<form action="RecordController">
		<div class="field">
			<label class="label">Record Name:</label>
			<input class="input" type="text" name="name" value="${record.name}" required="required">
			<br>
			
			<label class="label">Foundation:</label>
			<input class="input" type="text" name="foundation" value="${record.foundation}" required="required">
			<br>
			
			<label class="label">Country:</label>
			<input class="input" type="text" name="country" value="${record.country}" required="required">
			<br><br>
			
			<input class="button is-primary" type="submit" name="btnSave" id="btnSave" value="Save">
			<a href="records_list.jsp" class="button is-danger">Cancel</a>
		</div>
	</form>
</div>			
<%@include file="template/footer.jsp" %>