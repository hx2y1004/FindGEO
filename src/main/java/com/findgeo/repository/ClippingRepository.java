package com.findgeo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.findgeo.entity.Clipping;

@Repository
public interface ClippingRepository extends JpaRepository<Clipping,String>{

	
	List<Clipping> findByClipid(String email);


}
