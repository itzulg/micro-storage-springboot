package com.storage.micro.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storage.micro.data.model.Producto;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {
	 
}
