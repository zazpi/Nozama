package com.zazpi.nozama.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="warehouse")
public class Warehouse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="warehouseid")
	int id;
	@Column(name="name")
	String name;
	@Column(name="location")
	int location;
	
	@Override
	public String toString() {
		return "Warehouse: "+ id + ",name= " + name + ",location= " + location;
	}
	
	public Warehouse() {}
	
	public Warehouse(String name, int location) {
		this.name = name;
		this.location = location;
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
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj instanceof Warehouse) return false;
		Warehouse w = (Warehouse) obj;
		return (id == w.getId());
	}

	@Override
	public int hashCode() {
		return id;
	}
	
	
	
}
