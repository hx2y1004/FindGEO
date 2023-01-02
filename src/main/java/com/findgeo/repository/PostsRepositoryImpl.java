package com.findgeo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.findgeo.dto.postSearchDto;
import com.findgeo.entity.Posts;
import com.findgeo.entity.QPosts;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class PostsRepositoryImpl implements PostsRepositoryCustom {
	private JPAQueryFactory queryFactory;
	
	public PostsRepositoryImpl (EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}
	
	@Override
	public Page<Posts> getPostPage(postSearchDto postSearchDto, Pageable pageable) {
		
		List<Posts> content = queryFactory
                .selectFrom(QPosts.posts)
                .where(
                		QPosts.posts.boardtitle.like("%" + postSearchDto.getSearchQuery() + "%"))
                .orderBy(QPosts.posts.boardid.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory.select(Wildcard.count).from(QPosts.posts)
                .where(QPosts.posts.boardtitle.like("%" + postSearchDto.getSearchQuery() + "%"))
                .fetchOne()
                ;

        return new PageImpl<>(content, pageable, total);
		
	} 
	
}