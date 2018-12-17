package utng.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import utng.model.Song;

public class SongDOM {
	private String pathFile = "/home/luis/eclipse-workspace/Unidad2/src/utng/data/songs.xml";

	public void add(Song data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			Element songs = document.getDocumentElement();
			Element song = document.createElement("song");

			// Id
			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(data.getId()));
			song.appendChild(id);

			// Name
			Element name = document.createElement("name");
			name.appendChild(document.createTextNode(data.getName()));
			song.appendChild(name);

			// Artist
			Element artist = document.createElement("artist");
			artist.appendChild(document.createTextNode(data.getArtist()));
			song.appendChild(artist);

			// Album
			Element album = document.createElement("album");
			album.appendChild(document.createTextNode(data.getAlbum()));
			song.appendChild(album);

			// Release date
			Element releaseDate = document.createElement("releaseDate");
			releaseDate.appendChild(document.createTextNode(data.getReleaseDate()));
			song.appendChild(releaseDate);

			// Gender
			Element gender = document.createElement("gender");
			gender.appendChild(document.createTextNode(data.getGender()));
			song.appendChild(gender);

			// Esta linea no me acuerdo para que es.
			songs.appendChild(song);
			// Write to file
			DOMHelper.saveXMLContent(document, pathFile);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(String id) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("song");
			for (int i = 0; i < nodelist.getLength(); i++) {
				Element song = (Element) nodelist.item(i);
				if (song.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					song.getParentNode().removeChild(song);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Song data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("song");
			for (int i = 0; i < nodelist.getLength(); i++) {
				Element song = (Element) nodelist.item(i);
				if (song.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					song.getElementsByTagName("name").item(0).setTextContent(data.getName());
					song.getElementsByTagName("artist").item(0).setTextContent(data.getArtist());
					song.getElementsByTagName("album").item(0).setTextContent(data.getAlbum());
					song.getElementsByTagName("releaseDate").item(0).setTextContent(data.getReleaseDate());
					song.getElementsByTagName("gender").item(0).setTextContent(data.getGender());
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Song findById(String id) {
		Song song = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("song");
			for (int i = 0; i < nodelist.getLength(); i++) {
				Element find = (Element) nodelist.item(i);
				if (find.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					song = new Song();
					song.setId(id);
					song.setName(find.getElementsByTagName("name").item(0).getTextContent());
					song.setArtist(find.getElementsByTagName("artist").item(0).getTextContent());
					song.setAlbum(find.getElementsByTagName("album").item(0).getTextContent());
					song.setReleaseDate(find.getElementsByTagName("releaseDate").item(0).getTextContent());
					song.setGender(find.getElementsByTagName("gender").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return song;
	}

	public List<Song> getSongs() {
		List<Song> songs = new ArrayList<Song>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("song");
		for (int i = 0; i < nodelist.getLength(); i++) {
			Element list = (Element) nodelist.item(i);
			Song song = new Song();
			song.setId(list.getElementsByTagName("id").item(0).getTextContent());
			song.setName(list.getElementsByTagName("name").item(0).getTextContent());
			song.setArtist(list.getElementsByTagName("artist").item(0).getTextContent());
			song.setAlbum(list.getElementsByTagName("album").item(0).getTextContent());
			song.setReleaseDate(list.getElementsByTagName("releaseDate").item(0).getTextContent());
			song.setGender(list.getElementsByTagName("gender").item(0).getTextContent());

			// Add
			songs.add(song);
		}
		return songs;
	}

}// End
