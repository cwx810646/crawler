package com.chenjie.core.project.anjuke;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.chenjie.core.crawler.Crawler;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class AnjukeCrawler implements Crawler<List<Loupan>> {
	private String url;

	private WebDriver driver;

	public AnjukeCrawler(String url) {
		this.url = url;
		initDriver();
	}

	public void initDriver() {
		ChromeOptions options = new ChromeOptions();
		// options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		// options.setAcceptInsecureCerts(false);
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		
	}

	@Override
	public List<Loupan> run() {
		long startTime = System.currentTimeMillis();
		List<Loupan> loupans = new ArrayList<Loupan>();
		try {
			log.info("---------anjuke craw start---------");
			AnjukeLoader loader = new AnjukeLoader(url, driver);
			log.info("start load");
			List<String> htmls = loader.load(); 
			log.info("there {} page need parse");	
			for (String html : htmls) { 
				AnjukeParser parser = new AnjukeParser(html, driver);
				loupans.addAll(parser.parse());
			}
			System.out.println(loupans.size());
			log.info("---------anjuke craw end, cost time {}s---------", (System.currentTimeMillis() - startTime) / 1000);
		} catch (Exception e) { 
			log.error("---------anjuke craw error, cost time {}s, {}---------", (System.currentTimeMillis() - startTime) / 1000, e);
			driver.quit();
		}
		return loupans;
	}
}
