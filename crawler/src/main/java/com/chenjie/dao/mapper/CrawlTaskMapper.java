package com.chenjie.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chenjie.dao.model.CrawlTaskModel;

public interface CrawlTaskMapper {
	void create(CrawlTaskModel taskModel);
	
	CrawlTaskModel queryCrawTaskById(@Param("id") Integer id);
	
	List<CrawlTaskModel> queryCrawTasks(CrawlTaskModel taskModel);
}
