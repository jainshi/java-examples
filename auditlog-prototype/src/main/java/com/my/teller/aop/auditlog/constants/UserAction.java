package com.my.teller.aop.auditlog.constants;

public enum UserAction {

	OPEN_TELLER("Open teller"),
	CLOSE_TELLER("Close teller"),
	CREATE_TELLER("Create teller");
	
	
	/*STARTED("Started"),
	VIEWNG("Viewing"),
	COMPLETED("Completed"),
	FAILED("Failed"),
	NONE("None");*/
	
	private String action;
	
	UserAction(String action) {
		this.action = action;
	}
}
