package com.chenjie.core.project.self;

import com.chenjie.core.loader.Loader;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebLoader implements Loader<String> {
    private String url;

    private WebDriver driver = null;

    public WebLoader(String url){
        this.url = url;
        init();
    }

    public void init(){
        ChromeOptions options = new ChromeOptions();
        //  配置页面加载的等待策略, 等待所有静态资源加载完毕
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
    }

    @Override
    public String load() {
        driver.get(url);
        setCookie();
        driver.get(url);
        ExpectedCondition e = ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.id("greet")), "hello"
        );
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(e);
        String pageSource = driver.getPageSource();
        driver.quit();
        return pageSource;
    }

    public void setCookie(){
        driver.manage().addCookie(new Cookie("domainName", "陈杰"));
    }
}
