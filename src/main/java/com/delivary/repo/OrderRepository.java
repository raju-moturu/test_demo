package com.delivary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import com.delivary.dto.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

	@Query("From Orders where servicestore_id=:serviceid")
	List<Orders> findOrdersByServiceId(@Param("serviceid") Long id);
	
	@Query("From Orders where to_store_id=:toStore")
	List<Orders> findReceiveOrdersByServiceId(@Param("toStore") Long toStore);

}
