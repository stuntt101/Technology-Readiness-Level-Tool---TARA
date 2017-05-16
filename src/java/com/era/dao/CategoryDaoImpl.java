/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.dao;

import com.era.model.Category;
import com.era.model.ProcessActivity;
import com.era.model.SubActivity;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    /**
     * add new category in the database. If the category is already exists ,
     * returns false.
     *
     * @param category the category object
     * @return true otherwise false if category is already exists
     * @throws java.lang.Exception
     */
    @Override
    public boolean addCategory(Category category) throws Exception {
        if (isCategoryExists(category)) {
            return false;
        }

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(category);
        tx.commit();
        session.close();

        return true;

    }

    /**
     * check if the category exists in the database. If it does not exists ,
     * returns false.
     *
     * @param category the category object
     * @return true if the category exists otherwise false for non existent
     * @throws java.lang.Exception
     */
    @Override
    public boolean isCategoryExists(Category category) throws Exception {
        session = sessionFactory.openSession();
        boolean result = false;
        Category a_category = (Category) session.createQuery("from Category where categoryId='" + category.getCategoryId() + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();

        if (a_category != null) {
            result = true;
        }
        return result;

    }

    /**
     * Return category object for given category ID from database. If category
     * is not found, returns null.
     *
     * @param categoryId the category ID
     * @return category object for given ID
     * @throws java.lang.Exception
     */
    @Override
    public Category getCategoryById(Integer categoryId) throws Exception {
        session = sessionFactory.openSession();
        Category category = (Category) session.createQuery("from Category where categoryId='" + categoryId + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return category;

    }

    /**
     * Return category object for given process activity name and sub activity
     * name from database. If category is not found, returns null.
     *
     * @param processActivity the process activity
     * @param subActivity the sub activity
     * @return category object for given process activity name and sub activity
     * name
     * @throws java.lang.Exception
     */
    @Override
    public Category getCategoryBySubActivityAndProcessActivity(ProcessActivity processActivity, SubActivity subActivity) throws Exception {
        session = sessionFactory.openSession();
        Category category = (Category) session.createQuery("from Category c where c.processActivityName='" + processActivity.getProcessActivityName() + "'and  c.subActivityName='" + subActivity.getSubActivityName() + "'").uniqueResult();;
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return category;

    }

    /**
     * Return list of categories for given process activity name from database.
     *
     * @param processActivity the process activity
     * @return list of categories for given process activity name
     * @throws java.lang.Exception
     */
    @Override
    public List<Category> getCategoryByProcessActivity(ProcessActivity processActivity) throws Exception {

        List<Category> categoryList = new ArrayList<Category>();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        categoryList = session.createQuery("from Category where processActivityName='" + processActivity.getProcessActivityName() + "'").list();
        tx.commit();
        session.close();
        return categoryList;
    }

    /**
     * Return list of categories for given sub activity name from database. 
     *
     * @param subActivity the sub activity
     * @return list of categories for given sub activity name
     * @throws java.lang.Exception
     */
    @Override
    public List<Category> getCategoryBySubActivity(SubActivity subActivity) throws Exception {
        List<Category> categoryList = new ArrayList<Category>();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        categoryList = session.createQuery("from Category where subActivityName='" + subActivity.getSubActivityName() + "'").list();
        tx.commit();
        session.close();
        return categoryList;
    }

    /**
     * Returns list of all categories from database.
     *
     * @return list of categories
     * @throws java.lang.Exception
     */
    @Override
    public List<Category> getAllCategories() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Category> categoryList = session.createCriteria(Category.class)
                .list();
        tx.commit();
        session.close();
        return categoryList;
    }

    /**
     * Delete the category from database. 
     *
     * @param categoryId the ID for the category to be deleted
     * @throws java.lang.Exception
     */
    @Override
    public void deleteCategory(Integer categoryId) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Category.class, new Integer(categoryId));
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
    }

    /**
     * Update the category object in the database.
     *
     * @param category the category to be updated
     * @throws java.lang.Exception
     */
    @Override
    public void updateCategory(Category category) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(category);
        tx.commit();
        session.close();
    }

}
