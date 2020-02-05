package com.example.hp.serviceImpl;

import com.example.hp.dao.AgentDao;
import com.example.hp.domian.Agent;
import com.example.hp.service.IAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements IAgentService {

    @Autowired
    private AgentDao agentDao;

    @Override
    public Agent findById(int id) {
        Agent agent = agentDao.findById(id);
        return agent;
    }

    @Override
    public List<Agent> findAll() {
        List<Agent> all = agentDao.findAll();
        return all;
    }

    @Override
    public void insert(Agent agent) {
        agentDao.insert(agent);
    }

    @Override
    public void update(Agent agent) {
        agentDao.update(agent);
    }

    @Override
    public void delete(int id) {
        agentDao.delete(id);
    }
}
