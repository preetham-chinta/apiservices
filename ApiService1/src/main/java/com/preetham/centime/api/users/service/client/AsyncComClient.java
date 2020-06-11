package com.preetham.centime.api.users.service.client;

import java.util.concurrent.CompletableFuture;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.preetham.centime.api.users.request.Person;

@Service
public class AsyncComClient {
	
	RestTemplate restTemplate;
	Environment env;
	
//	 @Value("${service2.get.uri}") 
//	 private String getUrl;
//	
//	 @Value("${service3.post.uri}") 
//	 private String postUrl;
	
	@Autowired
    public AsyncComClient(RestTemplate restTemplate,Environment env) {
		this.restTemplate = restTemplate;
		this.env=env;
	}

	@Async //For service2-call
    public CompletableFuture<String> getHello() {
        String response = restTemplate.getForObject(env.getProperty("service2.get.uri"),String.class);
        return CompletableFuture.completedFuture(response);
    }
	
    @Async //For service3-call
    public CompletableFuture<String> getPersonName(Person person) {
        
//      For Service call-3
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject personJsonObject = new JSONObject(new Person("Preetham", "Chinta"));
		HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
		
		String response = restTemplate.postForObject(env.getProperty("service2.post.uri"), request, String.class);

        return CompletableFuture.completedFuture(response);
    }

}
