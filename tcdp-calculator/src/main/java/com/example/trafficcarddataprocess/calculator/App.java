package com.example.trafficcarddataprocess.calculator;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ComponentScan
@EnableAutoConfiguration
public class App {
	
	private static ConfigurableApplicationContext cac;
	
	@Value("${server.port}")
	private int port;
	@Value("${server.sessionTimeout}")
	private int sessionTimeout;
	
	public static void main(String[] args) {
		App.cac = SpringApplication.run(App.class, args);
		WorkerMaster master = cac.getBean(WorkerMaster.class);
		master.start();
	}
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	    factory.setPort(port);
	    factory.setSessionTimeout(sessionTimeout, TimeUnit.SECONDS);
	    return factory;
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return cac.getBean(clazz);
	}
	
	public static <T> T getBean(String name, Class<T> clazz) {
		return cac.getBean(name, clazz);
	}
	
}

@Configuration
@ImportResource("/spring/applicationContext.xml")
class XmlImportingConfiguration {
}
