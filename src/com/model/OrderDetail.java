package com.model;

/**
 * 定单详情
 */
public class OrderDetail {
    private Integer id;//定单详情ID
    private Integer itemsId;//商品ID
    private Integer itemsNum;//商品购买数量

    private Items items;//商品模型

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public Integer getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(Integer itemsNum) {
        this.itemsNum = itemsNum;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", itemsId=" + itemsId +
                ", itemsNum=" + itemsNum +
                '}';
    }
}
