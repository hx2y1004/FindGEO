package com.findgeo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.findgeo.dto.CommentCreateRequest;
import com.findgeo.dto.CommentDto;
import com.findgeo.dto.CommentReadCondition;
import com.findgeo.entity.Comment;
import com.findgeo.entity.Member;
import com.findgeo.entity.Posts;
import com.findgeo.repository.CommentRepository;
import com.findgeo.repository.CommentRepositoryImpl;
import com.findgeo.repository.MemberRepository;
import com.findgeo.repository.PostsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	
	private final MemberRepository memberRepository;
	private final PostsRepository postsRepository;
	private final CommentRepository commentRepository;
	private final CommentRepositoryImpl commentRepositoryImpl;
	
	
	
    public List<CommentDto> readAll(Long boardid) throws Exception { 
        return commentRepositoryImpl.findAllWithMemberAndParentByPostIdORderByParenIdAscNullsFirstCommentIdAsc(boardid);
        
    }

    @Transactional
    public void create(CommentCreateRequest req) { 
        commentRepository.save(CommentCreateRequest.toEntity(req, memberRepository, postsRepository, commentRepository));
    }

    @Transactional
    public void delete(Long id) { 
        Comment comment = commentRepository.findById(id).orElseThrow();
        comment.findDeletableComment().ifPresentOrElse(commentRepository::delete, comment::delete);
    }
    
   
}
