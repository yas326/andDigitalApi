package org.and.digital.and_digital;

import java.util.*;
import org.apache.commons.lang3.StringUtils;


public class CustomerService {
	

	private Map<String, Customer> customers = new HashMap<String, Customer>();

	public List<Customer> getAllCustomers() {
		return new ArrayList<Customer>(customers.values());
	}

	public Customer getCustomer(String id) {
		return customers.get(id);
	}

	public Customer createNewCustomer(String id, String name, String phonenumber) {
		failIfFieldsNullOrEmpty(name, phonenumber);
		Customer customer = new Customer(id, name, phonenumber);
		customers.put(customer.getId(), customer);
		
		return customer;

	}

	public Customer activateCustomer(String id, String name, String phonenumber) {
		Customer customer = customers.get(id);
		if(customer == null) {
			throw new IllegalArgumentException("Customer with the id: " + id + "not found");
		}
		failIfFieldsNullOrEmpty(name, phonenumber);
		customer.setName(name);
		customer.setPhonenumber(phonenumber);
		System.out.println("Customer Phonenumber is now activated");
		
		return customer;
	}
		
	
	private void failIfFieldsNullOrEmpty(String name, String phonenumber) {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("Parameter 'name' cannot be empty");
		}

		if (StringUtils.isEmpty(phonenumber)) {
			throw new IllegalArgumentException("Parameter 'phonenumber' cannot be empty");
		}
	}

}
