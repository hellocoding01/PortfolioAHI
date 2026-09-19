package com.portfolio.utill;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtill {
	public static Connection mySqlConnact() {

       Properties properties = new Properties();

       System.out.println("================================");
       System.out.println("현재 클래스 위치 : "
               + DbUtill.class.getProtectionDomain()
               .getCodeSource()
               .getLocation());

       System.out.println("db.properties : "
               + DbUtill.class.getClassLoader()
               .getResource("db.properties"));

       System.out.println("================================");

        try (InputStream input = DbUtill.class
        		.getClassLoader()
        		.getResourceAsStream("db.properties")){

        		 if (input == null) {
        		        throw new Exception("db.properties 파일을 찾을 수 없습니다.");
        		    }

        		 properties.load(input);

        }catch(Exception e) {
        	e.printStackTrace();
        }

        	String url = properties.getProperty("db.url");
        	String user = properties.getProperty("db.user");
        	String password = properties.getProperty("db.password");

//        	System.out.println("url :" + url + ", user :" + user + ", password :"+password);

        	Connection con = null;

        	try {

        	Class.forName("com.mysql.cj.jdbc.Driver");
        	System.out.println(">>> MySQL Driver 로딩 성공");

        	con = DriverManager.getConnection(url, user, password);
            System.out.println("MySql 연결성공!");
        	}catch(Exception e) {
        		e.printStackTrace();
        	}

		return con;
	}
}
