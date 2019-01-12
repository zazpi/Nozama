package com.zazpi.nozama.model;

import java.util.Date;
import java.util.List;
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

	@Column(name="destination")
	int destination;
	
	@Temporal(TemporalType.DATE)
	@Column(name="entrydate")
	Date entryDate;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="orderssubs", 
				joinColumns={@JoinColumn(name="orderid")}, 
				inverseJoinColumns={@JoinColumn(name="suborderid")})
	Set<SubOrder> suborders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Set<SubOrder> getSuborders() {
		return suborders;
	}

	public void setSuborders(Set<SubOrder> suborders) {
		this.suborders = suborders;
	}



	/*@Override
	public String toString() {
		return "Order id=" + id + " ,origin: " + origin.getName()+ ",destination:" + destination
				+ ",entry:" + entryDate + ",departure:" + departureDate + ",products:" + products.size(); 
	}*/
	
}
