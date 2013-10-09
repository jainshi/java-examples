package test.spring.aspect.calculator.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.spring.aspect.calculator.ArithmeticCalculator;
import test.spring.aspect.calculator.MaxCalculator;
import test.spring.aspect.calculator.MinCalculator;
import test.spring.aspect.calculator.UnitCalculator;
import test.spring.aspect.counter.Counter;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-context.xml");
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) context
				.getBean("arithmeticCalculator");
		
		  /*arithmeticCalculator.add(1, 2); arithmeticCalculator.sub(4, 3);
		  arithmeticCalculator.mul(2, 3); arithmeticCalculator.div(4, 2);*/
		  UnitCalculator unitCalculator = (UnitCalculator) context
		  .getBean("unitCalculator"); unitCalculator.kilogramToPound(10);
		  /*unitCalculator.kilometerToMile(5);
		 */

		// arithmeticCalculator.div(4, 2);

		MaxCalculator maxCalculator = (MaxCalculator) arithmeticCalculator;
		maxCalculator.max(1, 2);
		MinCalculator minCalculator = (MinCalculator) arithmeticCalculator;
		minCalculator.min(1, 2);

		Counter arithmeticCounter = (Counter) arithmeticCalculator;
		System.out.println(arithmeticCounter.getCount());
		Counter unitCounter = (Counter) unitCalculator;
		System.out.println(unitCounter.getCount());
	}
}
