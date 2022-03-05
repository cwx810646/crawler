package com.chenjie.entity;  
 
import java.io.File;
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
public class CrawlTask {  
	private String url;
	
	private HtmlRule dataRule; 
	
	private int deep;
	
	private Map<String, Document> documentMap; 
	
	private List<Map<String, String>> datas;
	
	public CrawlTask() {
		this(null, null);
	}

	public CrawlTask(String url, HtmlRule dataRule) {
		this(url, dataRule, 0);
	}
	
	public CrawlTask(String url, HtmlRule dataRule, int deep) {
		this.url = url;
		this.dataRule = dataRule;
		this.deep = deep;
		this.documentMap = new HashMap<String, Document>();
		this.datas = new ArrayList<Map<String,String>>();
	}
	
	public void run() {  
		initLinkPool(); 
		parse();
		save();
	}
	
	private void initLinkPool() {
		long startTime = System.currentTimeMillis(); 
		log.info("------set linkPool start------");
		addLinksByUrl(url, 0);
		// String path = "D:\\learn\\code\\github\\crawler\\crawler\\src\\main\\resources\\taskFile\\one.html";
		// addLinksByPath(path, 0);
		log.info("------set linkPool end, cost time {} s------", (System.currentTimeMillis() - startTime)/1000);
	} 
	
	private void addLinksByPath(String path, int floor) {  
		documentMap.put(path, null);
		try {
			File file = new File(path);
			Document document = Jsoup.parse(file, "UTF-8");
			documentMap.put(path, document);
			log.info("-----------linkPool {}, {}", documentMap.size(), url);
			Element element = document.body();
			Elements elements = element.getElementsByTag("a");
			List<String> links = elements.eachAttr("href"); 
			if (floor < this.deep) {
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
	
	private void addLinksByUrl(String url, int floor) {  
		documentMap.put(url, null);
		try {
			Document document = Jsoup.connect(url).get();
			documentMap.put(url, document);
			log.info("-----------linkPool {}, {}", documentMap.size(), url);
			Element element = document.body();
			Elements elements = element.getElementsByTag("a");
			List<String> links = elements.eachAttr("href"); 
			if (floor < this.deep) {
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
		String container = dataRule.getContainer();
		SelectTypeEnum containerSelectType = dataRule.getContainerSelectType();
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
		Map<String, String> dataSelectMap = dataRule.getDataSelectMap();
		SelectTypeEnum dataSelectType = dataRule.getDataSelectType();
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
	
	public static void main(String[] args) {
		String url = "https://www.mi.com";
		
		String container = "li";
		SelectTypeEnum containerSelectType = SelectTypeEnum.TAG;
		
		Map<String, String> dataSelectMap = new HashMap<String, String>(); 
		SelectTypeEnum dataSelectType = SelectTypeEnum.CLASS;
		dataSelectMap.put("名称", "title");
		dataSelectMap.put("描述", "desc");
		dataSelectMap.put("价格", "price"); 
		
		HtmlRule dataRule = new HtmlRule(container, containerSelectType, dataSelectMap, dataSelectType);
		
		CrawlTask task = new CrawlTask(url, dataRule, 1);
		task.run();  
		task.showDatas();
	}
}
