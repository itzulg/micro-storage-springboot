package com.storage.micro.data.feign.client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.storage.micro.data.model.Manager;

@FeignClient(name = "Manager")
public interface ManagerFeignClient {
	
	@PostMapping("/api/manager/id/retrieve")
	public Manager getManagerProfile(@PathVariable Long id);
	
	@PostMapping("/api/manager/list/retrieve")
	public List<Manager> getManagers();
	
	
}
