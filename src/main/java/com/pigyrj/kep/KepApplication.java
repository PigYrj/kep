package com.pigyrj.kep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 脚手架boot
 */
@SpringBootApplication
@MapperScan(basePackages = {
		"com.pigyrj.kep.server.dao"
})
@ComponentScan(basePackages = {
		"com.pigyrj.kep"
})
public class KepApplication {

	public static void main(String[] args) {
		SpringApplication.run(KepApplication.class, args);
	}

}
