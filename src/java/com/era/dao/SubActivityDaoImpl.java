/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.dao;

import com.era.model.SubActivity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class SubActivityDaoImpl implements SubActivityDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    /**
     * add new sub activity in the database. If the sub activity is already
     * exists , returns false.
     *
     * @param subActivity the sub activity object
     * @return true otherwise false if sub activity is already exists
     * @throws java.lang.Exception
     */
    @Override
    public boolean addSubActivity(SubActivity subActivity) throws Exception {
        if (isSubActivityExists(subActivity)) {
            return false;
        }

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(subActivity);
        tx.commit();
        session.close();

        return true;
    }

    /**
     * check if the sub activity exists in the database. If it does not exists ,
     * returns false.
     *
     * @param subActivity the sub activity object
     * @return true if the sub activity exists otherwise false for non existent
     * @throws java.lang.Exception
     */
    @Override
    public boolean isSubActivityExists(SubActivity subActivity) throws Exception {
        session = sessionFactory.openSession();
        boolean result = false;
        SubActivity a_subActivity = (SubActivity) session.createQuery("from SubActivity where subActivityName='" + subActivity.getSubActivityName() + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();

        if (a_subActivity != null) {
            result = true;
        }
        return result;
    }

    /**
     * Return sub activity object for the given sub activity name from database.
     * If sub activity is not found, returns null.
     *
     * @param subActivityName the sub activity name
     * @return sub activity object for given name
     * @throws java.lang.Exception
     */
    @Override
    public SubActivity getSubActivityBySubActivityName(String subActivityName) throws Exception {
        session = sessionFactory.openSession();
        SubActivity subActivity = (SubActivity) session.createQuery("from SubActivity where subActivityName='" + subActivityName + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return subActivity;
    }

    /**
     * Returns list of all sub activities from database.
     *
     * @return list of sub activities
     * @throws java.lang.Exception
     */
    @Override
    public List<SubActivity> getAllSubActivities() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<SubActivity> subActivityList = session.createCriteria(SubActivity.class)
                .list();
        tx.commit();
        session.close();
        return subActivityList;
    }

    /**
     * Delete the sub activity from database.
     *
     * @param subActivityName the name for the sub activity to be deleted
     * @throws java.lang.Exception
     */
    @Override
    public void deleteSubActivity(String subActivityName) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(SubActivity.class, new String(subActivityName));
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
    }

    /**
     * Update the sub activity object in the database.
     *
     * @param subActivity the sub activity to be updated
     * @throws java.lang.Exception
     */
    @Override
    public void updateSubActivity(SubActivity subActivity) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(subActivity);
        tx.commit();
        session.close();
    }

}
