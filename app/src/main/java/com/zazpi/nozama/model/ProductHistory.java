package com.zazpi.nozama.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="productstackhistory")
public class ProductHistory extends ProductStack{

	@Temporal(TemporalType.DATE)
	@Column(name="startdate")
	Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="enddate")
	Date endDate;

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
	
	

}
