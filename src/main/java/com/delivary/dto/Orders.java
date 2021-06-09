package com.delivary.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String customerName;
	private String customerPhone;

	@ManyToOne
	private ServiceStore servicestore;
	
	@ManyToOne
	private ServiceStore toStore;

	public ServiceStore getToStore() {
		return toStore;
	}

	public void setToStore(ServiceStore toStore) {
		this.toStore = toStore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public ServiceStore getServicestore() {
		return servicestore;
	}

	public void setServicestore(ServiceStore servicestore) {
		this.servicestore = servicestore;
	}

}
