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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productmodelid")
	int id;
	
	@Column(name="name")
	String name;
	
	@Column(name="description")
	String description;
	
	@Column(name="weight")
	int weight;
	
	@Column(name="x")
	int x;
	
	@Column(name="y")
	int y;
	
	@Column(name="z")
	int z;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	
	
}
