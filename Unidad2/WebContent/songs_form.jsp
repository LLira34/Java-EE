<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Song Form</title>
		<link rel="stylesheet" type="text/css" 
		href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
	</head>
	
	<body>
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
		
	</body>
</html>