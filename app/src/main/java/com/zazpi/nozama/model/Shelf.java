package com.zazpi.nozama.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shelves")
public class Shelf {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shelvesID")
	int id;
	@Column
	int capacity;
	@Column
	int position;
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="warehouseID")
	Warehouse warehouse;
}
