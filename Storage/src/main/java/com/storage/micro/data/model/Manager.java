package com.storage.micro.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "manager")

public class Manager implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Pattern(regexp = "[a-zA-Z]*")
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Pattern(regexp = "[a-zA-Z]*")
	@Column(name = "last_name_father")
	private String lastnameFather;	
	
	@NotNull
	@Pattern(regexp = "[a-zA-Z]*")
	@Column(name = "last_name_mother")
	private String lastnameMother;	
	
	@NotNull
	@Size(max = 2, min = 2)
	@Column(name = "area")
	private String area;
	
	@NotNull
	@Size(max = 10, min = 10)
	@Pattern(regexp = "[0-9]+")
	@Column(name = "telephone")
	private String telephone;
	
	@NotNull
	@Embedded
	private Adress adress;
	
	
	private static final long serialVersionUID = -753182320446203347L;

}
