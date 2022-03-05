/**
 * jsonp 功能测试
 * 		 Document 实例方法 
 * 						select 
 * 								基础选择器支持标签选择器、类选择器、id选择器
 * 								高级选择器支持交集选择器、并集选择器、后级选择器
 */

package com.huawei.jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args) throws IOException {
		String path = "D:\\learn\\code\\github\\crawler\\crawler\\src\\main\\resources\\taskFile\\two.html";
		File file = new File(path);
		Document document = Jsoup.parse(file, "UTF-8");
		Elements elements = document.select(".yellow+.yellow");
		System.out.println(document);
	}
}
