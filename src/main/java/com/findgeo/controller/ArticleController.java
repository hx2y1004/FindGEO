package com.findgeo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.findgeo.dao.ArticleDao;
import com.findgeo.dto.ArticleDto;

@Controller
@RequestMapping("/news")
public class ArticleController {

	@Autowired
	ArticleDao articleDao;
	
	@GetMapping("/{articleid}")
	@ResponseBody
	public Map getArticle(@PathVariable("articleid") Long articleId) {
		ArticleDto articleDto = articleDao.articleDao(articleId);
		Map<String,String> outputMap = new HashMap<String,String>();
		
		outputMap.put("article_img",articleDto.getChangup_article_img());
		outputMap.put("article_title_link", articleDto.getChangup_article_title_link());
		outputMap.put("article_title", articleDto.getChangup_article_title());
		outputMap.put("news_name", articleDto.getNews_changup_name());
		outputMap.put("new_logo_img", articleDto.getNews_logo_changup_img());
		outputMap.put("article",articleDto.getChangup_article());
		return outputMap;
	}
	
	@GetMapping("/articles")
	@ResponseBody
	public List<Map> getArticleList(HttpServletRequest req) {
		String key1 = req.getParameter("key1");
		String key2 = req.getParameter("key2");
		String key3 = req.getParameter("key3");
		String key4 = req.getParameter("key4");
		String key5 = req.getParameter("key5");
		String keyword = req.getParameter("keyword");
		int pageNum = 1;
		if(req.getParameter("page")!=null && req.getParameter("page")!="") {
			pageNum = Integer.parseInt(req.getParameter("page"));
		}
		int pageSize = 5;
		int maxPageNum = pageNum*pageSize;
		int minPageNum = maxPageNum-(pageSize-1);
		Map<String,Object> inputMap = new HashMap<String,Object>();
		inputMap.put("key1", key1);
		inputMap.put("key2", key2);
		inputMap.put("key3", key3);
		inputMap.put("key4", key4);
		inputMap.put("key5", key5);
		inputMap.put("keyword", keyword);
		inputMap.put("pageSize", pageSize);
		inputMap.put("offset", minPageNum-1);
		List<ArticleDto> listDto;
		if(key1 == null && key2 == null && key3== null && key4 == null && key5 == null) {
			listDto = articleDao.articleAllDao(inputMap);
		}
		else {
			listDto = articleDao.articleListDao(inputMap);
		}
		List<Map> list = new ArrayList<Map>();
		for(ArticleDto dto : listDto) {
			Map<String,String> outputMap = new HashMap<String,String>();
			outputMap.put("article_img",dto.getChangup_article_img());
			outputMap.put("article_title_link", dto.getChangup_article_title_link());
			outputMap.put("article_title", dto.getChangup_article_title());
			outputMap.put("news_name", dto.getNews_changup_name());
			outputMap.put("new_logo_img", dto.getNews_logo_changup_img());
			outputMap.put("article",dto.getChangup_article());
			list.add(outputMap);
		}
		return list;
	}
}
