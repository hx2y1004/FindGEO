package com.findgeo.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.findgeo.service.*;
import com.findgeo.config.dto.SessionMember;
import com.findgeo.dto.PostsResponseDto;
import com.findgeo.entity.Member;
import com.findgeo.entity.Posts;
import com.findgeo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	public final PostService postService;
	private final HttpSession httpSession;
	private final MemberRepository memberRepository;
	private final CommentService commentService;

	@GetMapping("/board/boardlist")
	public String board(Model model, @RequestParam(required = false, defaultValue = "0", value = "page") int page) {
		Page<Posts> listPage = postService.list(page);

		int totalPage = listPage.getTotalPages();

		// @를 기준으로 문자열을 추출할 것.
		String sub_email = listPage.getContent().get(totalPage).getEmail();
		// 먼저 @의 인덱스를 찾는다.
		int idx = sub_email.indexOf("@");
		// @ 앞 부분을 추출
		String sub_Email = sub_email.substring(0, idx) + "@******";
		model.addAttribute("posts", listPage.getContent());
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("boardlist_hiddenEmail", sub_Email);
		System.out.println(listPage.getContent().get(totalPage).getEmail() + "여기는 이메일 자르고 뒤에 * 찍기위함 여기는 보드컨트롤러 ");

		return "/board/boardlist";
	}

	// 저장
	@GetMapping("/board/postssave")
	public String postsSave(Model model, Principal principal) throws Exception {
		SessionMember member = (SessionMember) httpSession.getAttribute("user");
		if (principal != null && member == null) {
			Member user = memberRepository.findByEmail(principal.getName());
			model.addAttribute("member", user);
		} else if (principal != null && member != null) {
			model.addAttribute("member", member);
			model.addAttribute("loginInfo", "social");
		}
		return "/board/postsSave";
	}


	// 조회
	@GetMapping("/post/info/{boardid}")
	public String postsInfo(@PathVariable Long boardid, Model model, Principal principal) throws Exception {
		postService.updateView(boardid); // views ++
		PostsResponseDto dto = postService.findById(boardid);
		Member member = memberRepository.findByEmail(dto.getEmail());
		String email = member.getEmail();

//		List<CommentDto> commentdto = commentService.readAll(boardid);
//		model.addAttribute("comment",commentdto);
//		System.out.println(commentdto.get(0));

		if (principal.getName().equals(email)) {
			model.addAttribute("check", true);
		}
		System.out.println(principal.getName() + "====");
		System.out.println(email + "*****");

		SessionMember mem = (SessionMember) httpSession.getAttribute("user");
		if (principal != null && mem == null) {
			Member user = memberRepository.findByEmail(principal.getName());
			model.addAttribute("member", user);
		} else if (principal != null && mem != null) {
			model.addAttribute("member", mem);
			model.addAttribute("loginInfo", "social");
		}

		// @를 기준으로 문자열을 추출할 것.
		String sub_email = member.getEmail();
		// 먼저 @의 인덱스를 찾는다.
		int idx = sub_email.indexOf("@");
		// @ 앞 부분을 추출
		String sub_Email = sub_email.substring(0, idx) + "@******";
		System.out.println(sub_Email + "@*****이거 해도되냐 썅!!!!!!!??????????");

		if (principal.getName().equals(email)) {
			model.addAttribute("check", true);
		}
		System.out.println(principal.getName() + "====");
		System.out.println(email + "*****");
		model.addAttribute("posts", dto);
		model.addAttribute("sub_Email", sub_Email);
		model.addAttribute("posts", dto);
		return "/board/postsInfo";
	}

	// 수정
	@GetMapping("/post/update/{boardid}")
	public String postsUpdate(@PathVariable Long boardid, Model model) {
		PostsResponseDto dto = postService.findById(boardid);
		model.addAttribute("posts", dto);
		return "/board/postsUpdate";
	}
	   //검색
		@GetMapping("/post/search")
		public String search(@RequestParam("searchQuery") String keyword, Model model) {
	        List<Posts> searchList = postService.search(keyword);
	        System.out.println(searchList.get(0).getEmail());
	        model.addAttribute("posts", searchList);

		    return "board/boardlist";
		}
}
