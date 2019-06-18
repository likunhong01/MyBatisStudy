package com.test;

import com.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Demo04 {
    SqlSession session;
    @Before
    public void before() throws IOException {
        System.out.println("before.....获取session");
//        a)读取配置文件；
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        session = sessionFactory.openSession();
    }

    @After
    public void after(){
        session.close();
    }

    @Test
    public void test1() throws IOException {

        UserMapper userMapper =  session.getMapper(UserMapper.class);
        //System.out.println(obj.getClass());

        //获取数据
        System.out.println(userMapper.findUserById(1));


        //保存
        /*User user2 = new User("xxx","x",new Date(),"xx");
        userMapper.save(user2);
        session.commit();*/

    }


}
