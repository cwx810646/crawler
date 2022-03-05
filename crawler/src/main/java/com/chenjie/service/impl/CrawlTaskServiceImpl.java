package com.chenjie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenjie.dao.mapper.CrawlTaskMapper;
import com.chenjie.dao.model.CrawlTaskModel;
import com.chenjie.entity.CrawlTask;
import com.chenjie.entity.params.CrawlTaskParam;
import com.chenjie.service.CrawlTaskService;

@Service
public class CrawlTaskServiceImpl implements CrawlTaskService{ 
	@Autowired
	private CrawlTaskMapper crawlTaskMapper;
	
	@Override
	public void execute(CrawlTaskParam taskParam) {
		CrawlTaskModel crawlTaskModel = queryCrawTaskById(taskParam.getId());
		
	} 

	@Override
	public void create(CrawlTaskModel crawlTaskModel) {
		crawlTaskMapper.create(crawlTaskModel); 
	}

	@Override
	public CrawlTaskModel queryCrawTaskById(Integer id) { 
		return crawlTaskMapper.queryCrawTaskById(id);
	} 
}
