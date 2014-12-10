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
	
	@Value("${server.port}")
	private int port;
	@Value("${server.sessionTimeout}")
	private int sessionTimeout;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(App.class, args);
		Worker worker = cac.getBean(Worker.class);
		startWorkers(worker);
	}
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	    factory.setPort(port);
	    factory.setSessionTimeout(sessionTimeout, TimeUnit.SECONDS);
	    return factory;
	}
	
	static void startWorkers(Worker worker) {
		Thread thread = new Thread(worker);
		thread.start();
	}

}

@Configuration
@ImportResource("/spring/applicationContext.xml")
class XmlImportingConfiguration {
}
