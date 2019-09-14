package com.uned.project.springbootrestapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;

//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table (name="employee")
@EntityListeners(AuditingEntityListener.class)
//@Getter
//@Setter

@Service
@Transactional()



public class Employee {
	
	@Id // definimos clave primaria
	@GeneratedValue(strategy=GenerationType.AUTO)  // que se genere de forma automatica y crezca
	private Long id;
	
	@NotBlank // que no este campo en blanco, validar documento
	private String name;
	
	@NotBlank
	private String designation;
	
//  @NotBlank  lo elimina en minuto 54:10 video
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private  Date createAt;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@NotBlank
	private String expertise;
	
	
	
}