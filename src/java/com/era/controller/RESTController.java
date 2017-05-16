/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.controller;

import com.era.model.Category;
import com.era.model.Company;
import com.era.model.Equipment;
import com.era.model.SubActivity;
import com.era.model.User;
import com.era.service.CategoryService;
import com.era.service.CompanyService;
import com.era.service.EquipmentService;
import com.era.service.SubActivityService;
import com.era.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LQwabe
 */
@RestController
public class RESTController {

    @Autowired
    UserService userService;

    @Autowired
    SubActivityService subActivityService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    CompanyService companyService;

    //-------------------Retrieve All Users--------------------------------------------------------
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> userList = null;
        try {
            userList = userService.getAllUsers();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userList.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }

        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);

    }

    //-------------------Retrieve All equipment--------------------------------------------------------
    @RequestMapping(value = "/equipment", method = RequestMethod.GET)
    public ResponseEntity<List<Equipment>> getAllEquipment() {

        List<Equipment> equipmentList = null;
        try {
            equipmentList = equipmentService.getAllEquipment();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (equipmentList.isEmpty()) {
            return new ResponseEntity<List<Equipment>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }

        return new ResponseEntity<List<Equipment>>(equipmentList, HttpStatus.OK);

    }
    //-------------------add equipment --------------------------------------------------------

    @RequestMapping(value = "/equipment", method = RequestMethod.POST)
    public ResponseEntity<List<Equipment>> addEquipment(@RequestBody Equipment equipment) {

        List<Equipment> equipmentList = null;
        try {
            equipmentList = equipmentService.getAllEquipment();
            equipmentService.addEquipment(equipment);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (equipmentList.isEmpty()) {
            return new ResponseEntity<List<Equipment>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }

        return new ResponseEntity<List<Equipment>>(equipmentList, HttpStatus.OK);

    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable String username) {

        System.out.println("FetchingEmployee with username " + username);

        User user = null;
        try {
            user = userService.getUserByUsername(username);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
            System.out.println("User with id " + username + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

    //-------------------Retrieve All Users--------------------------------------------------------
    @RequestMapping(value = "/subActivities/", method = RequestMethod.GET)
    public ResponseEntity<List<SubActivity>> getAllSubActivities() {

        List<SubActivity> subActivityList = null;
        try {
            subActivityList = subActivityService.getAllSubActivities();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (subActivityList.isEmpty()) {
            return new ResponseEntity<List<SubActivity>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }

        return new ResponseEntity<List<SubActivity>>(subActivityList, HttpStatus.OK);

    }
    //-------------------Retrieve All categories--------------------------------------------------------

    @RequestMapping(value = "/categories/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories() {

        List<Category> categoryList = null;
        try {
            categoryList = categoryService.getAllCategories();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (categoryList.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }

        return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);

    }

    @RequestMapping(value = "/companies/", method = RequestMethod.GET)
    public ResponseEntity<List<Company>> getAllCompanies() {

        List<Company> companyList = null;
        try {
            companyList = companyService.getAllCompanyies();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (companyList.isEmpty()) {
            return new ResponseEntity<List<Company>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }

        return new ResponseEntity<List<Company>>(companyList, HttpStatus.OK);

    }

}
