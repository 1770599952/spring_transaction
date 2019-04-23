package com.example.spring_transaction;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SpringBootApplication
@RestController
public class SpringTransactionApplication implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionApplication.class, args);
    }

    @Autowired
    private ApplicationContext context;

    @GetMapping("/classloadtest1")
    public void hello(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("HttpServletResponse 的类加载器为：" + response.getClass().getClassLoader());
        writer.write("SpringApplication 的类加载器为：" + SpringApplication.class.getClassLoader());
    }

    @GetMapping("/currcondition")
    public void getCurrcondition(HttpServletResponse response) throws IOException {
        ListService service = context.getBean(ListService.class);
        service.showOsInfo();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @GetMapping("/application")
    public void getApplicationContext() {
        System.out.println(context);
    }
}
