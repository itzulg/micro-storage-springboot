package com.storage.micro.data.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.storage.micro.data.model.RequestDataStorage;
import com.storage.micro.data.model.ResponseDataStorage;
import com.storage.micro.data.model.Storage;
import com.storage.micro.data.servicee.StorageService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Validated
@RequestMapping("/api")
@Slf4j

public class StorageController {
	
	@Autowired
	private StorageService storageService;	
	
	@PutMapping(value = "/storage")
	public ResponseEntity<?> updateStorage(@RequestBody @Valid Storage storage){ 
		log.info("Start process to update - request: {}", storage);
		storageService.updateStorage(storage);
		return new ResponseEntity<String>("Updated ", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/storage/remove", params = {"id"})
	public ResponseEntity<?> deleteStorage(@RequestParam Long id){
		storageService.deleteStorageRegistrer(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
	
	@PostMapping(value = "/storage/retrieve")
	public ResponseEntity<?> getList(){
		storageService.getListStorage();
		return new ResponseEntity<List<Storage>>(storageService.getListStorage(), HttpStatus.OK);
	}
	
	@PostMapping(value="/storage/create")
	public ResponseEntity<?> getStorageData(@RequestBody @Valid RequestDataStorage requestData){
		return new ResponseEntity<ResponseDataStorage>(storageService.getResponseStorage(requestData), HttpStatus.OK);
	}
	
}
