package com.example.spring_transaction;


import org.springframework.beans.factory.BeanNameAware;

public class WindowsListService implements ListService, BeanNameAware {

    private String name;

    @Override
    public void showOsInfo() {
        System.out.println("windows os" + name);
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
}
