/**
 *  遗留问题
 *  1、如何第一次请求时就携带cookie
 *  2、怎么让selenium等待ajax执行完毕
 *    答案：使用selenium提供的隐式等待策略
 */

package com.chenjie.core.projects.self;

import com.chenjie.core.parsers.Parser;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
