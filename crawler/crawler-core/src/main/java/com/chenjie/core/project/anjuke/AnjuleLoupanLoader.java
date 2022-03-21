package com.chenjie.core.project.anjuke;

import org.openqa.selenium.WebDriver;

import com.chenjie.core.loader.Loader;
 
public class AnjuleLoupanLoader implements Loader<String> {
    private String url;

    private WebDriver driver = null;

    public AnjuleLoupanLoader(String url, WebDriver driver){
        this.url = url; 
        this.driver = driver;
    } 

    @Override
    public String load() {
    	 driver.get(url);
    	 return driver.getPageSource(); 
    }
}
