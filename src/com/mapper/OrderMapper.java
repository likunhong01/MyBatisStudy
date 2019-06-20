package com.mapper;

import com.model.Orders;
import com.model.OrdersExt;
import com.model.User;
import com.vo.UserQueryVO;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    public OrdersExt findOrderById(int id);

    public Orders findOrderById2(int id);


    public Orders findOrderById3(int id);

    /**
     * 懒加载定单的用户数据
     * @return
     */
    public List<Orders> findOrderAndUserByLazyloading();
}
