package com.zazpi.nozama.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="suborders")
public class SubOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="suborderid")
	int id;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="origin")
	Warehouse origin;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="orderid")
	Order order;
	
	@Temporal(TemporalType.DATE)
	@Column(name="departuredate")
	Date departureDate;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="ordersproducts", 
				joinColumns={@JoinColumn(name="suborderid")}, 
				inverseJoinColumns={@JoinColumn(name="productmodelid")})
	private Set<ProductModel> products = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Warehouse getOrigin() {
		return origin;
	}

	public void setOrigin(Warehouse origin) {
		this.origin = origin;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubOrder other = (SubOrder) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
