package com.chenjie.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class PropertyEntity {
    @Value("${local.driver.chrome}")
    private String chromeDriverPath;
}
