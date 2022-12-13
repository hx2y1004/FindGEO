package com.findgeo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.findgeo.dto.PostsListResponseDto;
import com.findgeo.dto.PostsResponseDto;
import com.findgeo.dto.PostsSaveRequestDto;
import com.findgeo.entity.Posts;
import com.findgeo.repository.PostsRepository;
import com.findgeo.dto.PostsUpdateRequestDto;

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
	public Page<Posts> list(int page){
		return postsRepository.findAll(PageRequest.of(page, 10,Sort.by(Sort.Direction.DESC,"boardid")));
	}
	
	public PostsResponseDto findById(Long boardid) {
		Posts posts = postsRepository.findById(boardid)
				.orElseThrow(()->new IllegalArgumentException("해당 게시글이 업습니다. boardid="+ boardid));
		return new PostsResponseDto(posts);
	}
	
	@Transactional
	public Long update(Long boardid, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(boardid)
					.orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. boardid=" + boardid));
		posts.update(requestDto.getBoardtitle(), requestDto.getBoardcontent());
		return boardid;
	}
	
	@Transactional
	public void delete(Long boardid) {
		Posts posts = postsRepository.findById(boardid)
				.orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. boardid=" + boardid));
		postsRepository.delete(posts);
	}
	
	/* Views Counting */
	@Transactional
	public int updateView(Long boardid) {
		return this.postsRepository.updateView(boardid);
	}

}
