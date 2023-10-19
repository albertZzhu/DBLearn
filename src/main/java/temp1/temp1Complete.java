package temp1;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class temp1Complete {
    public static void main(String[] args) {
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
