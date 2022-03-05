package com.chenjie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chenjie.dao.model.CrawlTaskModel;
import com.chenjie.entity.BaseParam;
import com.chenjie.entity.params.CrawlTaskParam;
import com.chenjie.service.CrawlTaskService;

@RestController
@RequestMapping("task")
public class TaskController {
	@Autowired
	private CrawlTaskService taskService;
	
	@PostMapping("create")
	public void create(CrawlTaskModel taskParam) { 
		// TODO
	}
	
	@PostMapping("execute")
	public void execute(CrawlTaskParam crawlTaskModel) {
		taskService.execute(crawlTaskModel);
	}
}
