package utng.model;

import java.io.Serializable;

public class Record implements Serializable{
	private String id;
	private String name;
	private int foundation;
	private String country;
	
	public Record(String id, String name, int fundation, String country) {
		super();
		this.id = id;
		this.name = name;
		this.foundation = fundation;
		this.country = country;
	}

	public Record() {
		this("", "", 0, "");
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

	public int getFoundation() {
		return foundation;
	}

	public void setFoundation(int foundation) {
		this.foundation = foundation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}// End
