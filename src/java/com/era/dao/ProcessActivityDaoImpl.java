/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.dao;

import com.era.model.ProcessActivity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class ProcessActivityDaoImpl implements ProcessActivityDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    /**
     * add new process activity in the database. If the process activity is
     * already exists , returns false.
     *
     * @param processActivity the process activity object
     * @return true otherwise false if process activity is already exists
     * @throws java.lang.Exception
     */
    @Override
    public boolean addProcessActivity(ProcessActivity processActivity) throws Exception {
        if (isProcessActivityExists(processActivity)) {
            return false;
        }

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(processActivity);
        tx.commit();
        session.close();

        return true;
    }

    /**
     * check if the process activity exists in the database. If it does not
     * exists , returns false.
     *
     * @param processActivity the process activity object
     * @return true if the process activity exists otherwise false for non
     * existent
     * @throws java.lang.Exception
     */
    @Override
    public boolean isProcessActivityExists(ProcessActivity processActivity) throws Exception {
        session = sessionFactory.openSession();
        boolean result = false;
        ProcessActivity a_processActivity = (ProcessActivity) session.createQuery("from ProcessActivity where processActivityName='" + processActivity.getProcessActivityName() + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();

        if (a_processActivity != null) {
            result = true;
        }
        return result;
    }

    /**
     * Return process activity object for the given process activity name from
     * database. If process activity is not found, returns null.
     *
     * @param processActivityName the process activity name
     * @return process activity object for given  name
     * @throws java.lang.Exception
     */
    @Override
    public ProcessActivity getProcessActivityByName(String processActivityName) throws Exception {
        session = sessionFactory.openSession();
        ProcessActivity processActivity = (ProcessActivity) session.createQuery("from ProcessActivity where processActivityName='" + processActivityName + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return processActivity;
    }

    /**
     * Returns list of all process activity from database.
     *
     * @return list of process activities
     * @throws java.lang.Exception
     */
    @Override
    public List<ProcessActivity> getAllProcessActivities() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<ProcessActivity> processActivityList = session.createCriteria(ProcessActivity.class)
                .list();
        tx.commit();
        session.close();
        return processActivityList;
    }

    /**
     * Delete the process activity from database.
     *
     * @param processActivityName the name for the process activity to be deleted
     * @throws java.lang.Exception
     */
    @Override
    public void deleteProcessActivity(String processActivityName) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(ProcessActivity.class, new String(processActivityName));
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
    }

    /**
     * Update the process activity object in the database.
     *
     * @param processActivity the process activity to be updated
     * @throws java.lang.Exception
     */
    @Override
    public void updateProcessActivity(ProcessActivity processActivity) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(processActivity);
        tx.commit();
        session.close();
    }

}
