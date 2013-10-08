package test.spring.aspect.calculator;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;

@Aspect
public class CalculatorLoggingAspect implements Ordered {
	private Log log = LogFactory.getLog(this.getClass());

	@Before("execution(* ArithmeticCalculator.add(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.info("The method add() begins");
		log.info("The method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
	}

	@After("execution(* *.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		log.info("The method " + joinPoint.getSignature().getName() + "() ends");
	}

	@AfterReturning("execution(* *.*(..))")
	public void logAfterReturning(JoinPoint joinPoint) {
		log.info("The method " + joinPoint.getSignature().getName() + "() ends");
	}

	@AfterReturning(pointcut = "execution(* *.*(..))", returning = "result")
	public void logAfterReturning2(JoinPoint joinPoint, Object result) {
		log.info("The method " + joinPoint.getSignature().getName()
				+ "() ends with " + result);
	}

	@AfterThrowing("execution(* *.*(..))")
	public void logAfterThrowing(JoinPoint joinPoint) {
		log.error("An exception has been thrown in "
				+ joinPoint.getSignature().getName() + "()");
	}

	@AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "e")
	public void logAfterThrowing2(JoinPoint joinPoint, Throwable e) {
		log.error("An exception " + e + " has been thrown in "
				+ joinPoint.getSignature().getName() + "()");
	}

	@Around("execution(* *.*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("The method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
		try {
			Object result = joinPoint.proceed();
			log.info("The method " + joinPoint.getSignature().getName()
					+ "() ends with " + result);
			return result;
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument "
					+ Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}

	public int getOrder() {
		return 1;
	}
}
