package com.my.teller.aop.auditlog.constants;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditLoggable {

	UserAction startAction();
	UserAction completeAction();
	UserAction failAction() default UserAction.NONE;
	LogLevel level();
	String message() default "";
}
