/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.model.Company;
import java.util.List;

/**
 *
 * @author LQwabe
 */
public interface CompanyService {

    public boolean addCompany(Company company) throws Exception;

    public boolean isCompanyExists(Company company) throws Exception;

    public Company getCompanyByCompanyId(Integer companyId) throws Exception;

    public Company getCompanyByCompanyName(String companyName) throws Exception;

    public List<Company> getAllCompanyies() throws Exception;

    public byte[] getCompanyLogo(Integer companyId) throws Exception;

    public void deleteCompany(Integer companyId) throws Exception;

    public void updateCompany(Company company) throws Exception;

}
