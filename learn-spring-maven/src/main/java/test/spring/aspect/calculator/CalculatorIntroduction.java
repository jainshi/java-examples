package test.spring.aspect.calculator;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

import test.spring.aspect.counter.Counter;
import test.spring.aspect.counter.CounterImpl;

@Aspect
public class CalculatorIntroduction {

	@DeclareParents(value = "test.spring.aspect.calculator.ArithmeticCalculatorImpl", defaultImpl = MaxCalculatorImpl.class)
	public MaxCalculator maxCalculator;

	@DeclareParents(value = "test.spring.aspect.calculator.ArithmeticCalculatorImpl", defaultImpl = MinCalculatorImpl.class)
	public MinCalculator minCalculator;

	@DeclareParents(value = "test.spring.aspect.calculator.*CalculatorImpl", defaultImpl = CounterImpl.class)
	public Counter counter;

	@After("execution(* test.spring.aspect.calculator.*Calculator.*(..))"
			+ " && this(counter)")
	public void increaseCount(Counter counter) {
		counter.increase();
	}
}
