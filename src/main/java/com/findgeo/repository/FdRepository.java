package com.findgeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findgeo.entity.Fdmark;

public interface FdRepository extends JpaRepository<Fdmark, String>{

}
