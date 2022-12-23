package com.findgeo.dto;

import java.time.LocalDateTime;

import com.findgeo.entity.Posts;

import lombok.Getter;

@Getter
public class PostsResponseDto {
   private Long boardid;
   private String boardtitle;
   private String boardcontent;
   private String nickname;
   private String email;
   private LocalDateTime regdate;
   private int views;
   private String fileinput;
   
   public PostsResponseDto(Posts entity) {
      this.boardid = entity.getBoardid();
      this.boardtitle =entity.getBoardtitle();
      this.boardcontent = entity.getBoardcontent();
      this.nickname = entity.getNickname();
      this.email = entity.getEmail();
      this.regdate = entity.getRegdate();
      this.views = entity.getViews();
      this.fileinput = entity.getFileinput();
   }
}