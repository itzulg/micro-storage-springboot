package com.storage.micro.data.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


import com.storage.micro.data.model.Producto;

@FeignClient(name = "Producto")
public interface ProductFeignClient {

	@PostMapping("/api/product/list/retrieve")
	public List<Producto> getProducts();
}
