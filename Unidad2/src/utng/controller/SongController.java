package utng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dom.SongDOM;
import utng.model.Song;

/**
 * Servlet implementation class SongController
 */
@WebServlet("/SongController")
public class SongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Song song;
	private List<Song> songs;
	private SongDOM songDOM;
	private List<String> ids = new ArrayList<String>();

	public SongController() {
		super();
		song = new Song();
		songs = new ArrayList<Song>();
		songDOM = new SongDOM();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("btnSave") != null) {

			song.setName(request.getParameter("name"));
			song.setArtist(request.getParameter("artist"));
			song.setAlbum(request.getParameter("album"));
			song.setReleaseDate(request.getParameter("releaseDate"));
			song.setGender(request.getParameter("gender"));

			if (song.getId() == "") {
				String newId = "lbl" + String.format("%03d", 1);
				song.setId(newId);
				if (songs.size() > 0) {
					ids.clear();
					for (Song s : songs) {
						ids.add(s.getId());
					}
					for (int i = 0; i < ids.size(); i++) {
						newId = "lbl" + String.format("%03d", i + 1);
						if (!ids.contains(newId)) {
							song.setId(newId);
							break;
						}
					}
				}
				songDOM.add(song);
			} else {
				songDOM.update(song);
			}
			songs = songDOM.getSongs();
			request.setAttribute("songs", songs);
			request.getRequestDispatcher("songs_list.jsp").forward(request, response);

		} else if (request.getParameter("btnNew") != null) {
			song = new Song();
			request.getRequestDispatcher("songs_form.jsp").forward(request, response);

		} else if (request.getParameter("btnEdit") != null) {
			try {
				String id = request.getParameter("id");
				song = songDOM.findById(id);
			} catch (Exception e) {
				song = new Song();
			}
			request.setAttribute("song", song);
			request.getRequestDispatcher("songs_form.jsp").forward(request, response);
		}

		if (request.getParameter("btnDelete") != null) {
			try {
				String id = request.getParameter("id");
				songDOM.delete(id);
				songs = songDOM.getSongs();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("songs", songs);
			request.getRequestDispatcher("songs_list.jsp").forward(request, response);
		} else {
			songs = songDOM.getSongs();
			request.setAttribute("songs", songs);
			request.getRequestDispatcher("songs_list.jsp").forward(request, response);
		}

	}// End doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}// End
