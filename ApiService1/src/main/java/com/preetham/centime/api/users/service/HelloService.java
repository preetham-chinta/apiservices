package com.preetham.centime.api.users.service;

import java.util.concurrent.CompletableFuture;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preetham.centime.api.users.ApiService1Application;
import com.preetham.centime.api.users.logging.EntryExitLogger;
import com.preetham.centime.api.users.request.Person;
import com.preetham.centime.api.users.service.client.AsyncComClient;

@Service
public class HelloService {
	private static final Logger LOG = Logger.getLogger(ApiService1Application.class.getName());
	
	@Autowired
	private AsyncComClient commCLient;
	
	@EntryExitLogger
	public String getDetails() {
		
		StringBuilder response = new StringBuilder();

		CompletableFuture<String> greeting = commCLient.getHello();
		CompletableFuture<String> personName = commCLient.getPersonName(new Person("Preetham", "Chinta"));

		// Upon completion of bothStages - apply computation
		(greeting).thenApply(String::toUpperCase).thenAcceptBoth((personName).thenApply(String::toLowerCase),
				(s1, s2) -> response.append(s1 + s2));

		return response.toString();
	}

}
