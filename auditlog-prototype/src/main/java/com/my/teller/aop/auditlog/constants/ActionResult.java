package com.my.teller.aop.auditlog.constants;

public enum ActionResult {

	NO_RESULT("No result yet"),
	RESULT_OK("Successfull"),
	RESULT_FAIL("Failed");
	
	private String result;
	
	ActionResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return result;
	}
}
