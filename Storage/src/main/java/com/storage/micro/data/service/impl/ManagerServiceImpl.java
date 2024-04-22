package com.storage.micro.data.service.impl;

import java.util.List;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.storage.micro.data.feign.client.ManagerFeignClient;
import com.storage.micro.data.model.Manager;
import com.storage.micro.data.servicee.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

	
	private ManagerFeignClient managerClient;
	
	
	public ManagerServiceImpl(ManagerFeignClient managerClient) {
		this.managerClient = managerClient;
	}

	@Cacheable(value = "managers")
	public List<Manager> getManagers() {
		return managerClient.getManagers();
	}
	
	@CachePut(value = "managers")
	@Scheduled(cron = "30 15 16 * * *")
	public List<Manager> updateManagers() {
		
		return managerClient.getManagers();
	}


}
