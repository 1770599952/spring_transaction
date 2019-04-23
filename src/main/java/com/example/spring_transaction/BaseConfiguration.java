package com.example.spring_transaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService createLinuxService() {
        return new LinuxListService();
    }

    @Bean("windowsListService")
    @Conditional(WindowsCondition.class)
    public ListService createWindowsService(){
        return new WindowsListService();
    }
}
