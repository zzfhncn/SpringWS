
package com.demo.service;

import com.demo.bean.Employee;
import java.util.List;

public interface IUserInfoService {
    public Employee getUserById(String id);
    
    public List<Employee> getAllUser();
}
