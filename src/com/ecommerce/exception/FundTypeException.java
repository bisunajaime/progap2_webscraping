package com.ecommerce.exception;

public class FundTypeException extends Exception {
	public FundTypeException() {
		super("Fund Type not Found. Only choose from [SALEF, SALBF, and SALFIF]");
	}
}
