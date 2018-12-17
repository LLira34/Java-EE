package utng.model;

import java.io.Serializable;

public class Song implements Serializable {

	private String id;
	private String name;
	private String artist;
	private String album;
	private String releaseDate; // <-----
	private String gender;

	public Song() {
		this("", "", "", "", "", "");
	}

	public Song(String id, String name, String artist, String album, String releaseDate, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.releaseDate = releaseDate;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", album=" + album + ", releaseDate="
				+ releaseDate + ", gender=" + gender + "]";
	}

}// End
