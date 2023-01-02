package com.findgeo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.findgeo.dto.CommentDto;
import com.findgeo.entity.Comment;
import com.findgeo.repository.CommentRepository;
import com.findgeo.repository.CommentRepositoryImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {

//	private final MemberRepository memberRepository;
//	private final PostsRepository postsRepository;
	private final CommentRepository commentRepository;
	private final CommentRepositoryImpl commentRepositoryImpl;

	@Transactional
	public List<CommentDto> readCommentFromParentid(Long boardid) throws Exception {
		return commentRepositoryImpl.findAllCommentFromParentid(boardid);
	}

	@Transactional
	public List<Comment> readComment(Long boardid) {
		return commentRepository.findByBoardid(boardid);
	}

	@Transactional
	public Long create(Comment comment) {
		return commentRepository.save(comment).getCommentid();
	}

	@Transactional
	public void delete(Long commentid) {
		Comment comment = commentRepository.findByCommentid(commentid);
		System.out.println(comment.getCommentid());
		commentRepository.delete(comment);
	}

	public void commentDeleteByEmail(String email) {
		commentRepository.deleteByEmail(email);
	}
	
	public void deleteByBoardid(Long boardid) {
		commentRepository.deleteByBoardid(boardid);
		
	}

}
