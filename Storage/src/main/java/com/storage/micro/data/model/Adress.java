package com.storage.micro.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Adress implements Serializable{

		@NotNull
		@Pattern(regexp = "[a-zA-Z]*")
		@Column(name = "street")
		private String street;
		
		@NotNull
		@Pattern(regexp = "[0-9]+")
		@Column(name = "number")
		private String number;
		
		@NotNull
		@Pattern(regexp = "[0-9]+")
		@Size(max = 5, min = 5)
		@Column(name = "cp")
		private String cp;
		
		@NotNull
		@Pattern(regexp = "[a-zA-Z]*")
		@Column(name = "state")
		private String state;
		
		@NotNull
		@Pattern(regexp = "[a-zA-Z]*")
		@Column(name = "city")
		private String city;
		
		private static final long serialVersionUID = 8565522747510057086L;
}
