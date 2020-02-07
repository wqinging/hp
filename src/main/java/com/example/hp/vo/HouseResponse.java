package com.example.hp.vo;

import com.example.hp.domian.Agent;
import com.example.hp.domian.House;
import lombok.Data;

@Data
public class HouseResponse {

    private House house;

    private Agent agent;

}
