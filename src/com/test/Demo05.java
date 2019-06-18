package com.test;

import com.mapper.UserMapper;
import com.model.Order;
import com.model.User;
import com.vo.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo05 {
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


        //通过模型的包装类来查询用户
        UserQueryVO query = new UserQueryVO();

        User user = new User();
        user.setId(1);
        query.setUser(user);

        Order order = new Order();
        order.setNumber("100111");
        query.setOrder(order);

        List<User> list = userMapper.findUserByUserQueryVo(query);
        System.out.println(list);
    }


    @Test
    public void test2() throws IOException {

        UserMapper userMapper =  session.getMapper(UserMapper.class);


        //查询条件
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("username","张");
        map.put("sex","2");

        List<User> list = userMapper.findUserByMap(map);
        System.out.println(list);
    }


}
