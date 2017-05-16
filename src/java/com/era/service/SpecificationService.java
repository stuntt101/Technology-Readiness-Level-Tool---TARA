/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.service;

import com.era.model.Specification;
import java.util.List;

/**
 *
 * @author LQwabe
 */
public interface SpecificationService {
    
    public boolean addSpecification(Specification specification) throws Exception;

    public boolean isSpecificationExists(Specification specification) throws Exception;

    public Specification getSpecificationById(Integer specificationId) throws Exception;

    public List<Specification> getAllSpecifications() throws Exception;

    public void deleteSpecification(Integer specificationId) throws Exception;

    public void updateSpecification(Specification specification) throws Exception;
    
}
