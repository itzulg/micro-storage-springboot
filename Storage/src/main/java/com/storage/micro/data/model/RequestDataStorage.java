package com.storage.micro.data.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestDataStorage implements Serializable {

	@NotNull
	@NotEmpty
	private String name;
	
	private String location;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date date;
	
	private String managerName;
	
	private List<Integer> listaIdProductos;
	
	private static final long serialVersionUID = 5791352815655012323L;
	
	

}
