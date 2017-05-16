/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.model.Category;
import com.era.model.Company;
import com.era.model.Equipment;
import com.era.model.Specification;
import java.util.List;

/**
 *
 * @author LQwabe
 */
public interface EquipmentService {

    public boolean addEquipment(Equipment equipment) throws Exception;

    public boolean isEquipmentExists(Equipment equipment) throws Exception;

    public Equipment getEquipmentById(Integer equipmentId) throws Exception;

    public List<Equipment> getEquipmentByName(String equipmentName) throws Exception;

    public List<Equipment> getEquipmentByTRL(Integer trl) throws Exception;

    public List<Equipment> getEquipmentByCategory(Category category) throws Exception;

    public List<Equipment> getEquipmentByManufacturer(Company company) throws Exception;

    public List<Equipment> getEquipmentBySpecification(Specification specification) throws Exception;

    public List<Equipment> getAllEquipment() throws Exception;

    public void deleteEquipment(Integer equipmentId) throws Exception;

    public void updateEquipment(Equipment equipment) throws Exception;

}
