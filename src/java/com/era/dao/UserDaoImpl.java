/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.dao;

import com.era.model.Company;
import com.era.model.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    /**
     * add new user in the database. If the user is already exists , returns
     * false.
     *
     * @param user User object
     * @return true otherwise false if user is already exists
     * @throws java.lang.Exception
     */
    @Override
    public boolean addUser(User user) throws Exception {

        if (isUserExists(user)) {
            return false;
        }

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();

        return true;

    }

    /**
     * check if the user exists in the database. If does not exists , returns
     * false.
     *
     * @param user User object
     * @return true if the user exists otherwise false for non existent
     * @throws java.lang.Exception
     */
    @Override
    public boolean isUserExists(User user) throws Exception {
        session = sessionFactory.openSession();
        boolean result = false;
        User a_user = (User) session.createQuery("from User where username='" + user.getUsername() + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();

        if (a_user != null) {
            result = true;
        }
        return result;
    }

    /**
     * Return user object for given email address from database. If user is not
     * found returns null.
     *
     * @param emailAddress user's email address
     * @return user object for given email
     * @throws java.lang.Exception
     */
    @Override
    public User getUserByEmail(String emailAddress) throws Exception {
        session = sessionFactory.openSession();
        User user = (User) session.createQuery("from User where email='" + emailAddress + "'").uniqueResult();;
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return user;
    }

    /**
     * Return user object for given username from database. If user is not found
     * for username, returns null.
     *
     * @param username user's username
     * @return user object for given username
     * @throws java.lang.Exception
     */
    @Override
    public User getUserByUsername(String username) throws Exception {
        session = sessionFactory.openSession();

        User user = (User) session.createQuery("from User where username='" + username + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return user;

    }

    /**
     * Returns list of all users from database.
     *
     * @return list of users
     * @throws java.lang.Exception
     */
    @Override
    public List<User> getAllUsers() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<User> userList = session.createCriteria(User.class)
                .list();
        tx.commit();
        session.close();
        return userList;
    }

    /**
     * Delete the user from database.
     *
     * @param username username for the user to be deleted
     * @throws java.lang.Exception
     */
    @Override
    public void deleteUser(String username) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(User.class, new String(username));
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();

    }

    /**
     * Update the user object in the database.
     *
     * @param user
     * @throws java.lang.Exception
     */
    @Override
    public void updateUser(User user) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    /**
     * Return list of all users for given company from database.
     *
     *
     * @param company user's company
     * @return list of users for given company
     * @throws java.lang.Exception
     */
    @Override
    public List<User> getUsersByCompany(Company company) throws Exception {
        List<User> userList = new ArrayList<User>();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        userList = session.createQuery("from User where company='" + company.getCompanyId() + "'").list();
        tx.commit();
        session.close();
        return userList;

    }

    @Override
    public boolean authenticateUser(String username, String password) throws Exception {
        session = sessionFactory.openSession();
        boolean result = false;

        User user = (User) session.createQuery("from User where username='" + username + "'and password = '" + password + "'").uniqueResult();;
        //User a_user = (User) session.createQuery("from User where username='" + user.getUsername() + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();

        if (user != null) {
            result = true;
        }
        return result;
    }

    @Override
    public List<User> getUsersByRole(Integer role) throws Exception {
        List<User> userList = new ArrayList<User>();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        userList = session.createQuery("from User where role='" + role + "'").list();
        tx.commit();
        session.close();
        return userList;
    }

}
