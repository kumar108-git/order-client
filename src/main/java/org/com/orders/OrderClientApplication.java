package org.com.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderClientApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
