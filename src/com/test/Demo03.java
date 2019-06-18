package com.test;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Demo03 {
    SqlSessionFactory sessionFactory;
    @Before
    public void before() throws IOException {
        System.out.println("before.....获取session");
//        a)读取配置文件；
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        sessionFactory = new SqlSessionFactoryBuilder().build(is);

    }




    @Test
    public void test1() throws IOException {

        //调用dao
        //1.创建dao
        UserDao userDao = new UserDaoImpl(sessionFactory);

        User user1 =  userDao.findUserById(1);

        System.out.println(user1);
        User user2 = new User("xxx","x",new Date(),"xx");
        userDao.save(user2);
    }


}
