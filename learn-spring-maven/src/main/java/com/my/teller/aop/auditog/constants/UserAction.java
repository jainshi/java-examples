package com.my.teller.aop.auditog.constants;

public enum UserAction {

	STARTED("Started"),
	VIEWNG("Viewing"),
	COMPLETED("Completed"),
	FAILED("Failed"),
	NONE("None");
	
	private String action;
	
	UserAction(String action) {
		this.action = action;
	}
}
