package com.mapper;

import com.model.User;
import com.vo.UserQueryVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     *
     * @param user
     * @return 受影响的行数
     */
    //@Insert("INSERT INTO user (username,sex,birthday,address) VALUE (#{username},#{sex},#{birthday},#{address})")
    public int save(User user);

    //@Select("SELECT * FROM user WHERE id = #{id}")
    public User findUserById(int id);

    public List<User> findUserByUserQueryVo(UserQueryVO vo);


    public List<User> findUserByMap(Map<String,Object> map);

    /**
     * 返回用户的个数
     * @param vo
     * @return
     */
    public int findUserCount(UserQueryVO vo);


    public User findUserByIdResultMap(int userId);

    /**
     * 讲解mybatis的if和where使用
     * @return
     */
    public List<User> findUserList(UserQueryVO vo);

    /*查找多个id的用户数据*/
    public List<User> findUserByIds(UserQueryVO vo);

    public List<User> findUserByIds2(List<Integer> ids);


    /**
     * 查询用户信息及用户购买的商品信息
     */
    public List<User> findUserAndOrderInfo();
    public User findUserAndOrderInfo(int userId);
}
