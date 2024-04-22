package com.storage.micro.data.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Storage")
public class Storage implements Serializable{
	
	@Id
	@Column(name = "id_manager")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idManager;
	
	@NotNull
	//@Pattern(regexp = "[A-Za-z]*")
	@Column(name = "name")
	private String name;
	
	@NotNull
	//@Pattern(regexp = "[A-Za-z]*")
	@Column(name = "location")
	private String location;
	
	@NotNull(message = "Invalid date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "date")
	private Date date;
	
	@NotNull
//@Pattern(regexp = "[A-Za-z]*")
	@Column(name = "manager_name")
	//Formato -> Last name + Name
	private String managerName;
	
	@OneToMany(mappedBy = "storage", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"storage"})
	private Set<Producto> product;
	
	
	private static final long serialVersionUID = -5444066210357439119L;
	
	

}
