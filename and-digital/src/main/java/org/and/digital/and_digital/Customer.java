package org.and.digital.and_digital;

public class Customer {
	
	private String id;
	private String name;
	private String phonenumber;
	
	public Customer(String id, String name, String phonenumber) {
		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
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
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}
