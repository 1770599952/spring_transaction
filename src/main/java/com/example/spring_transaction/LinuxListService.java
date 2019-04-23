package com.example.spring_transaction;

import org.springframework.stereotype.Service;

public class LinuxListService implements ListService{

    @Override
    public void showOsInfo() {
        System.out.println("linux");
    }
}
