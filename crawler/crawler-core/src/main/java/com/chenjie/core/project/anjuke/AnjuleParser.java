package com.chenjie.core.project.anjuke;

import com.chenjie.core.parser.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class AnjuleParser implements Parser<String, List<Loupan>> {
    @Override
    public List<Loupan> parse(String html) {
        Document document = Jsoup.parse(html);
        Elements elements = document.select("#container .list-results .item-mod");
        List<Loupan> loupans = new ArrayList<>();
        elements.forEach(element -> {
            String link = element.attr("data-link");
            loupans.add(parseLoupan(link));
        });
        return loupans;
    }

    public Loupan parseLoupan(String url){
        AnjuleLoupanLoader loader = new AnjuleLoupanLoader(url);
        String html = loader.load();
        AnjuleLoupanParser parser = new AnjuleLoupanParser();
        return parser.parse(html);
    }
}
