package com.chenjie.core.project.anjuke;

public class Application {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\project\\search\\driver\\chromedriver-99.0.4844.51.exe");
        String url = "https://xa.fang.anjuke.com/loupan/xixianxinqu/"; 
        AnjukeCrawler crawler = new AnjukeCrawler(url);
        crawler.run();
    }
}
