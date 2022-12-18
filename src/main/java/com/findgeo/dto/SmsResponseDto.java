package com.findgeo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class SmsResponseDto {
	String requestId;
	LocalDateTime requestTime;
	String statusCode;
	String statusName;
	String to;
	String content;
}
