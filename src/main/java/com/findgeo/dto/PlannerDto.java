package com.findgeo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlannerDto { 
	private long plannerId; 
	private String emailId; 
	private String plannerTitle; 
	private int avgPrice; 
	private int avgDayVisit; 
	private int avgDayDeli; 
	private int avgEndVisit; 
	private int avgEndDeli;
	private int initCost=0;
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
}