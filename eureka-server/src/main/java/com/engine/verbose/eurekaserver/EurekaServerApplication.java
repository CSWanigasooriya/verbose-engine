package com.engine.verbose.eurekaserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    @Value("${server.port}")
    private String serverPort;

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void launchEurekaDashboard() {
        try {
            Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", String.format("http://localhost:%s", serverPort)});
        } catch (Exception _) {
        }
    }
}
