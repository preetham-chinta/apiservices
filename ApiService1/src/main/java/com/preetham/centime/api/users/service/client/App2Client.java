package com.preetham.centime.api.users.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="app2")
public interface App2Client {

	@GetMapping("/app2/hello")
	public String getHello();
	
}
