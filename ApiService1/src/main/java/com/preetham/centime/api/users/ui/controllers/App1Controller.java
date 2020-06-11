package com.preetham.centime.api.users.ui.controllers;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preetham.centime.api.users.logging.EntryExitLogger;
import com.preetham.centime.api.users.request.Person;
import com.preetham.centime.api.users.service.client.App2Client;
import com.preetham.centime.api.users.service.client.App3Client;

@RestController
@RequestMapping("/app1")
public class App1Controller {
	Logger logger = LoggerFactory.getLogger(this.getClass());

//	AsyncComClient client;
	private Environment env;
	private App2Client client2;
	private App3Client client3;

	public App1Controller(App2Client client2, Environment env,App3Client client3) {
		this.client2 = client2;
		this.client3 = client3;
		this.env = env;
	}

	@GetMapping("/status/check")
	@EntryExitLogger
	public String status() {
		return env.getProperty("spring.application.name") + " is working... on Internal Port:"
				+ env.getProperty("local.server.port");
	}

	
//	@EntryExitLogger
	@GetMapping(path="/test", produces= {MediaType.APPLICATION_JSON_VALUE})
	public String home() {
		
		logger.info("Before calling microsrevice - (app2)");
		String response = client2.getHello();
		logger.info("Response received from microsrevice - (app2)");
		
		logger.info("Before calling microsrevice - (app3)");
		String response2 = client3.getPerson(new Person(env.getProperty("input.firstName")!=null?env.getProperty("input.firstName"):"Preetham",
				env.getProperty("input.lastName")!=null?env.getProperty("input.lastName"):"Chinta"));
		logger.info("Response received from microsrevice - (app3)");
		
		logger.info("After Concatination " + response+response2);
		return response+response2;
	}

}
