package com.storage.micro.data.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.storage.micro.data.exceptions.NotFoundException;
import com.storage.micro.data.feign.client.ProductFeignClient;
import com.storage.micro.data.model.Manager;
import com.storage.micro.data.model.Producto;
import com.storage.micro.data.model.RequestDataStorage;
import com.storage.micro.data.model.ResponseDataStorage;
import com.storage.micro.data.model.Storage;
import com.storage.micro.data.repository.ProductRepository;
import com.storage.micro.data.repository.StorageRepository;
import com.storage.micro.data.servicee.ManagerService;
import com.storage.micro.data.servicee.StorageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService{
	
	private StorageRepository repository;
	
	private ManagerService managerService;
	
	private ProductFeignClient productoClient;
	
	private ProductRepository productRepository;
	
	
	public StorageServiceImpl(StorageRepository repository, ManagerService managerService, ProductFeignClient productoClient, ProductRepository productRepository) {
		this.repository = repository;
		this.managerService = managerService;
		this.productoClient = productoClient;
		this.productRepository = productRepository;
	}
	
	@Override
	public List<Storage> getListStorage() {
		 Optional<List<Storage>> listStorage = repository.findListStorage();
		  if(listStorage.isPresent()) {
			return listStorage.get();   
		  } else {
			  return new ArrayList<>();
		  }	 
	}
	

	@Override
	@Transactional
	public void updateStorage(Storage storage) {
		log.info("Storage: {}", storage);
		repository.save(storage);
	}

	@Override
	public void deleteStorageRegistrer(Long id) {
		try {
			repository.deleteById(id);
			}catch (NotFoundException e) {
			  log.debug("Error en el Id");
		      throw new  NotFoundException("Id inexistente");
			}catch (Exception e) {
			  log.debug("Error en la base de datos");
	          throw new  InternalError("Error en la base");
			}
	}


	@Override
	@Transactional
	public ResponseDataStorage getResponseStorage(RequestDataStorage requestDataStorage) {
		//Lista de los manager, se asigna a un auxiliar
		List<Manager> auxManagers;
		//manejo de error en caso de que no haya coincidencias try-catch
		try {
			//arreglo string, se obtiene el nombre que da el cliente y es separado por espacios
			String[] client = requestDataStorage.getName().split(" ");
			//Se compara cada nombre y apelllido ingresado, cada coincidencia ocupa el lugar del array
			
			List<Manager> managers =  managerService.getManagers();
			auxManagers = managers.stream()
			.filter(data -> data.getLastnameFather().equalsIgnoreCase(client[0]))
			.filter(data -> data.getLastnameMother().equalsIgnoreCase(client[1]))
			.filter(data -> data.getName().equalsIgnoreCase(client[2]))
			.collect(Collectors.toList()); //Lista de las coincidencias
			
		//Si encuentra error lanza una excepción
		} catch (Exception e) {
			log.debug("Error en los datos");
	        throw new  InternalError("Error en el nombre");
			
		}
       
		//Si los datos ingresado no estan vacíos (los valida un if)
		if (!auxManagers.isEmpty()) {
			Storage storage = new Storage(); //Crea un nuevo storage con date, IdManager, Location, ManagerName
			storage.setDate(requestDataStorage.getDate());
			storage.setIdManager(auxManagers.get(0).getId()); //¿Que función hace el get(0)?
			storage.setLocation(requestDataStorage.getLocation());
			storage.setManagerName(requestDataStorage.getName());
			storage.setName(auxManagers.get(0).getName());
			//Productos no se puede repetir
			Set<Producto> listProduct = new HashSet<>();
			
			//Lista de productos, servicio consumido del micro Producto, se pueden repetir, 
			List<Producto> productsObtained = productoClient.getProducts();
			
			//For que hace un recorrido por todos los productos de la lista que han sido asignados
			for(int i = 0; i < requestDataStorage.getListaIdProductos().size(); i++)
			{
				//For hace recorrido de los productos asignados
				for(int j = 0; j < productsObtained.size(); j++)
				{
					if(requestDataStorage.getListaIdProductos().get(i) == productsObtained.get(j).getId()) {
						//Se asigna el producto
						listProduct.add(productsObtained.get(j));
					}
				}
			
			}
			
			//
			storage.setProduct(listProduct);
			//Se guarda en el repository H2
			repository.save(storage);
			listProduct.stream().forEach(data -> data.setStorage(storage));
			listProduct.stream().forEach(data -> productRepository.save(data));
			return new ResponseDataStorage("Successfully Creation", requestDataStorage.getDate());
			
		} else {
			return new ResponseDataStorage("Error In Creation", requestDataStorage.getDate());
		}
		
	}
	

}
