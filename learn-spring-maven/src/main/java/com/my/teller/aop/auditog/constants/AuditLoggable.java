package com.my.teller.aop.auditog.constants;

public @interface AuditLoggable {

	UserAction startAction();
	UserAction completeAction();
	UserAction failAction() default UserAction.NONE;
	LogLevel level();
	
}
