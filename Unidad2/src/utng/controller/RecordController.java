package utng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dom.RecordDOM;
import utng.model.Record;
import utng.model.Song;

/**
 * Servlet implementation class RecordController
 */
@WebServlet("/RecordController")
public class RecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Record record;
	private List<Record> records;
	private RecordDOM recordDOM;
	private List<String> ids = new ArrayList<String>();

	public RecordController() {
		super();
		record = new Record();
		records = new ArrayList<Record>();
		recordDOM = new RecordDOM();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btnSave") != null) {

			record.setName(request.getParameter("name"));
			try {
				record.setFoundation(Integer.parseInt(request.getParameter("foundation"))); }
			catch (NumberFormatException e) { 
				record.setFoundation(10); 
			}
			record.setCountry(request.getParameter("country"));
			

			if (record.getId() == "") {
				int id = 1;
				String newId = "lbl" + String.format("%03d", 1);
				record.setId(newId);
				if (records.size() > 0) {
					ids.clear();
					for (Record r : records) {
						ids.add(r.getId());
					}
					for (int i = 0; i < ids.size(); i++) {
						newId = "lbl" + String.format("%03d", i + 1);
						if (!ids.contains(newId)) {
							record.setId(newId);
							break;
						}
					}
				}
				recordDOM.add(record);
			} else {
				recordDOM.update(record);
			}
			records = recordDOM.getRecords();
			request.setAttribute("records", records);
			request.getRequestDispatcher("records_list.jsp").forward(request, response);

		}else if (request.getParameter("btnNew") != null) {
			record = new Record();
			request.getRequestDispatcher("records_form.jsp").forward(request, response);
		}else if (request.getParameter("btnEdit") != null) {
			try {
				String id = request.getParameter("id");
				record = recordDOM.findById(id);
			} catch (Exception e) {
				record = new Record();
			}
			request.setAttribute("record", record);
			request.getRequestDispatcher("records_form.jsp").forward(request, response);
		}
		
		if (request.getParameter("btnDelete") != null) {
			try {
				String id = request.getParameter("id");
				recordDOM.delete(id);
				records = recordDOM.getRecords();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("records", records);
			request.getRequestDispatcher("records_list.jsp").forward(request, response);
		} else {
			records = recordDOM.getRecords();
			request.setAttribute("records", records);
			request.getRequestDispatcher("records_list.jsp").forward(request, response);
		}
		
		
	}// End doGet

}// End
