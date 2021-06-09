package com.delivary.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Orders orders;
	
	private Address to;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Orders getOrder() {
		return orders;
	}
	public void setOrder(Orders order) {
		this.orders = order;
	}
	
	public Address getTo() {
		return to;
	}
	public void setTo(Address to) {
		this.to = to;
	}

}
