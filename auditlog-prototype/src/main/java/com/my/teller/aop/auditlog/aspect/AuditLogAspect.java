package com.my.teller.aop.auditlog.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.my.teller.aop.auditlog.constants.ActionResult;
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
		String methodName = joinPoint.getSignature().getName();
		String arguments = Arrays.toString(joinPoint.getArgs());
		
		printLogInfo(logInfo, ActionResult.NO_RESULT, methodName, arguments);
		
		try {
			Object result = joinPoint.proceed();
			printLogInfo(logInfo, ActionResult.RESULT_OK, methodName, arguments);
			return result;
		} catch (Exception e) {
			printLogInfo(logInfo, ActionResult.RESULT_FAIL, methodName, arguments);
			throw e;
		}
	}
	
	private void printLogInfo(final AuditLoggable logInfo, ActionResult result, String methodName, String arguments) {
		System.out.println("AuditLog: The method " + methodName + "() with parameters " + arguments);
		 System.out.println("Action Result " + result.getResult());
		
		System.out.println("Log Category: " + logInfo.category());
		System.out.println("Action: " + logInfo.action());
		System.out.println("Service Id: " + logInfo.serviceId());
	}
	
}
