package com.example.hp.service;

import com.example.hp.domian.Agent;

import java.util.List;

public interface IAgentService {

    Agent findById(int id);

    List<Agent> findAll();

    void insert(Agent agent);

    void update(Agent agent);

    void  delete(int id);
}
