/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.dao;

import com.era.model.Category;
import com.era.model.Company;
import com.era.model.Equipment;
import com.era.model.Specification;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class EquipmentDaoImpl implements EquipmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    /**
     * add new equipment in the database. If the equipment is already exists ,
     * returns false.
     *
     * @param equipment the equipment object
     * @return true otherwise false if equipment is already exists
     * @throws java.lang.Exception
     */
    @Override
    public boolean addEquipment(Equipment equipment) throws Exception {
        if (isEquipmentExists(equipment)) {
            return false;
        }

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(equipment);
        tx.commit();
        session.close();

        return true;
    }

    /**
     * check if the equipment exists in the database. If it does not exists ,
     * returns false.
     *
     * @param equipment the equipment object
     * @return true if the equipment exists otherwise false for non existent
     * @throws java.lang.Exception
     */
    @Override
    public boolean isEquipmentExists(Equipment equipment) throws Exception {

        session = sessionFactory.openSession();
        boolean result = false;
        Equipment an_equipment = (Equipment) session.createQuery("from Equipment where equipmentId='" + equipment.getEquipmentId() + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();

        if (an_equipment != null) {
            result = true;
        }
        return result;
    }

    /**
     * Return equipment object for the  given equipment ID from database. If
     * equipment is not found, returns null.
     *
     * @param equipmentId the equipment ID
     * @return equipment object for given ID
     * @throws java.lang.Exception
     */
    @Override
    public Equipment getEquipmentById(Integer equipmentId) throws Exception {
        session = sessionFactory.openSession();
        Equipment equipment = (Equipment) session.createQuery("from Equipment where equipmentId='" + equipmentId + "'").uniqueResult();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return equipment;

    }

    /**
     * Return list of equipment for given equipment name from database.
     *
     * @param equipmentName the equipment name
     * @return list of equipment
     * @throws java.lang.Exception
     */
    @Override
    public List<Equipment> getEquipmentByName(String equipmentName) throws Exception {
        List<Equipment> equipmentList = new ArrayList<Equipment>();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        equipmentList = session.createQuery("from Equipment where name='" + equipmentName + "'").list();
        tx.commit();
        session.close();
        return equipmentList;

    }

    /**
     * Return list of equipment for given equipment TRL from database.
     *
     * @param trl the equipment TRL
     * @return list of equipment
     * @throws java.lang.Exception
     */
    @Override
    public List<Equipment> getEquipmentByTRL(Integer trl) throws Exception {
        List<Equipment> equipmentList = new ArrayList<Equipment>();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        equipmentList = session.createQuery("from Equipment where trl='" + trl + "'").list();
        tx.commit();
        session.close();
        return equipmentList;

    }

    /**
     * Return list of equipment for given equipment category from database.
     *
     * @param category the equipment category
     * @return list of equipment
     * @throws java.lang.Exception
     */
    @Override
    public List<Equipment> getEquipmentByCategory(Category category) throws Exception {

        List<Equipment> equipmentList = new ArrayList<Equipment>();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        equipmentList = session.createQuery("from Equipment where category='" + category.getCategoryId() + "'").list();
        tx.commit();
        session.close();
        return equipmentList;

    }

    /**
     * Return list of equipment for given equipment manufacturer from database.
     *
     * @param manufacturer the equipment manufacturer
     * @return list of equipment
     * @throws java.lang.Exception
     */
    @Override
    public List<Equipment> getEquipmentByManufacturer(Company manufacturer) throws Exception {

        List<Equipment> equipmentList = new ArrayList<Equipment>();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        equipmentList = session.createQuery("from Equipment where manufacturer='" + manufacturer.getCompanyId() + "'").list();
        tx.commit();
        session.close();
        return equipmentList;
    }

    /**
     * Return list of equipment for given equipment specification from database.
     *
     * @param specification the equipment specification
     * @return list of equipment
     * @throws java.lang.Exception
     */
    @Override
    public List<Equipment> getEquipmentBySpecification(Specification specification) throws Exception {
        List<Equipment> equipmentList = new ArrayList<Equipment>();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        equipmentList = session.createQuery("from Equipment where specification='" + specification.getSpecificationId() + "'").list();
        tx.commit();
        session.close();
        return equipmentList;

    }

    /**
     * Returns list of all equipment from database.
     *
     * @return list of equipment
     * @throws java.lang.Exception
     */
    @Override
    public List<Equipment> getAllEquipment() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Equipment> equipmentList = session.createCriteria(Equipment.class)
                .list();
        tx.commit();
        session.close();
        return equipmentList;

    }

    /**
     * Delete the equipment from database.
     *
     * @param equipmentId the ID for the equipment to be deleted
     * @throws java.lang.Exception
     */
    @Override
    public void deleteEquipment(Integer equipmentId) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Equipment.class, new Integer(equipmentId));
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
    }

    /**
     * Update the equipment object in the database.
     *
     * @param equipment the equipment
     * @throws java.lang.Exception
     */
    @Override
    public void updateEquipment(Equipment equipment) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(equipment);
        tx.commit();
        session.close();

    }

}
