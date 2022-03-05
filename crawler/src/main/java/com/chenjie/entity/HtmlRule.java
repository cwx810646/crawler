package com.chenjie.entity; 

import java.util.Map;

import lombok.Data;

@Data
public class HtmlRule {  
	private String url;
	
	private int deep;

	private String containerSelector;
	
	private Map<String, String> dataSelectorMap;
	
	public HtmlRule() {
		this(null, null);
	}
	
	public HtmlRule(String url, Map<String, String> dataSelectorMap) {
		this(url, null, dataSelectorMap, 0);
	}
	
	public HtmlRule(String url, String containerSelector, Map<String, String> dataSelectorMap) {
		this(url, containerSelector, dataSelectorMap, 0);
	}
	
	public HtmlRule(String url, String containerSelector, Map<String, String> dataSelectorMap, int deep) {
		this.url = url;
		this.containerSelector = containerSelector;
		this.dataSelectorMap = dataSelectorMap;
		this.deep = deep;
	}
	
}
