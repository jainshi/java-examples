package test.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.spring.service.lifecycle.Cashier;
import test.spring.service.lifecycle.Product;
import test.spring.service.lifecycle.ShoppingCart;

public class TestMain {

	public static void main(String[] args) throws IOException {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-context.xml");
		/*
		 * GreetingService greetingService = (GreetingService)
		 * context.getBean("helloGreeting");
		 * System.out.println(greetingService.sayGreeting("Shishir"));
		 * 
		 * SequenceGenerator generator = (SequenceGenerator)
		 * context.getBean("sequenceGenerator");
		 * System.out.println(generator.getSequence());
		 * System.out.println(generator.getSequence());
		 * 
		 * generator = (SequenceGenerator)
		 * context.getBean("sequenceGenerator2");
		 * System.out.println(generator.getSequence());
		 * System.out.println(generator.getSequence());
		 * 
		 * generator = (SequenceGenerator) context.getBean("generator");
		 * System.out.println(generator.getSequence());
		 * System.out.println(generator.getSequence());
		 * 
		 * generator = (SequenceGenerator) context.getBean("generator2");
		 * System.out.println(generator.getSequence());
		 * System.out.println(generator.getSequence());
		 * 
		 * generator = (SequenceGenerator)
		 * context.getBean("sequenceGenerator3");
		 * System.out.println(generator.getSequence());
		 * System.out.println(generator.getSequence());
		 */
		/*
		 * PrefixGenerator prefixGen = (PrefixGenerator)
		 * context.getBean("datePrefixGenerator");
		 * System.out.println(prefixGen.getPrefix());
		 */
		Product aaa = (Product) context.getBean("aaa");
		Product cdrw = (Product) context.getBean("cdrw");
		Product dvdrw = (Product) context.getBean("dvdrw");
		
		ShoppingCart cart1 = (ShoppingCart) context.getBean("shoppingCart");
		
		cart1.addItem(aaa);
		cart1.addItem(cdrw);
		
		System.out.println("Shopping cart 1 contains " + cart1.getItems());
		
		ShoppingCart cart2 = (ShoppingCart) context.getBean("shoppingCart");
		
		cart2.addItem(dvdrw);
		
		System.out.println("Shopping cart 2 contains " + cart2.getItems());
		
		Cashier cashier1 = (Cashier) context.getBean("cashier1");
		cashier1.checkout(cart1);

	}

}
