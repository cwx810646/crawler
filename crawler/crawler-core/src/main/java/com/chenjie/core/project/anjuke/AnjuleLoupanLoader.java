package com.chenjie.core.project.anjuke;

import com.chenjie.core.loader.Loader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Slf4j
public class AnjuleLoupanLoader implements Loader<String> {
    private String url;

    private WebDriver driver = null;

    public AnjuleLoupanLoader(String url){
        this.url = url;
        init();
    }

    public void init(){
        ChromeOptions options = new ChromeOptions();
        //  配置页面加载的等待策略, 等待所有静态资源加载完毕
        // options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
    }

    @Override
    public String load() {
        String html = null;
        try {
            driver.get(url);
            html = driver.getPageSource();
        }catch (Exception e){
            log.error("{}", e);
        }finally {
            driver.quit();
        }
        return html;
    }
}
