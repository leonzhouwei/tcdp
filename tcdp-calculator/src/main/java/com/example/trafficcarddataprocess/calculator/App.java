package com.example.trafficcarddataprocess.calculator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.google.common.collect.Lists;

@ComponentScan
@EnableAutoConfiguration
public class App {
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	private static ConfigurableApplicationContext cac;
	
	@Value("${server.port}")
	private int port;
	@Value("${server.sessionTimeout}")
	private int sessionTimeout;
	@Value("${worker.count}")
	private int workerCount;
	
	@Autowired
	private DataSource dataSource;
	
	public static void main(String[] args) {
		App.cac = SpringApplication.run(App.class, args);
		App app = cac.getBean(App.class);
		app.check();
		app.logStatus();
		app.startWorkerMaster();
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
	
	void check() {
		logger.info("worker count: " + workerCount);
		if (workerCount < 1) {
			String msg = "worker count must be greater than 0! please check the configurations! exiting now...";
			logger.error(msg);
			System.exit(-1);
		}
	}
	
	void logStatus() {
		logger.info("max active: " + dataSource.getMaxActive());
	}
	
	void startWorkerMaster() {
		logger.info("worker count: " + workerCount);
		List<Worker> workers = Lists.newArrayList();
		for (int i = 0; i < workerCount; ++i) {
			Worker worker = cac.getBean(Worker.class);
			workers.add(worker);
		}
		WorkerMaster master = cac.getBean(WorkerMaster.class);
		master.setWorkers(workers);
		Thread thread = new Thread(master);
		thread.start();
	}
	
}

@Configuration
@ImportResource("/spring/applicationContext.xml")
class XmlImportingConfiguration {
}
