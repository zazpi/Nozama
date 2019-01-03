package com.zazpi.nozama.model;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="productstack")
public class ProductStack {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productid")
	int id;
	
	@Column
	int stock;
	
	@Temporal(TemporalType.DATE)
	@Column(name="startdate")
	Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="enddate")
	Date endDate;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="productmodelid")
	ProductModel model;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="shelvesid")	
	Shelf shelf;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
