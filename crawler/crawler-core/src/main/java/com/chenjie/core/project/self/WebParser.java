/**
 *  遗留问题
 *  1、如何第一次请求时就携带cookie
 *  2、怎么让selenium等待ajax执行完毕
 *    答案：使用selenium提供的隐式等待策略
 */

package com.chenjie.core.project.self;

import com.chenjie.core.parser.Parser;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Data
public class WebParser implements Parser<String, WebResult> {
    private String url;

    public WebParser(String url){
        this.url = url;
    }

    @Override
    public WebResult parse(String html) {
        Document document = Jsoup.parse(html);
        System.out.println(document.html());
        return null;
    }
}
