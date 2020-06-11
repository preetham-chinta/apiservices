package com.preetham.centime.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preetham.centime.api.ApiService3Application;
import com.preetham.centime.api.logging.EntryExitLogger;
import com.preetham.centime.api.request.Person;

import org.jboss.logging.Logger;

@RestController
@RequestMapping("/app3")
public class App3Controller {
	private static final Logger LOG = Logger.getLogger(ApiService3Application.class.getName());

	@Autowired
	private Environment env;

	@GetMapping("/status/check")
	public String status() {
		return env.getProperty("spring.application.name") + " is working... on Internal Port:"
				+ env.getProperty("local.server.port");
	}

//	@EntryExitLogger
	@PostMapping(path ="/person", produces= {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public String person(@RequestBody @Valid Person person) {
		LOG.info("Person Name: " + person.toString());
		return person.toString();
	}

}
