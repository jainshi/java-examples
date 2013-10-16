package com.my.teller.aop.auditlog.service;

import com.my.teller.aop.auditlog.constants.AuditLoggable;
import com.my.teller.aop.auditlog.constants.LogLevel;
import com.my.teller.aop.auditlog.constants.UserAction;

public class TellerService {

	@AuditLoggable(level = LogLevel.INFO, startAction = UserAction.STARTED, completeAction = UserAction.COMPLETED, failAction = UserAction.FAILED, message = "Some common message to the log")
	public void openTeller(String userId, String tellerId) {
		if(tellerId == null) {
			throw new RuntimeException("Oh teller id is null... are you sure?");
		}
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
