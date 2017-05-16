/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.model.Company;
import com.era.model.User;
import java.util.List;

/**
 *
 * @author LQwabe
 */
public interface UserService {

    public boolean addUser(User user) throws Exception;

    public boolean isUserExists(User user) throws Exception;

    public User getUserByEmail(String emailAddress) throws Exception;

    public User getUserByUsername(String username) throws Exception;

    public List<User> getAllUsers() throws Exception;

    public List<User> getUsersByCompany(Company company) throws Exception;
     public List<User> getUsersByRole(Integer role) throws Exception;

    public void deleteUser(String username) throws Exception;

    public void updateUser(User user) throws Exception;

    public boolean authenticateUser(String username, String password) throws Exception;

}
