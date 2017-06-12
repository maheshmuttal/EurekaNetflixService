package com.client.application;

import com.client.controller.EmployeeConsumerController;
import com.client.controller.UserConsumerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) throws RestClientException, IOException {

        ApplicationContext context =
                SpringApplication.run(ClientApplication.class, args);

        EmployeeConsumerController employeeClient = context.getBean(EmployeeConsumerController.class);
        System.out.println(employeeClient);
        employeeClient.getEmployeeWithoutEurekaInstance();

        for(int i = 0; i< 5; i++) {
            employeeClient.getEmployeeWithEurekaInstance();
        }

        UserConsumerController.main();
    }

    @Bean
    public EmployeeConsumerController consumerControllerClient() {
        return  new EmployeeConsumerController();
    }
}
