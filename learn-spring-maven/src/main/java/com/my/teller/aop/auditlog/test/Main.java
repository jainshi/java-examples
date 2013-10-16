package com.my.teller.aop.auditlog.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.teller.aop.auditlog.service.TellerService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"teller-service.xml");
		
		TellerService service = (TellerService) context.getBean("tellerService");
		service.openTeller("jainnshi", "1234");
		
		service.closeTeller("jainnshi", "1234");
		
		service.openTeller("jainnshi", null);
	}

}
