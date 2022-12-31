package com.findgeo.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.findgeo.config.dto.SessionMember;
import com.findgeo.dto.PlannerFormDto;
import com.findgeo.entity.Planner;
import com.findgeo.service.PlannerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/planner")
public class PlannerController {
	private final PlannerService plannerService;
	private final HttpSession httpSession;

	@GetMapping("/write")
	public String plannerWriteForm(Model model) {
		model.addAttribute("plannerFormDto", new PlannerFormDto());
		return "planner/plannerinput";
	}

	@PostMapping("/writepro")
	public String plannerWritePro(PlannerFormDto plannerFormDto, Model model, Principal principal) {
		model.addAttribute("message", "플래너 작성이 완료되었습니다.");
		SessionMember member = (SessionMember) httpSession.getAttribute("user");
		String emailId = "";
		if (principal != null && member == null) {
			emailId = principal.getName();
		} else if (principal != null && member != null) {
			emailId = member.getEmail();
		} else {
			model.addAttribute("message", "다시 로그인 해주세요");
			return "/members/login";
		}
		plannerFormDto.setEmailId(emailId);
		plannerService.plannerWrite(plannerFormDto);
		return "redirect:/planner/list";
	}

	@GetMapping(value = { "/list", "/list/{page}" })
	public String plannerList(Model model, Principal principal, @PathVariable("page") Optional<Integer> page)
			throws Exception {
		SessionMember member = (SessionMember) httpSession.getAttribute("user");
		String emailId = "";
		if (principal != null && member == null) {
			emailId = principal.getName();
		} else if (principal != null && member != null) {
			emailId = member.getEmail();
		} else {
			model.addAttribute("message", "다시 로그인 해주세요");
			return "/members/login";
		}
		System.out.println(emailId);
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);
		Page<Planner> planners = plannerService.selectPlannerListPage(emailId, pageable);
		model.addAttribute("plannerFormDto", planners);
		model.addAttribute("maxPage", 5);
		return "planner/plannerlist";
	}

	@GetMapping("/view/{plannerid}")
	public String plannerView(Model model, @PathVariable("plannerid") Long plannerId) {
		Planner plannerFormDto = plannerService.selectPlanner(plannerId);
		model.addAttribute("planner", new PlannerFormDto());
		model.addAttribute("plannerView", plannerFormDto);
		return "planner/plannerview";
	}

	@GetMapping("/pdf/{plannerid}")
	public String plannerpdf(Model model, @PathVariable("plannerid") Long plannerId) {
		Planner plannerFormDto = plannerService.selectPlanner(plannerId);
		model.addAttribute("planner", new PlannerFormDto());
		model.addAttribute("plannerView", plannerFormDto);
		System.out.println(plannerFormDto.getCostRate() + "cont costrate");
		System.out.println(model.getAttribute("plannerView"));
		return "planner/plannerPdf";
	}

	@PostMapping("/editpro/{plannerid}")
	public String plannerUpdate(PlannerFormDto planner) throws Exception {
		Optional<Planner> plannerDto = plannerService.updatePlanner(planner);
		return "redirect:/planner/list";
	}

	@GetMapping("/deletepro/{plannerid}")
	public String plannerDelete(@PathVariable("plannerid") Long plannerId) {
		plannerService.plannerDelete(plannerId);
		return "redirect:/planner/list";
	}
}