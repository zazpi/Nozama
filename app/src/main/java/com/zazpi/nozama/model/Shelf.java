package com.zazpi.nozama.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zazpi.nozama.model.Shelf.ShelfID;

@Entity
@Table(name="shelf")
@IdClass(ShelfID.class)
public class Shelf {

	@Id
	@Column(name="shelfid")
	int id;
	
	@Id
	@Column(name="warehouseid")
	int id2;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="warehouseid",insertable = false, updatable = false)
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
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
	
	public static class ShelfID implements Serializable {
		private int id;
		private int id2;
		
		public ShelfID () {}
		public ShelfID (int id, int id2) {
			this.id = id;
			this.id2 = id2;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null) return false;
			if(obj instanceof Shelf) return false;
			Shelf s = (Shelf) obj;
			return (id == s.getId() && (id2 == s.getId2()));
		}

		@Override
		public int hashCode() {
			String s = String.valueOf(id) + String.valueOf(id2);
			return s.hashCode();
		}
		
	}
	
	
	
	
}
