package com.chenjie.core;

import com.chenjie.core.project.self.WebLoader;
import com.chenjie.core.project.self.WebParser;
import com.chenjie.core.project.self.WebResult;

public class Application {
    public static void main(String[] args) {
        init();
        String url = "http://192.168.1.3:8000/";
        WebLoader loader = new WebLoader(url);
        String html = loader.load();
        WebParser webParse = new WebParser(url);
        WebResult webResult = webParse.parse(html);
    }

    public static void init(){
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
    }
}
