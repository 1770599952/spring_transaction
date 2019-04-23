package com.example.spring_transaction;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ConcurrentReferenceHashMap;

import java.util.Map;

import static org.junit.Assert.*;

public class TestControllerTest {


    @Test
    public void queryInfo() {
        Map map = new ConcurrentReferenceHashMap();
        LinuxListService obj = new LinuxListService();
        map.put("test", obj);
        obj = null;
        System.gc();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ListService service =  (LinuxListService)map.get("test");
        service.showOsInfo();
    }
}