package com.chenjie.config;

import com.chenjie.util.PropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SystemConfig {
    @Autowired
    private PropertyEntity propertyEntity;

    @PostConstruct
    public void setPropeties(){
        String driverPath = propertyEntity.getChromeDriverPath();
        System.setProperty("webdriver.chrome.driver", driverPath);
    }
}
