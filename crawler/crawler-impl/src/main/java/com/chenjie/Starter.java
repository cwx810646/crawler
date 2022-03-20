package com.chenjie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.chenjie.impl.dao.mapper")
@ComponentScan("com.chenjie")
@EnableAutoConfiguration
public class Starter {
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}
}
