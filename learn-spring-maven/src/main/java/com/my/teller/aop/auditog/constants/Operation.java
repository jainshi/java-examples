package com.my.teller.aop.auditog.constants;

public enum Operation {

	JOURNAL_SEARCH("Journal Search"),
	TELLER("Teller");
	
	private String operation;
	
	Operation(String operation) {
		this.operation = operation;
	}
}
