package com.zazpi.nozama.model;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="productstack")
public class ProductStack implements Serializable{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column
	int stock;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="productmodelid")
	ProductModel model;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="shelfid"),
	              @JoinColumn(name="warehouseid")})
	Shelf shelf;
	
	public ProductStack () {}
	
	public ProductStack(int stock, ProductModel model, Shelf shelf) {
		this.stock = stock;
		this.model = model;
		this.shelf = shelf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public ProductModel getModel() {
		return model;
	}

	public void setModel(ProductModel model) {
		this.model = model;
	}
	
	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}
	
}
