package com.findgeo.config.dto;

import java.io.Serializable;

import com.findgeo.entity.Member;

import lombok.Getter;

@Getter
public class SessionMember implements Serializable{

   private String nickname;
   private String email;
   private String password;
   private String phone;
   private String picture;
   private String role;
   
      public SessionMember(Member member) {
         this.nickname = member.getNickname();
         this.email = member.getEmail();
         this.password = member.getPassword();
         this.phone = member.getPhone();
         this.picture = member.getPicture();
         this.role = member.getRoleKey();
         
   }
}