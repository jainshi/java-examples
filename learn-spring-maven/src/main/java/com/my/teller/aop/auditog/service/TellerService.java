package com.my.teller.aop.auditog.service;

public class TellerService {

	public void openTeller(String userId, String tellerId) {
		System.out
				.println("Teller Open method called... with arguments: UserId-"
						+ userId + " TellerId-" + tellerId);
	}

	public void closeTeller(String userId, String tellerId) {
		System.out
				.println("Teller Close method called... with arguments: UserId-"
						+ userId + " TellerId-" + tellerId);
	}
}
