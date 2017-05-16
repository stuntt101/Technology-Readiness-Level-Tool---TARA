/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.dao;

import com.era.model.Company;
import com.era.model.SubActivity;
import com.era.model.User;
import java.util.List;

/**
 *
 * @author LQwabe
 */
public interface SubActivityDao {

    public boolean addSubActivity(SubActivity subActivity) throws Exception;

    public boolean isSubActivityExists(SubActivity subActivity) throws Exception;

    public SubActivity getSubActivityBySubActivityName(String subActivityName) throws Exception;

    public List<SubActivity> getAllSubActivities() throws Exception;

    public void deleteSubActivity(String subActivityName) throws Exception;

    public void updateSubActivity(SubActivity subActivity) throws Exception;

}
