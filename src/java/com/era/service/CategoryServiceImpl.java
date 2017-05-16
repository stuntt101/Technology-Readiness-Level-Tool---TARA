/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.dao.CategoryDao;
import com.era.model.Category;
import com.era.model.ProcessActivity;
import com.era.model.SubActivity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public boolean addCategory(Category category) throws Exception {
        return categoryDao.addCategory(category);
    }

    @Override
    public boolean isCategoryExists(Category category) throws Exception {
        return categoryDao.isCategoryExists(category);
    }

    @Override
    public Category getCategoryById(Integer categoryId) throws Exception {
        return categoryDao.getCategoryById(categoryId);
    }

    @Override
    public Category getCategoryBySubActivityAndProcessActivity(ProcessActivity processActivity, SubActivity subActivity) throws Exception {
        return categoryDao.getCategoryBySubActivityAndProcessActivity(processActivity, subActivity);
    }

    @Override
    public List<Category> getCategoryByProcessActivity(ProcessActivity processActivity) throws Exception {
        return categoryDao.getCategoryByProcessActivity(processActivity);
    }

    @Override
    public List<Category> getCategoryBySubActivity(SubActivity subActivity) throws Exception {
        return categoryDao.getCategoryBySubActivity(subActivity);
    }

    @Override
    public List<Category> getAllCategories() throws Exception {
        return categoryDao.getAllCategories();
    }

    @Override
    public void deleteCategory(Integer categoryId) throws Exception {
        categoryDao.deleteCategory(categoryId);
    }

    @Override
    public void updateCategory(Category category) throws Exception {
        categoryDao.updateCategory(category);
    }

}
