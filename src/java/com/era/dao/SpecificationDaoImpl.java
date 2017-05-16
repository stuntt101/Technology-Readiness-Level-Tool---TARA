/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.dao;

import com.era.model.Specification;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class SpecificationDaoImpl implements SpecificationDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    /**
     * add new specification in the database. If the specification is already
     * exists , returns false.
     *
     * @param specification the specification object
     * @return true otherwise false if specification is already exists
     * @throws java.lang.Exception
     */
    @Override
    public boolean addSpecification(Specification specification) throws Exception {
        if (isSpecificationExists(specification)) {
            return false;
        }

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(specification);
        tx.commit();
        session.close();

        return true;
    }

    /**
     * check if the specification exists in the database. If it does not exists
     * , returns false.
     *
     * @param specification the specification object
     * @return true if the specification exists otherwise false for non existent
     * @throws java.lang.Exception
     */
    @Override
    public boolean isSpecificationExists(Specification specification) throws Exception {
        session = sessionFactory.openSession();
        boolean result = false;
        Specification a_specification = (Specification) session.createQuery("from Specification where specificationId='" + specification.getSpecificationId() + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();

        if (a_specification != null) {
            result = true;
        }
        return result;
    }

    /**
     * Return specification object for the given specification ID from database.
     * If specification is not found, returns null.
     *
     * @param specificationId the specification ID
     * @return specification object for given ID
     * @throws java.lang.Exception
     */
    @Override
    public Specification getSpecificationById(Integer specificationId) throws Exception {
        session = sessionFactory.openSession();
        Specification specification = (Specification) session.createQuery("from Specification where specificationId='" + specificationId + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return specification;
    }

    /**
     * Returns list of all specifications from database.
     *
     * @return list of specifications
     * @throws java.lang.Exception
     */
    @Override
    public List<Specification> getAllSpecifications() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Specification> specificationList = session.createCriteria(Specification.class)
                .list();
        tx.commit();
        session.close();
        return specificationList;
    }

    /**
     * Delete the specification from database.
     *
     * @param specificationId the ID for the specification to be deleted
     * @throws java.lang.Exception
     */
    @Override
    public void deleteSpecification(Integer specificationId) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Specification.class, new Integer(specificationId));
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
    }

    /**
     * Update the specification object in the database.
     *
     * @param specification the specification to be updated
     * @throws java.lang.Exception
     */
    @Override
    public void updateSpecification(Specification specification) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(specification);
        tx.commit();
        session.close();
    }

}
