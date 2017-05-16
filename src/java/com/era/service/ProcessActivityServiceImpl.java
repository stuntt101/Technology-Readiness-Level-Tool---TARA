/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.dao.ProcessActivityDao;
import com.era.model.ProcessActivity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class ProcessActivityServiceImpl implements ProcessActivityService {

    @Autowired
    ProcessActivityDao processActivityDao;

    @Override
    public boolean addProcessActivity(ProcessActivity processActivity) throws Exception {
        return processActivityDao.addProcessActivity(processActivity);
    }

    @Override
    public boolean isProcessActivityExists(ProcessActivity processActivity) throws Exception {
        return processActivityDao.isProcessActivityExists(processActivity);
    }

    @Override
    public ProcessActivity getProcessActivityByName(String processActivityName) throws Exception {
        return processActivityDao.getProcessActivityByName(processActivityName);
    }

    @Override
    public List<ProcessActivity> getAllProcessActivities() throws Exception {
        return processActivityDao.getAllProcessActivities();
    }

    @Override
    public void deleteProcessActivity(String processActivityName) throws Exception {
        processActivityDao.deleteProcessActivity(processActivityName);
    }

    @Override
    public void updateProcessActivity(ProcessActivity processActivity) throws Exception {
        processActivityDao.updateProcessActivity(processActivity);
    }

}
