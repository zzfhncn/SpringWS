
package com.demo.service.impl;

import com.demo.bean.Employee;
import com.demo.dao.IUserDao;
import com.demo.service.IUserInfoService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {
    private static final Logger logger = Logger.getLogger(UserInfoServiceImpl.class);
    
    @Autowired
    private IUserDao userDao;
    
    @Override
    public Employee getUserById(String id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<Employee> getAllUser() {
        return userDao.getAllUser();
    }
    
}
