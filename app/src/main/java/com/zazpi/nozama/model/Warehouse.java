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
	
	@OneToMany(mappedBy="warehouse")
	Set<Shelf> shelves;
	
	@Override
	public String toString() {
		return "Warehouse: "+ id + ",name= " + name + ",location= " + location;
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

	public Set<Shelf> getShelves() {
		return shelves;
	}

	public void setShelves(Set<Shelf> shelves) {
		this.shelves = shelves;
	}
	
}
