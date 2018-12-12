package com.zazpi.nozama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productmodel")
public class ProductModel {
	@Id
	@Column(name="productmodelid")
	int id;
	
	@Column(name="name")
	String name;
	
	@Column(name="description")
	String description;
	
	public ProductModel() {}
	
	public ProductModel(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		
		return "ProductModel: id=" + id + " name=" + name + " description= " + description;
	}
	
	
}
