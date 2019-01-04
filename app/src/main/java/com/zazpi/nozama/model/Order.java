package com.zazpi.nozama.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderID")
	int id;
	
	@Column(name="origin")
	int origin;
	
	@Column(name="destination")
	int destination;
	
	@Temporal(TemporalType.DATE)
	@Column(name="entrydate")
	Date entryDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="departuredate")
	Date departureDate;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="ordersproducts", 
				joinColumns={@JoinColumn(name="orderid")}, 
				inverseJoinColumns={@JoinColumn(name="productmodelid")})
	private Set<ProductModel> products = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrigin() {
		return origin;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	
	public Set<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductModel> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order id=" + id + " ,origin: " + origin + ",destination:" + destination
				+ ",entry:" + entryDate + ",departure:" + departureDate + ",products:" + products.size(); 
	}
	
}
