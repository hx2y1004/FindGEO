package com.findgeo.dto;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import com.findgeo.entity.Comment;
import com.findgeo.repository.CommentRepository;
import com.findgeo.repository.MemberRepository;
import com.findgeo.repository.PostsRepository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateRequest {


    @NotBlank(message = "댓글을 입력해주세요.")
    private String content;

    @NotNull(message = "게시글 아이디를 입력해주세요.")
    @Positive(message = "올바른 게시글 아이디를 입력해주세요.")
    private Long boardId;

    @Null
    private String email;


    private Long parentId;

    public static Comment toEntity(CommentCreateRequest req, MemberRepository memberRepository, PostsRepository postRepository, CommentRepository commentRepository) {
        return new Comment(
                req.content,
                memberRepository.findByEmail(req.email),
                postRepository.findById(req.boardId).orElseThrow(),
                Optional.ofNullable(req.parentId)
                        .map(id -> commentRepository.findById(id).orElseThrow())
                        .orElse(null)
        );
    }
}
