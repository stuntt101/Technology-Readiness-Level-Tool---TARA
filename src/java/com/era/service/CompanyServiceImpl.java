/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.dao.CompanyDao;
import com.era.model.Company;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class CompanyServiceImpl implements CompanyService {
    
    @Autowired
    CompanyDao companyDao;
    
    @Override
    public boolean addCompany(Company company) throws Exception {
        return companyDao.addCompany(company);
    }
    
    @Override
    public boolean isCompanyExists(Company company) throws Exception {
        return companyDao.isCompanyExists(company);
    }
    
    @Override
    public Company getCompanyByCompanyId(Integer companyId) throws Exception {
        return companyDao.getCompanyByCompanyId(companyId);
    }
    
    @Override
    public Company getCompanyByCompanyName(String companyName) throws Exception {
        return companyDao.getCompanyByCompanyName(companyName);
    }
    
    @Override
    public List<Company> getAllCompanyies() throws Exception {
        return companyDao.getAllCompanyies();
    }
    
    @Override
    public byte[] getCompanyLogo(Integer companyId) throws Exception {
        return companyDao.getCompanyLogo(companyId);
    }
    
    @Override
    public void deleteCompany(Integer companyId) throws Exception {
        companyDao.deleteCompany(companyId);
    }
    
    @Override
    public void updateCompany(Company company) throws Exception {
        companyDao.updateCompany(company);
    }
    
}
