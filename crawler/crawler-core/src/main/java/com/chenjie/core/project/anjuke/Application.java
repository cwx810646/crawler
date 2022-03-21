package com.chenjie.core.project.anjuke;

public class Application {
    public static void main(String[] args) {
        init();
        String url = "https://xa.fang.anjuke.com/loupan/xixianxinqu/"; 
        AnjukeCrawler crawler = new AnjukeCrawler(url);
        crawler.run();
    }

    public static void init(){
        System.setProperty("webdriver.chrome.driver", "E:\\code\\crawler\\crawler\\webdrivers\\chromedriver-99.0.4844.exe");
    }
}
