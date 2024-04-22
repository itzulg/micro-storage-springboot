package com.storage.micro.data.servicee;

import java.util.List;

import com.storage.micro.data.model.RequestDataStorage;
import com.storage.micro.data.model.ResponseDataStorage;
import com.storage.micro.data.model.Storage;


public interface StorageService {
	
	public List<Storage> getListStorage();
	
	public void updateStorage(Storage storage);
	
	public void deleteStorageRegistrer(Long id);
	
	public ResponseDataStorage getResponseStorage(RequestDataStorage requestDataStorage);
	
}
