<%@include file="template/header.jsp" %>
<div class="container">
	<form action="SongController">
		<div class="field">
			<label class="label">Song Name:</label>
			<input class="input" type="text" name="name" value="${song.name}">
			<br>
			
			<label class="label">Artist:</label>
			<input class="input" type="text" name="artist" value="${song.artist}">
			<br>
			
			<label class="label">Album:</label>
			<input class="input" type="text" name="album" value="${song.album}">
			<br>
			
			<label class="label">Release Date:</label>
			<input class="input" type="text" name="releaseDate" value="${song.releaseDate}">
			<br>
			
			<label class="label">Gender:</label>
			<input class="input" type="text" name="gender" value="${song.gender}">
			<br><br>
			
			<input class="button is-primary" type="submit" name="btnSave" id="btnSave" value="Save">
			<a href="songs_list.jsp" class="button is-danger">Cancel</a>
		</div>
	</form>
</div>			
<%@include file="template/footer.jsp" %>