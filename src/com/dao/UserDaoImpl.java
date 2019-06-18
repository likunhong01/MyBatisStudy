package com.dao;

import com.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory ssf;

    public UserDaoImpl() {
    }

    public UserDaoImpl(SqlSessionFactory ssf) {
        this.ssf = ssf;
    }

    @Override
    public void save(User user) {

        //获取session
        SqlSession session = ssf.openSession();

        //插入数据
        session.insert("insertUser",user);

        session.commit();
        session.close();
    }

    @Override
    public User findUserById(int id) {
        //获取session
        SqlSession session = ssf.openSession();

        //插入数据
        User user = session.selectOne("findUserById",id);

        session.close();
        return user;
    }
}
