package com.chenjie.entity;  
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.chenjie.entity.enums.SelectTypeEnum;
import com.chenjie.utils.RegexUtils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class HtmlCrawlTask {    
	private HtmlRule htmlRule;  
	
	private Map<String, Document> documentMap; 
	
	private List<Map<String, String>> datas;
	
	public HtmlCrawlTask() {
		this(null);
	}

	public HtmlCrawlTask(HtmlRule htmlRule) {
		this.htmlRule = htmlRule; 
		this.documentMap = new HashMap<String, Document>();
		this.datas = new ArrayList<Map<String,String>>();
	} 
	
	public void execute() {  
		initLinkPool(); 
		parse();
		save();
	}
	
	private void initLinkPool() {
		long startTime = System.currentTimeMillis(); 
		log.info("------set linkPool start------");
		addLinksByUrl(htmlRule.getUrl(), 0); 
		log.info("------set linkPool end, cost time {} s------", (System.currentTimeMillis() - startTime)/1000);
	}  
	
	private void addLinksByUrl(String url, int floor) {  
		documentMap.put(url, null);
		try {
			Document document = Jsoup.connect(url).get();
			documentMap.put(url, document);
			log.info("-----------linkPool {}, {}", documentMap.size(), url);
			Element element = document.body();
			Elements elements = element.getElementsByTag("a");
			List<String> links = elements.eachAttr("href"); 
			if (floor < htmlRule.getDeep()) {
				links.stream().filter(
					link -> {return StringUtils.isNotBlank(link);}
				).distinct().forEach(link -> {  
					if(RegexUtils.isUrl(link) && !documentMap.containsKey(link)) { 
						addLinksByUrl(link, floor+1); 
					} 
				});
			}

		} catch (Exception e) {
			log.info("{}", e.getMessage());
		} 
	} 
	
	private void parse(){ 
		for(Document document : documentMap.values()) {
			if (document != null) { 
				match(document);
			}
		}
	}
	
	private void match(Document document) {
		Element body = document.body();
	    Elements elements = matchContainer(body);
	    if (elements != null) {
			elements.forEach(container ->{
				matchData(container);
			});
		}
	}
	
	private Elements matchContainer(Element body) {
		Elements elements = null;
		String container = htmlRule.getContainer();
		SelectTypeEnum containerSelectType = htmlRule.getContainerSelectType();
		switch (containerSelectType) {
		case TAG: 
			elements = body.getElementsByTag(container);
			break;
		case CLASS:
			elements = body.getElementsByClass(container);
			break;  
		default:
			break;
		}
		return elements;
	}

	private void matchData(Element element) {
		Map<String, String> dataSelectMap = htmlRule.getDataSelectMap();
		SelectTypeEnum dataSelectType = htmlRule.getDataSelectType();
		Map<String, String> data = null;
		for(String key : dataSelectMap.keySet()) { 
			String select = dataSelectMap.get(key);
			Elements elements = null;
			switch (dataSelectType) {
			case TAG: 
				elements = element.getElementsByTag(select); 
				break;
			case CLASS:
				elements = element.getElementsByClass(select);
				break;  
			default:
				break;
			} 
			Element dataElement = elements.first();
			if (dataElement != null) {
				if(data == null) {
					data = new HashMap<String, String>();
				}
				data.put(key, dataElement.text()); 
			} 
		}
		if (data != null) {
			datas.add(data);	
		}
	}
	
	/**
	 *  写入数据
	 */
	private void save() {
		
	}
	
	public void showDatas() {
		for (Map<String, String> map : datas) {
			for(String key : map.keySet()) {
				System.out.print(key + ":" + map.get(key) + ",");
			}
			System.out.println(";");
		}
	} 
}
