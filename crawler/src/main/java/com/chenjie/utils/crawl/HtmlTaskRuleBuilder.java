package com.chenjie.utils.crawl;

import com.chenjie.entity.HtmlRule;

public class HtmlTaskRuleBuilder {
	private HtmlRule htmlRule;
	
	private HtmlTaskRuleBuilder() {
		htmlRule = new HtmlRule();
	}
	
	public static HtmlTaskRuleBuilder getInstance() {
		return new HtmlTaskRuleBuilder();
	}
	
	public void setBase(String url) {
		htmlRule.setUrl(url);
	}
	
	public HtmlTaskRuleBuilder setBase(String url, Integer deep) {
		setBase(url);
		htmlRule.setDeep(deep);
		return this;
	}
	
	public HtmlTaskRuleBuilder setDataContainerRule(String url, Integer deep) {
		setBase(url);
		htmlRule.setDeep(deep);
		return this;
	}
	
	
	public HtmlRule build() {
		return htmlRule;
	}
}
