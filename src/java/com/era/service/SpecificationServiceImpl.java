/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.dao.SpecificationDao;
import com.era.model.Specification;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LQwabe
 */
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    SpecificationDao specificationDao;

    @Override
    public boolean addSpecification(Specification specification) throws Exception {
        return specificationDao.addSpecification(specification);
    }

    @Override
    public boolean isSpecificationExists(Specification specification) throws Exception {
        return specificationDao.isSpecificationExists(specification);
    }

    @Override
    public Specification getSpecificationById(Integer specificationId) throws Exception {
        return specificationDao.getSpecificationById(specificationId);
    }

    @Override
    public List<Specification> getAllSpecifications() throws Exception {
        return specificationDao.getAllSpecifications();
    }

    @Override
    public void deleteSpecification(Integer specificationId) throws Exception {
        specificationDao.deleteSpecification(specificationId);
    }

    @Override
    public void updateSpecification(Specification specification) throws Exception {
        specificationDao.updateSpecification(specification);
    }

}
