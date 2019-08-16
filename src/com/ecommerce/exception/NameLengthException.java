package com.ecommerce.exception;

public class NameLengthException extends Exception {
	public NameLengthException() {
		super("Invalid name length. Name length must contain 6 to 30 characters.");
	}
}
