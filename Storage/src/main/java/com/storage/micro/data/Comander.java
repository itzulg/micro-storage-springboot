package com.storage.micro.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.storage.micro.data.feign.client.ProductFeignClient;
import com.storage.micro.data.model.Producto;
import com.storage.micro.data.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class Comander implements CommandLineRunner {

	@Autowired
	private ProductFeignClient productFeign;

	@Autowired
	private ProductRepository repository;
	
	public void run(String... args) throws Exception
	{
		
		List<Producto> productsObtained = productFeign.getProducts();
		productsObtained.stream().forEach(data -> repository.save(data));
		log.info("Productos insertados..");
		
	}
}
