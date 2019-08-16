package com.ecommerce.exception;

public class InvestmentAmountException extends Exception {
	public InvestmentAmountException() {
		super("Investment amount must be greater than or equal to 5000");
	}
}
