package com.example.trafficcarddataprocess.calculator;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	@Value("${server.port}")
	private int port;
	@Value("${server.sessionTimeout}")
	private int sessionTimeout;
	@Value("${worker.count}")
	private int workerCount;
	
	public static void main(String[] args) {
		App.cac = SpringApplication.run(App.class, args);
		App app = cac.getBean(App.class);
		app.logStatus();
		app.startWorkers();
	}
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	    factory.setPort(port);
	    factory.setSessionTimeout(sessionTimeout, TimeUnit.SECONDS);
	    return factory;
	}
	
	public void logStatus() {
		logger.info("worker count: " + workerCount);
	}
	
	public void startWorkers() {
		Worker worker = cac.getBean(Worker.class);
		Thread thread = new Thread(worker);
		thread.start();
	}
	
}

@Configuration
@ImportResource("/spring/applicationContext.xml")
class XmlImportingConfiguration {
}
