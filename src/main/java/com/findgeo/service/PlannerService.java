package com.findgeo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.findgeo.dto.PlannerFormDto;
import com.findgeo.entity.Planner;
import com.findgeo.repository.PlannerRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class PlannerService
{
	
	private final PlannerRepository plannerRepository;

	//계획서 입력
	public void plannerWrite(@Valid PlannerFormDto plannerFormDto) {
		Planner planner = plannerFormDto.createPlanner();
		plannerRepository.save(planner);
	}
	
	//계획서 리스트
	public Page<Planner> selectPlannerListPage(String emailId, Pageable pageable){
		return plannerRepository.findByEmailId(emailId, pageable);
	}

	public Planner selectPlanner(Long plannerId) {
		return plannerRepository.findById(plannerId).get();
	}

	public Optional<Planner> updatePlanner(PlannerFormDto plannerFormDto) {
		Long plannerId=plannerFormDto.getPlannerId();
		Optional <Planner> planner = this.plannerRepository.findById(plannerId);
		planner.ifPresent(t ->{
			t.setAdvertise(plannerFormDto.getAdvertise());
			t.setAvgDayDeli(plannerFormDto.getAvgDayDeli());
			t.setAvgDayVisit(plannerFormDto.getAvgDayVisit());
			t.setAvgEndDeli(plannerFormDto.getAvgEndDeli());
			t.setAvgEndVisit(plannerFormDto.getAvgEndVisit());
			t.setAvgPrice(plannerFormDto.getAvgPrice());
			t.setCostRate(plannerFormDto.getCostRate());
			t.setDays(plannerFormDto.getDays());
			t.setDues(plannerFormDto.getDues());
			t.setEnds(plannerFormDto.getEnds());
			t.setEtc(plannerFormDto.getEtc());
			t.setEtcRent(plannerFormDto.getEtcRent());
			t.setExpand(plannerFormDto.getExpand());
			t.setInitCost(plannerFormDto.getInitCost());
			t.setInterest(plannerFormDto.getInterest());
			t.setPartTime(plannerFormDto.getPartTime());
			t.setPlannerTitle(plannerFormDto.getPlannerTitle());
			t.setRentCost(plannerFormDto.getRentCost());
			t.setTotalSalary(plannerFormDto.getTotalSalary());
			t.setTotInsurance(plannerFormDto.getTotInsurance());
			t.setW_e_g(plannerFormDto.getW_e_g());
			t.setCategory(plannerFormDto.getCategory());
			this.plannerRepository.save(t);
		});
		return planner;
	}

	public void plannerDelete(Long plannerId) {
		plannerRepository.deleteById(plannerId);
	}

	public boolean isPlannerExists(Long plannerId) {
		boolean result = plannerRepository.existsById(plannerId);
		return result;
	}
	
}