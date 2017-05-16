package com.era.dao;

import com.era.model.Company;
import java.util.List;

import com.era.model.User;

public interface UserDao {

    public boolean addUser(User user) throws Exception;

    public boolean isUserExists(User user) throws Exception;

    public User getUserByEmail(String emailAddress) throws Exception;

    public User getUserByUsername(String username) throws Exception;

    public List<User> getUsersByCompany(Company company) throws Exception;

    public List<User> getUsersByRole(Integer role) throws Exception;

    public List<User> getAllUsers() throws Exception;

    public void deleteUser(String username) throws Exception;

    public void updateUser(User user) throws Exception;

    public boolean authenticateUser(String username, String password) throws Exception;
}
