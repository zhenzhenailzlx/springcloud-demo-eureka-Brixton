package com.zhenzhen.demo.eureka;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {
		
		Map map = new LinkedHashMap();
		
		System.out.println("-----sun.boot.class.path"+System.getProperty("sun.boot.class.path"));
		
		System.out.println("-----java.ext.dirs"+System.getProperty("java.ext.dirs"));
		
		System.out.println("-----java.class.path"+System.getProperty("java.class.path"));	
		
		 new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
	}

}
