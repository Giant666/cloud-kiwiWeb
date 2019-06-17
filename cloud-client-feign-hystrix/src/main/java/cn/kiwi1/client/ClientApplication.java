package cn.kiwi1.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = { "cn.kiwi1.client.remote" })
@ComponentScan(basePackages = { "cn.kiwi1.client.component" })
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

}
