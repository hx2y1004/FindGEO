package com.findgeo.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findgeo.dto.PlannerFormDto;
import com.findgeo.entity.Planner;

@Repository
public interface PlannerRepository extends JpaRepository<Planner, Long> {

	Page<Planner> findByEmailIdOrderByPlannerIdDesc(String emailId, Pageable pageable);

	Optional<Planner> findById(Long idx);

	void save(PlannerFormDto plannerFormDto);
	
	@Transactional
	void deleteByEmailId(String emailId);

	int countByPlannerId(Long plannerId);

	int countByEmailId(String emailId);
}