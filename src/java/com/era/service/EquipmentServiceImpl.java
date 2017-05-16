/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.dao.EquipmentDao;
import com.era.model.Category;
import com.era.model.Company;
import com.era.model.Equipment;
import com.era.model.Specification;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class EquipmentServiceImpl implements EquipmentService {
    
    @Autowired
    EquipmentDao equipmentDao;
    
    @Override
    public boolean addEquipment(Equipment equipment) throws Exception {
        return equipmentDao.addEquipment(equipment);
    }
    
    @Override
    public boolean isEquipmentExists(Equipment equipment) throws Exception {
        return equipmentDao.isEquipmentExists(equipment);
    }
    
    @Override
    public Equipment getEquipmentById(Integer equipmentId) throws Exception {
        return equipmentDao.getEquipmentById(equipmentId);
    }
    
    @Override
    public List<Equipment> getEquipmentByName(String equipmentName) throws Exception {
        return equipmentDao.getEquipmentByName(equipmentName);
    }
    
    @Override
    public List<Equipment> getEquipmentByTRL(Integer trl) throws Exception {
        return equipmentDao.getEquipmentByTRL(trl);
    }
    
    @Override
    public List<Equipment> getEquipmentByCategory(Category category) throws Exception {
        return equipmentDao.getEquipmentByCategory(category);
    }
    
    @Override
    public List<Equipment> getEquipmentByManufacturer(Company company) throws Exception {
        return equipmentDao.getEquipmentByManufacturer(company);
    }
    
    @Override
    public List<Equipment> getEquipmentBySpecification(Specification specification) throws Exception {
        return equipmentDao.getEquipmentBySpecification(specification);
    }
    
    @Override
    public List<Equipment> getAllEquipment() throws Exception {
        return equipmentDao.getAllEquipment();
    }
    
    @Override
    public void deleteEquipment(Integer equipmentId) throws Exception {
        equipmentDao.deleteEquipment(equipmentId);
    }
    
    @Override
    public void updateEquipment(Equipment equipment) throws Exception {
        equipmentDao.updateEquipment(equipment);
    }
}
