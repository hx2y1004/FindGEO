package com.findgeo.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.findgeo.entity.Comment;
import com.querydsl.core.annotations.QueryProjection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	private Long commentid;
	private String content;
	private MemberFormDto member;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createDate;
    private List<CommentDto> children;

    public CommentDto(Long commentid, String content, MemberFormDto member, List<CommentDto> children) {
    	this.commentid = commentid;
    	this.content = content;
    	this.member = member;
    	this.children = children;
    }
    
    public static List<CommentDto> toDtoList(List<Comment> comments) throws Exception {
        NestedConvertHelper helper = NestedConvertHelper.newInstance(
                comments,
                c -> new CommentDto(c.getCommentid(), c.isDeleted() ? null : c.getContent(), c.isDeleted() ? null : MemberFormDto.toDto(c.getMember()), c.getCreateDate(), new ArrayList<>()),
                c -> c.getParent(),
                c -> c.getCommentid(),
                d -> d.getChildren());
        return helper.convert();
    }

    

}
