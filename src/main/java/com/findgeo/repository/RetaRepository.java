package com.findgeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findgeo.entity.Retamark;

public interface RetaRepository extends JpaRepository<Retamark, String> {

}
