package com.example.hp.daoImpl;

import com.example.hp.dao.ManagerDao;
import com.example.hp.domian.Manager;
import com.example.hp.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IManagerServiceImpl implements IManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public Manager findOne(Manager manager) {
        Manager manager1 = managerDao.findOne(manager.getName(),manager.getPassword());
        return manager1;
    }
}
