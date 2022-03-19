package com.chenjie.core.project.anjuke;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        init();
        String url = "https://xa.fang.anjuke.com/loupan/xixianxinqu/";
        AnjukeLoader loader = new AnjukeLoader(url);
        List<String> htmls = loader.load();
        AnjuleParser anjuleParser = new AnjuleParser();
        List<Loupan> loupans = new ArrayList<>();
        for (String html : htmls) {
            loupans.addAll(anjuleParser.parse(html));
        }
        System.out.println(loupans.size());
    }

    public static void init(){
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
    }
}
