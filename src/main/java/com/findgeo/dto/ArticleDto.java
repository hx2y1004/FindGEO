package com.findgeo.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {

	@Id
	Long crawl_idx;
	String news_logo_changup_img;
	String news_changup_name;
	String changup_article_title;
	String changup_article_title_link;
	String changup_article;
	String changup_article_img;
	int pageNum;
}
