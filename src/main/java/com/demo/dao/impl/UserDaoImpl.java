
package com.demo.dao.impl;

import com.demo.bean.Employee;
import com.demo.dao.IUserDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "userInfoDao")
public class UserDaoImpl implements IUserDao {
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
    
    @Autowired
    private DataSource demoDataSource;
    
    @Override
    public Employee getUserById(String id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select host,user,password from user where user = '" + id + "' limit 1";
        Employee user = new Employee();
        try {
            conn = demoDataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                user.setHost(rs.getString("host"));
                user.setUser(rs.getString("user"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return user;
    }

    @Override
    public List<Employee> getAllUser() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select host,user,password from user limit 5";
        List<Employee> list = new ArrayList();
        try {
            conn = demoDataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Employee tmpEply = new Employee();
                tmpEply.setHost(rs.getString("host"));
                tmpEply.setUser(rs.getString("user"));
                tmpEply.setPassword(rs.getString("password"));
                list.add(tmpEply);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return list;
    }
    
}
