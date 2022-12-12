package com.findgeo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.findgeo.entity.BaseTimeEntity;
import com.findgeo.entity.Planner;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlannerFormDto {
	private Long plannerId;
	private String plannerTitle;
	private String emailId;
	@NotBlank(message = "평균 가격은 필수 입력 값입니다.")
	private int avgPrice;
	private int avgDayVisit;
	private int avgDayDeli;
	private int avgEndVisit;
	private int avgEndDeli;
	@NotNull(message = "초기비용은 필수 입력 값입니다.")
	private int initCost;
	@NotNull(message = "임대료는 필수 입력 값입니다.")
	private int rentCost;
	@NotNull(message = "총 임금은 필수 입력 값입니다.") 
	private int totalSalary; 
	private int totInsurance;
	private int etcRent; 
	private int dues; 
	private int interest;
	@NotNull(message = "평균 원가율은 필수 입력 값입니다.") 
	private float costRate; 
	private int partTime; 
	private int w_e_g; 
	private int expand; 
	private int advertise; 
	private int etc;
	private int days;
	private int ends;
	private String category;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Planner createPlanner() {
		return (Planner)modelMapper.map(this, Planner.class);
	}

	public static PlannerFormDto of(Planner planner) {
		return (PlannerFormDto)modelMapper.map(planner, PlannerFormDto.class);
	} 
}