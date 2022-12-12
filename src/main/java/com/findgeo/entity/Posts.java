package com.findgeo.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

   @DynamicInsert
   @Entity
   @Getter
   @NoArgsConstructor
   public class Posts {
      
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long boardid;
   
   @Column (length=500, nullable=false)
   private String boardtitle;
   
   @Column (length=2000)
   private String fileinput;
   
   
   @Column (length=2000, nullable=false)
   private String boardcontent;
   
   private String nickname;
   
   @CreatedDate
   @Column(updatable = false)
   private LocalDateTime regdate = LocalDateTime.now();
   
   @Column(columnDefinition = "integer default 0", nullable = false)   // 조회수의 기본 값을 0으로 지정, null 불가 처리
   private int views;
   
   @Builder
   public Posts(String boardtitle, String boardcontent, String nickname, int views, String fileinput) {
      this.boardtitle = boardtitle;
      this.boardcontent = boardcontent;
      this.nickname = nickname;
      this.views = views;
      this.fileinput = fileinput;
   
   }
   
   public void update(String boardtitle, String boardcontent) {
       this.boardtitle = boardtitle;
       this.boardcontent = boardcontent;
   }
}