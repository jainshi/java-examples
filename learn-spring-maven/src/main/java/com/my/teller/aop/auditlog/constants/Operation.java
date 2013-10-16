package com.my.teller.aop.auditlog.constants;

public enum Operation {

	JOURNAL_SEARCH("Journal Search"),
	TELLER("Teller");
	
	private String operation;
	
	Operation(String operation) {
		this.operation = operation;
	}
}
