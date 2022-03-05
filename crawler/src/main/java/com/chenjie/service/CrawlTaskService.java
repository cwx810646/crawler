package com.chenjie.service;

import com.chenjie.dao.model.CrawlTaskModel;
import com.chenjie.entity.params.CrawlTaskParam;

public interface CrawlTaskService {
	public void create(CrawlTaskModel taskParam);

	public void execute(CrawlTaskParam taskParam);
	
	CrawlTaskModel queryCrawTaskById(Integer id);
}
