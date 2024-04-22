package com.storage.micro.data.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataStorage implements Serializable{
	
	private String message;
	
	private Date fecha;
	
	private static final long serialVersionUID = -8978392105608482051L;

}
