package com.storage.micro.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.storage.micro.data.model.Storage;



@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
	
	@Query("SELECT  p from Storage p")  
	public Optional<List<Storage>> findListStorage();
	 
		

}
