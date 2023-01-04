package com.findgeo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.findgeo.dto.PostSearchDto;
import com.findgeo.entity.Posts;

public interface PostsRepositoryCustom {
	Page<Posts> getPostPage(PostSearchDto postSearchDto, Pageable pageable);
}
