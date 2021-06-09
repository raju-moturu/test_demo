package com.delivary.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.delivary.dto.ServiceStore;

public interface ServiceStoreRepository extends JpaRepository<ServiceStore, Long> {

	@Query("from ServiceStore where village=:city and area=:area ")
	List<ServiceStore> findStores(@Param("city") String city,@Param("area") String area);

	@Query("from ServiceStore where user_id=:userId ")
	ServiceStore findServiceId(@Param("userId") Long id);

}
