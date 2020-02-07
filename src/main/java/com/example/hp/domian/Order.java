package com.example.hp.domian;

import lombok.Data;

@Data
public class Order {

    private int id;

    private int userId;

    private int houseId;

    private String createTime;

}
