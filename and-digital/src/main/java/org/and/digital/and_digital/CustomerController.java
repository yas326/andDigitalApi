package org.and.digital.and_digital;

import static spark.Spark.*;
import static org.and.digital.json.JsonUtil.*;

public class CustomerController {
	public CustomerController(final CustomerService customerService) {
		get("/customers", (req, res) -> customerService.getAllCustomers(), json());
		
		get("/customers/:id", (req, res) -> {
			String id = req.params(":id");
			Customer customer = customerService.getCustomer(id);
			if (customer != null) {
				return customer;
			}
			res.status(400);
			return new InvalidResponseError("No user with id '%s' found", id);
		}, json());

		post("/customers", (req, res) -> customerService.createNewCustomer(
				req.queryParams("id"),
				req.queryParams("name"),
				req.queryParams("phonenumber")), json());
		
		put("/customers/:id", (req, res) -> customerService.activateCustomer(
				req.params(":id"),
				req.queryParams("name"),
				req.queryParams("email")
		), json());

		after((req, res) -> {
			res.type("application/json");
		});

	}

}
