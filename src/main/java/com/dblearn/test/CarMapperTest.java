package com.dblearn.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class CarMapperTest {
    @Test
    public void CarMapperTest(){
        SqlSession session = null;
        try {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            session = factory.openSession();

            int count = session.insert("insertCar");

            System.out.println(count);

            session.commit();
        } catch (IOException e) {
            if(session!=null){
                session.rollback();
            }
            e.printStackTrace();
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }
}
