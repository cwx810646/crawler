package com.chenjie.utils.crawl;

import java.util.Objects;

import com.alibaba.fastjson.JSON;
import com.chenjie.dao.model.CrawlTaskModel; 
import com.chenjie.entity.HtmlCrawlTask;
import com.chenjie.entity.HtmlRule; 

public class CrawlParseUtils {
	public HtmlCrawlTask parseByModel(CrawlTaskModel crawlTaskModel) {
		HtmlCrawlTask ct = null;
		if(Objects.nonNull(crawlTaskModel)) { 
			String ruleJson = crawlTaskModel.getRuleJson();
			HtmlRule htmlRule = JSON.parseObject(ruleJson, HtmlRule.class); 
			ct = new HtmlCrawlTask(htmlRule);
		}
		return ct;
	}
}
