/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.model.SubActivity;
import java.util.List;

/**
 *
 * @author LQwabe
 */
public interface SubActivityService {

    public boolean addSubActivity(SubActivity subActivity) throws Exception;

    public boolean isSubActivityExists(SubActivity subActivity) throws Exception;

    public SubActivity getSubActivityBySubActivityName(String subActivityName) throws Exception;

    public List<SubActivity> getAllSubActivities() throws Exception;

    public void deleteSubActivity(String subActivityName) throws Exception;

    public void updateSubActivity(SubActivity subActivity) throws Exception;

}
