package com.chenjie.dao.model;

import lombok.Data;

@Data
public class CrawlTaskModel {
	private Integer id; 
	
	private String name; 
	
	private String ruleJson;
	
	private String createTime;
	
	private String updateTime;
	
	private Integer userId;
	
	private User user;

	@Override
	public String toString() {
		return "CrawlTaskModel [id=" + id + ", name=" + name + ", ruleJson=" + ruleJson + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", userId=" + userId + "]";
	} 
}
