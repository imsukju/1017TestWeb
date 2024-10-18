package com.test1017;

import java.io.File;

import org.apache.catalina.Context;

import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test1017.config.Appconfig;
import com.test1017.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public class Main {

	static EntityManager em;

	public static void main(String[] args) throws Exception {


 
        
        // 임베디드 톰캣 생성 및 설정

		
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // 웹 애플리케이션 컨텍스트 경로 설정
        String contextPath = "";
        String docBase = new File("src/main/webapp").getAbsolutePath();
        Context ctx = tomcat.addWebapp(contextPath, docBase);

        if (ctx == null) {
            System.out.println("Context creation failed.");
            return;
        }

        // 톰캣 서버 시작
        tomcat.getConnector();  // 커넥터 초기화
        tomcat.start();
        tomcat.getServer().await();  // 서버 대기
    }
	


}