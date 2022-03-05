package com.huawei.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chenjie.dao.model.CrawlTaskModel;
import com.chenjie.service.CrawlTaskService;
import com.huawei.ApplicationTests;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CrawlTaskServiceTest extends ApplicationTests{
	@Autowired
	private CrawlTaskService crawlTaskService;
	
	@Test
	public void create() { 
		CrawlTaskModel crawlTaskModel = new CrawlTaskModel();
		crawlTaskModel.setName("test1");
		crawlTaskModel.setRuleJson("123456");
		crawlTaskModel.setUserId(3);
		crawlTaskService.create(crawlTaskModel);
	}
	
	@Test
	public void queryCrawTaskById() {  
		CrawlTaskModel crawlTaskModel = crawlTaskService.queryCrawTaskById(1);
		log.info(crawlTaskModel.toString());
	}
}
