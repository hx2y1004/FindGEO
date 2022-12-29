package com.findgeo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
   private String boardtitle;
   private String boardcontent;
   private String fileinput;
   
   @Builder
   public PostsUpdateRequestDto(String boardtitle, String boardcontent, String fileinput) {
      this.boardtitle = boardtitle;
      this.boardcontent = boardcontent;
      this.fileinput = fileinput;
   }
}
