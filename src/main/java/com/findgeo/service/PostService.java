package com.findgeo.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import com.findgeo.dto.PostsResponseDto;
import com.findgeo.dto.PostsSaveRequestDto;
import com.findgeo.entity.Posts;
import com.findgeo.repository.PostsRepository;

import com.findgeo.dto.PostsUpdateRequestDto;
import com.findgeo.dto.postSearchDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
	private final PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toPosts()).getBoardid();
	}
	
	@Transactional
	public Page<Posts> ListPage(postSearchDto postSearchDto , Pageable pageable){
//		int page = 0;
//		if (pageable.getPageNumber() != 0) { // if (2 != 0)
//			page = pageable.getPageNumber(); // page = 2 - 1
//		}
//		pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "boardid");
		return postsRepository.getPostPage(postSearchDto, pageable);	
	}
	


	public PostsResponseDto findById(Long boardid) {
		Posts posts = postsRepository.findById(boardid)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. boardid=" + boardid));
		return new PostsResponseDto(posts);
	}

	// 게시글 수정
	@Transactional
	public Long update(Long boardid, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(boardid)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. boardid=" + boardid));
		posts.update(requestDto.getBoardtitle(), requestDto.getBoardcontent(), requestDto.getFileinput());
		return boardid;
	}

	@Transactional
	public void delete(Long boardid) {
		Posts posts = postsRepository.findById(boardid)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. boardid=" + boardid));
		postsRepository.delete(posts);
	}

	/* Views Counting */
	@Transactional
	public int updateView(Long boardid) {
		return this.postsRepository.updateView(boardid);
	}
	
	public void postDeleteByEmail(String email) {
	      postsRepository.deleteByEmail(email);
	   }

	public int isPostExist(Long boardid) {
		return postsRepository.countByBoardid(boardid);
	}

//	// 사용자가 검색창에 입력한 값 제목 검색
//	@Transactional
//	public List<Posts> search(String keyword, @PageableDefault(size = 10, sort = "boardid", direction = Sort.Direction.DESC) Pageable pageable) {
//		List<Posts> postsList = postsRepository.findByBoardtitleContaining(keyword, pageable);
//		return postsList;
//	}
	


}
