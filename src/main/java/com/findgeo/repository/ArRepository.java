package com.findgeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findgeo.entity.Armark;

public interface ArRepository extends JpaRepository<Armark, String> {

}
