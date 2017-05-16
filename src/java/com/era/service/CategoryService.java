/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.model.Category;
import com.era.model.ProcessActivity;
import com.era.model.SubActivity;
import java.util.List;

/**
 *
 * @author LQwabe
 */
public interface CategoryService {

    public boolean addCategory(Category category) throws Exception;

    public boolean isCategoryExists(Category category) throws Exception;

    public Category getCategoryById(Integer categoryId) throws Exception;

    public Category getCategoryBySubActivityAndProcessActivity(ProcessActivity processActivity, SubActivity subActivity) throws Exception;

    public List<Category> getCategoryByProcessActivity(ProcessActivity processActivity) throws Exception;

    public List<Category> getCategoryBySubActivity(SubActivity subActivity) throws Exception;

    public List<Category> getAllCategories() throws Exception;

    public void deleteCategory(Integer categoryId) throws Exception;

    public void updateCategory(Category category) throws Exception;

}
