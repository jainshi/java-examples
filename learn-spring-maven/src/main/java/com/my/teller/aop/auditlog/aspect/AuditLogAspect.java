package com.my.teller.aop.auditlog.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.my.teller.aop.auditlog.constants.AuditLoggable;

@Aspect
public class AuditLogAspect {

	/**
	 * This method 
	 */
	@Pointcut("@annotation(com.my.teller.aop.auditlog.constants.AuditLoggable)")
	private void auditLoggingOperation() {
		
	}
	
	//@Around("execution(* com.my.teller.aop.auditlog.service.*Service.*(..))")
	//@Around("@annotation(com.my.teller.aop.auditlog.constants.AuditLoggable)")
	@Around("auditLoggingOperation() && @annotation(logInfo)")
	public Object logAround(ProceedingJoinPoint joinPoint, AuditLoggable logInfo) throws Throwable {
		System.out.println("AuditLog: The method " + joinPoint.getSignature().getName() + "() begins with " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("Action: " + logInfo.startAction());
		System.out.println("Log Level: " + logInfo.level());
		try {
			Object result = joinPoint.proceed();
			System.out.println("AuditLog: The method " + joinPoint.getSignature().getName() + "() ends with " + result);
			System.out.println("Action: " + logInfo.completeAction());
			System.out.println("Log Level: " + logInfo.level());
			return result;
		} catch (Exception e) {
			System.out.println("AuditLog: The method " + joinPoint.getSignature().getName() + "() fails " + Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			System.out.println("Action: " + logInfo.failAction());
			System.out.println("Log Level: " + logInfo.level());
			throw e;
		}
	}
	
	
}
