package com.delivary.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivary.dto.OrderAddress;

public interface OrderAddressRepository extends JpaRepository<OrderAddress, Long> {

}
