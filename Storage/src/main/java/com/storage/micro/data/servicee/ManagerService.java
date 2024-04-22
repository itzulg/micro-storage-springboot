package com.storage.micro.data.servicee;

import java.util.List;

import com.storage.micro.data.model.Manager;

public interface ManagerService {
	
   public List<Manager>getManagers();
   
   public List<Manager>updateManagers();
   
}
