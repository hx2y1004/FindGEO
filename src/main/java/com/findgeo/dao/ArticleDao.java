package com.findgeo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.findgeo.dto.ArticleDto;

@Mapper
public interface ArticleDao {
	public ArticleDto articleDao(Long id); //기사 하나 가져오기
	public List<ArticleDto> articleListDao(Map<String, Object> inputMap);
	public List<ArticleDto> articleAllDao(Map<String, Object> inputMap);
}
