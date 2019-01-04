package com.zazpi.nozama.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="shelf")
public class Shelf {
	@Id
	@Column(name="shelfid")
	int id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="warehouseid")
	Warehouse warehouse;
	
	@Column
	int capacity;
	@Column
	int position;
	
	public Shelf() {}
	
	public Shelf(int capacity, int position, Warehouse warehouse) {
		this.capacity = capacity;
		this.position = position;
		this.warehouse = warehouse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	
}
