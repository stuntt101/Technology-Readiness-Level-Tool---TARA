/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.model.ProcessActivity;
import java.util.List;

/**
 *
 * @author LQwabe
 */
public interface ProcessActivityService {

    public boolean addProcessActivity(ProcessActivity processActivity) throws Exception;

    public boolean isProcessActivityExists(ProcessActivity processActivity) throws Exception;

    public ProcessActivity getProcessActivityByName(String processActivityName) throws Exception;

    public List<ProcessActivity> getAllProcessActivities() throws Exception;

    public void deleteProcessActivity(String processActivityName) throws Exception;

    public void updateProcessActivity(ProcessActivity processActivity) throws Exception;

}
