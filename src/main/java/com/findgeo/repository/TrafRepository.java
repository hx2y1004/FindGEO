package com.findgeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findgeo.entity.Trafmark;

@Repository
public interface TrafRepository extends JpaRepository<Trafmark, String>{
	
}
