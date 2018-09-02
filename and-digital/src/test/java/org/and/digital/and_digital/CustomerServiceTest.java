package org.and.digital.and_digital;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;

import spark.Spark;
import spark.utils.IOUtils;

/**
 * Unit test for simple App.
 */
public class CustomerServiceTest {
	

	@BeforeClass
	public static void beforeClass() {
		Main.main(null);
	}

	@AfterClass
	public static void afterClass() {
		Spark.stop();
	}


	@Test
	public void testNewCustomerIsCreated() {
		TestResponse res = request("POST", "/customers?id=123&name=yasir&phonenumber=0798039876");
		Map<String, String> json = res.json();
		assertEquals(200, res.status);
		assertEquals("123", json.get("id"));
		assertEquals("yasir", json.get("name"));
		assertEquals("0798039876", json.get("phonenumber"));
		assertNotNull(json.get("id"));
		System.out.println(json);
	}
	

	private TestResponse request(String method, String path) {
		try {
			URL url = new URL("http://localhost:4567" + path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setDoOutput(true);
			connection.connect();
			String body = IOUtils.toString(connection.getInputStream());
			return new TestResponse(connection.getResponseCode(), body);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Sending request failed: " + e.getMessage());
			return null;
		}
	}

	private static class TestResponse {

		public final String body;
		public final int status;

		public TestResponse(int status, String body) {
			this.status = status;
			this.body = body;
		}

		@SuppressWarnings("unchecked")
		public Map<String, String> json() {
			return new Gson().fromJson(body, HashMap.class);
		}
	}
}
