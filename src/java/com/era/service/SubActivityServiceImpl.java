/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.dao.SubActivityDao;
import com.era.model.SubActivity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class SubActivityServiceImpl implements SubActivityService {
    
    @Autowired
    SubActivityDao SubActivityDao;
    
    @Override
    public boolean addSubActivity(SubActivity subActivity) throws Exception {
        return SubActivityDao.addSubActivity(subActivity);
    }
    
    @Override
    public boolean isSubActivityExists(SubActivity subActivity) throws Exception {
        return SubActivityDao.isSubActivityExists(subActivity);
    }
    
    @Override
    public SubActivity getSubActivityBySubActivityName(String subActivityName) throws Exception {
        return SubActivityDao.getSubActivityBySubActivityName(subActivityName);
    }
    
    @Override
    public List<SubActivity> getAllSubActivities() throws Exception {
        return SubActivityDao.getAllSubActivities();
    }
    
    @Override
    public void deleteSubActivity(String subActivityName) throws Exception {
        SubActivityDao.deleteSubActivity(subActivityName);
    }
    
    @Override
    public void updateSubActivity(SubActivity subActivity) throws Exception {
        SubActivityDao.updateSubActivity(subActivity);
    }
    
}
