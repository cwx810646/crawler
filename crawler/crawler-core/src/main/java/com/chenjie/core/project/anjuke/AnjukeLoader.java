package com.chenjie.core.project.anjuke;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnjukeLoader{
    private String url;

    private WebDriver driver = null;

    public AnjukeLoader(String url, WebDriver driver){
        this.url = url; 
        this.driver = driver;
    }
 
 
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
        } 
        return htmls;
    }
}
