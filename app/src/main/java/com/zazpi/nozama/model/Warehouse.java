package com.zazpi.nozama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="warehouse")
public class Warehouse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="warehouseID")
	int id;
	@Column(name="nameWarehouse")
	String name;
	@Column
	String location;
	
}
