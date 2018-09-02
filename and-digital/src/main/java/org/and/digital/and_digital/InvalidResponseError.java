package org.and.digital.and_digital;

public class InvalidResponseError {

	private String message;

	public InvalidResponseError(String message, String... args) {
		this.message = String.format(message, args);
	}

	public InvalidResponseError(Exception e) {
		this.message = e.getMessage();
	}

	public String getMessage() {
		return this.message;
	}
}
