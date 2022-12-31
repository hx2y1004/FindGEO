package com.findgeo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.findgeo.dto.PlannerFormDto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "planner")
@Getter
@Setter
public class Planner extends BaseTimeEntity {
	@Id
	@Column(name = "plannerid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long plannerId;
	@Column(nullable = false)
	private String emailId;
	private int avgPrice;
	private String plannerTitle;
	private int avgDayVisit = 0;
	private int avgDayDeli = 0;
	private int avgEndVisit = 0;
	private int avgEndDeli = 0;
	private int initCost = 0;
	private int rentCost;
	private int totalSalary;
	private int totInsurance = 0;
	private int etcRent = 0;
	private int dues = 0;
	private float costRate;
	private int interest;
	private int partTime = 0;
	private int w_e_g = 0;
	private int expand = 0;
	private int advertise = 0;
	private int etc = 0;
	private int days = 1;
	private int ends = 1;
	private String category;

//	public void updatePlanner(PlannerFormDto plannerFormDto) {
//		this.avgPrice = plannerFormDto.getAvgPrice();
//		this.plannerTitle = plannerFormDto.getPlannerTitle();
//		System.out.println(plannerTitle);
//		this.avgDayVisit = plannerFormDto.getAvgDayVisit();
//		this.avgDayDeli = plannerFormDto.getAvgDayDeli();
//		this.avgEndVisit = plannerFormDto.getAvgEndVisit();
//		this.avgEndDeli = plannerFormDto.getAvgEndDeli();
//		this.initCost = plannerFormDto.getInitCost();
//		this.rentCost = plannerFormDto.getRentCost();
//		this.totalSalary = plannerFormDto.getTotalSalary();
//		this.totInsurance = plannerFormDto.getTotInsurance();
//		this.etcRent = plannerFormDto.getEtcRent();
//		this.dues = plannerFormDto.getDues();
//		this.costRate = plannerFormDto.getCostRate();
//		this.partTime = plannerFormDto.getPartTime();
//		this.w_e_g = plannerFormDto.getW_e_g();
//		this.expand = plannerFormDto.getExpand();
//		this.advertise = plannerFormDto.getAdvertise();
//		this.etc = plannerFormDto.getEtc();
//		this.days = plannerFormDto.getDays();
//		this.ends = plannerFormDto.getEnds();
//		}
}