/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.dao.UserDao;
import com.era.model.Company;
import com.era.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDao userDao;
    
    @Override
    public boolean addUser(User user) throws Exception {
        return userDao.addUser(user);
        
    }
    
    @Override
    public boolean isUserExists(User user) throws Exception {
        return userDao.isUserExists(user);
    }
    
    @Override
    public User getUserByEmail(String emailAddress) throws Exception {
        return userDao.getUserByEmail(emailAddress);
    }
    
    @Override
    public User getUserByUsername(String username) throws Exception {
        return userDao.getUserByUsername(username);
    }
    
    @Override
    public List<User> getAllUsers() throws Exception {
        return userDao.getAllUsers();
    }
    
    @Override
    public void deleteUser(String username) throws Exception {
        userDao.deleteUser(username);
    }
    
    @Override
    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
    }

    @Override
    public List<User> getUsersByCompany(Company company) throws Exception {
        return userDao.getUsersByCompany(company);
    }

    @Override
    public boolean authenticateUser(String username, String password) throws Exception {
       return userDao.authenticateUser(username, password);
    }

    @Override
    public List<User> getUsersByRole(Integer role) throws Exception {
        return userDao.getUsersByRole(role);
    }
    
}
