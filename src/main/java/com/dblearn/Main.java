package com.dblearn;
import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");
        SqlSessionFactoryBuilder SqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=SqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession session=factory.openSession();
        int count=session.insert("insertCar");
        System.out.println(count);
        session.commit();
    }
}