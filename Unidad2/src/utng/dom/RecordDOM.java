package utng.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import utng.model.Record;

public class RecordDOM {
	private String pathFile = "/home/luis/eclipse-workspace/Unidad2/src/utng/data/records.xml";

	public void add(Record data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			Element records = document.getDocumentElement();
			Element record = document.createElement("record");

			// Id
			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(data.getId()));
			record.appendChild(id);

			// Name
			Element name = document.createElement("name");
			name.appendChild(document.createTextNode(data.getName()));
			record.appendChild(name);

			// Foundation
			Element foundation = document.createElement("foundation");
			foundation.appendChild(document.createTextNode(String.valueOf(data.getFoundation())));
			record.appendChild(foundation);

			// Country
			Element country = document.createElement("country");
			country.appendChild(document.createTextNode(data.getCountry()));
			record.appendChild(country);

			// Esta linea verga
			records.appendChild(record);
			// Write to file
			DOMHelper.saveXMLContent(document, pathFile);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(String id) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("record");
			for (int i = 0; i < nodelist.getLength(); i++) {
				Element record = (Element) nodelist.item(i);
				if (record.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					record.getParentNode().removeChild(record);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Record data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("record");
			for (int i = 0; i < nodelist.getLength(); i++) {
				Element record = (Element) nodelist.item(i);
				if (record.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					record.getElementsByTagName("name").item(0).setTextContent(data.getName());
					record.getElementsByTagName("foundation").item(0)
							.setTextContent(String.valueOf(data.getFoundation()));
					record.getElementsByTagName("country").item(0).setTextContent(data.getCountry());
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Record findById(String id) {
		Record record = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("record");
			for (int i = 0; i < nodelist.getLength(); i++) {
				Element find = (Element) nodelist.item(i);
				if (find.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					record = new Record();
					record.setId(id);
					record.setName(find.getElementsByTagName("name").item(0).getTextContent());
					record.setFoundation(
							Integer.parseInt(find.getElementsByTagName("foundation").item(0).getTextContent()));
					record.setCountry(find.getElementsByTagName("country").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}

	public List<Record> getRecords() {
		List<Record> records = new ArrayList<Record>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("record");
		for (int i = 0; i < nodelist.getLength(); i++) {
			Element list = (Element) nodelist.item(i);
			Record record = new Record();
			record.setId(list.getElementsByTagName("id").item(0).getTextContent());
			record.setName(list.getElementsByTagName("name").item(0).getTextContent());
			record.setFoundation(Integer.parseInt(list.getElementsByTagName("foundation").item(0).getTextContent()));
			record.setCountry(list.getElementsByTagName("country").item(0).getTextContent());

			// Add
			records.add(record);
		}
		return records;
	}

}// End
