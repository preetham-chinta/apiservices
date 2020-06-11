package com.preetham.centime.api.ui.controller;

import org.jboss.logging.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.preetham.centime.api.ApiService2Application;
import com.preetham.centime.api.ui.logging.EntryExitLogger;
 
@RestController
@RequestMapping("/app2")
public class App2Controller {
	private static final Logger LOG = Logger.getLogger(ApiService2Application.class.getName());
	
//    @Value("${spring.application.name}") 
//    private String appName;
    
	@Autowired
	private Environment env;
	 
	@GetMapping("/status/check")
	public String status() {
		return env.getProperty("spring.application.name")+" is working... on Internal Port:"+env.getProperty("local.server.port");
	}

	@EntryExitLogger
	@GetMapping(path ="/hello", produces= {MediaType.APPLICATION_JSON_VALUE})
	public String getUser() {
		LOG.info("Start /app2/hello");
		return "Hello ";
	}
}
