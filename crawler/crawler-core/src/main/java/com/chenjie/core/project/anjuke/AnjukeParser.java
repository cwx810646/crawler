package com.chenjie.core.project.anjuke;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

import lombok.Data;

@Data
public class AnjukeParser{ 
    private String html;

    private WebDriver driver = null;
    
    public AnjukeParser(String html, WebDriver driver) {
    	this.html = html;
    	this.driver = driver;
    }

    public  List<Loupan> parse() {
        if (StringUtil.isBlank(html)) return null;
        Document document = Jsoup.parse(html);
        Elements elements = document.select("#container .list-results .item-mod");
        List<Loupan> loupans = new ArrayList<>();
        elements.forEach(element -> {
            String link = element.attr("data-link");
            Loupan loupan = loupanCrawler(link);
            if (loupan != null) loupans.add(loupan);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return loupans;
    }

    public Loupan loupanCrawler (String url){
        AnjuleLoupanLoader loader = new AnjuleLoupanLoader(url, driver);
        String html = loader.load();
        AnjuleLoupanParser parser = new AnjuleLoupanParser(html);
        return parser.parse();
    }
}
