/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.dao;

import com.era.model.Company;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    /**
     * add new company in the database. If the company is already exists ,
     * returns false.
     *
     * @param company the company object
     * @return true otherwise false if company is already exists
     * @throws java.lang.Exception
     */
    @Override
    public boolean addCompany(Company company) throws Exception {

        if (isCompanyExists(company)) {
            return false;
        }

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(company);
        tx.commit();
        session.close();

        return true;

    }

    /**
     * check if the company exists in the database. If it does not exists ,
     * returns false.
     *
     * @param company the company object
     * @return true if the company exists otherwise false for non existent
     * @throws java.lang.Exception
     */
    @Override
    public boolean isCompanyExists(Company company) throws Exception {

        session = sessionFactory.openSession();
        boolean result = false;
        Company a_company = (Company) session.createQuery("from Company where companyId='" + company.getCompanyId() + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();

        if (a_company != null) {
            result = true;
        }
        return result;
    }

    /**
     * Return company object for given company ID from database. If company is
     * not found, returns null.
     *
     * @param companyId the company ID
     * @return company object for given ID
     * @throws java.lang.Exception
     */
    @Override
    public Company getCompanyByCompanyId(Integer companyId) throws Exception {
        session = sessionFactory.openSession();
        Company company = (Company) session.createQuery("from Company where companyId='" + companyId + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return company;
    }

    /**
     * Return company object for given company name from database. If company is
     * not found, returns null.
     *
     * @param companyName the company name
     * @return company object for given company name
     * @throws java.lang.Exception
     */
    @Override
    public Company getCompanyByCompanyName(String companyName) throws Exception {
        session = sessionFactory.openSession();
        Company company = (Company) session.createQuery("from Company where companyName='" + companyName + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return company;
    }

    /**
     * Returns list of all companies from database.
     *
     * @return list of companies
     * @throws java.lang.Exception
     */
    @Override
    public List<Company> getAllCompanyies() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Company> companyList = session.createCriteria(Company.class)
                .list();
        tx.commit();
        session.close();
        return companyList;
    }

    /**
     * Return array of bytes containing Company Logo for given company Id from
     * database.
     *
     * @param companyId the company Id
     * @return array of bytes containing Company Logo for given company Id
     * @throws java.lang.Exception
     */
    @Override
    public byte[] getCompanyLogo(Integer companyId) throws Exception {
        Company company = (Company) session.createQuery("from Company where companyId='" + companyId + "'").uniqueResult();
        byte[] CompanyLogo = company.getCompanyLogo();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();

        return CompanyLogo;

    }

    /**
     * Delete the company from database.
     *
     * @param companyId the ID for the company to be deleted
     * @throws java.lang.Exception
     */
    @Override
    public void deleteCompany(Integer companyId) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Company.class, new Integer(companyId));
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
    }

    /**
     * Update the company object in the database.
     *
     * @param company the company object
     * @throws java.lang.Exception
     */
    @Override
    public void updateCompany(Company company) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.merge(company);
        tx.commit();
        session.close();
    }

}
