package com.findgeo.dto;

import com.findgeo.entity.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostsSaveRequestDto {
   private String boardtitle;
   private String boardcontent;
   private String nickname;
   private String fileinput;
   private String email;
   
   
   
@Builder
public PostsSaveRequestDto(String boardtitle, String boardcontent, String nickname, String fileinput, String email) {
		 this.boardtitle = boardtitle;
         this.boardcontent = boardcontent;
         this.nickname = nickname;
         this.email = email;
         this.fileinput = fileinput;
         this.email = email;
         System.out.println(PostsSaveRequestDto.builder().fileinput+"12월 8일 실험");
         
   }
   
   
   public Posts toPosts() {
      return Posts.builder()
            .boardtitle(boardtitle)
            .boardcontent(boardcontent)
            .nickname(nickname)
            .email(email)
            .fileinput(fileinput)
            .email(email)
            .build();
      // 빌더 패턴 각각 생성자로 객체 생성
   }
   
   public Posts toEntity() {
      return Posts.builder().boardtitle(boardtitle).boardcontent(boardcontent).build();
   }
}