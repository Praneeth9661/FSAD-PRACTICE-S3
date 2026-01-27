package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.config.AppConfig;
import com.klu.model.Library;

public class MainApp {

    public static void main(String[] args) {

       
        ApplicationContext cn =
                new AnnotationConfigApplicationContext(AppConfig.class);

        
        Library library = cn.getBean(Library.class);

        
        library.displayDetails();
        
        
    }
}