package com.preetham.centime.api.users.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import com.preetham.centime.api.users.request.Person;

@FeignClient(name="app3")
public interface App3Client {

	@PostMapping(path ="/app3/person", produces= {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public String getPerson(Person person);
	
}