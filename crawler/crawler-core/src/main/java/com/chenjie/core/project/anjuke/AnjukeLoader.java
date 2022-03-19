package com.chenjie.core.project.anjuke;

import com.chenjie.core.loader.Loader;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AnjukeLoader implements Loader<List<String>> {
    private String url;

    private WebDriver driver = null;

    public AnjukeLoader(String url){
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
    public List<String> load() {
        List<String> htmls = new ArrayList<>();
        try {
            driver.get(url);
            htmls.add(driver.getPageSource());
            WebElement nextBtn = driver.findElement(By.className("next-page"));
            if (nextBtn != null){
                Actions actionProvider = new Actions(driver);
                String className = nextBtn.getAttribute("class");
                while (className.indexOf("stat-disable") < 0){
                    actionProvider.click(nextBtn).build().perform();
                    htmls.add(driver.getPageSource());
                    nextBtn = driver.findElement(By.className("next-page"));
                    className = nextBtn.getAttribute("class");
                    Thread.sleep(3000);
                }
            }
        }catch (Exception e){
            log.error("{}", e);
        }finally {
            driver.quit();
        }
        return htmls;
    }
}