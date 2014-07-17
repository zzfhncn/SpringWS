
package com.demo.dao;

import com.demo.bean.Employee;
import java.util.List;


public interface IUserDao {
    public Employee getUserById(String id);

    public List<Employee> getAllUser();
}
