/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.controller;

import com.era.model.Category;
import com.era.model.Company;
import com.era.model.Equipment;
import com.era.model.Specification;
import com.era.model.User;
import com.era.service.CategoryService;
import com.era.service.CompanyService;
import com.era.service.EquipmentService;
import com.era.service.SpecificationService;
import com.era.service.UserService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author LQwabe
 */
@Controller
public class AppController {
    
    @Autowired
    private EquipmentService equipmentService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private CompanyService manufacturerService;
    
    @Autowired
    private SpecificationService specificationService;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/", method = GET)
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/home", method = GET)
    public String index2(ModelMap map) throws Exception {
//        List<Equipment> equipmentList = equipmentService.getAllEquipment();
//        map.put("equipmentList", equipmentList);
        return "user_home";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap map) throws Exception {
        return "index";
    }
    
    @RequestMapping(value = "/admin", method = GET)
    public String adminHome(ModelMap map) throws Exception {
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        map.put("equipmentList", equipmentList);
        return "admin";
    }

    //For  adding equipment 
    @RequestMapping(value = "/equipment/add", method = RequestMethod.POST)
    public String addEquipment(
            @RequestParam("username") String username,
            @RequestParam("name") String name,
            @RequestParam("trl") Integer trl,
            @RequestParam("manufacturer") String manufacturer,
            @RequestParam("category") Integer categoryId,
            final RedirectAttributes redirectAttributes) throws Exception {
        
        Equipment eq = new Equipment();
        
        Category a_category = categoryService.getCategoryById(categoryId);
        Company the_manufacturer = manufacturerService.getCompanyByCompanyName(manufacturer);
        User user = userService.getUserByUsername(username);
        
        eq.setName(name);
        eq.setTrl(trl);
        eq.setManufacturer(the_manufacturer);
        eq.setCategory(a_category);
        boolean results = equipmentService.addEquipment(eq);
        
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        
        if (results == true) {
            // Add message to flash scope
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "Equipment added successfully!");
            redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
        } else {
            //existing equipment, call update
            equipmentService.updateEquipment(eq);
            // Add message to flash scope
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "Equipment updated successfully!");
            redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
        }
        
        return "redirect:/home";
        
    }

    //For  adding new user
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("email") String email,
            @RequestParam("contact") String contact,
            @RequestParam("company") String companyName,
            @RequestParam("role") Integer role,
            final RedirectAttributes redirectAttributes) throws Exception {
        Company comany = manufacturerService.getCompanyByCompanyName(companyName);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setContact(contact);
        user.setEmail(email);
        user.setCompany(comany);
        user.setRole(role);
        
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        boolean results = userService.addUser(user);
        
        if (results == true) {
            String admin_username = "admin";
            Integer user_role = 0;
            List<Company> OEMs = manufacturerService.getAllCompanyies();
            List Users = userService.getUsersByRole(user_role);
            User admin_user = userService.getUserByUsername(admin_username);
            // Add message to flash scope
            redirectAttributes.addFlashAttribute("admin", admin_user);
            redirectAttributes.addFlashAttribute("OEMs", OEMs);
            redirectAttributes.addFlashAttribute("Users", Users);
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "User added successfully!");
            redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
        } else {
            String admin_username = "admin";
            Integer user_role = 0;
            List<Company> OEMs = manufacturerService.getAllCompanyies();
            List<User> Users = userService.getUsersByRole(user_role);
            User admin_user = userService.getUserByUsername(admin_username);

            // Add message to flash scope
            redirectAttributes.addFlashAttribute("admin", admin_user);
            redirectAttributes.addFlashAttribute("OEMs", OEMs);
            redirectAttributes.addFlashAttribute("Users", Users);
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("msg", "The User already exist!");
            redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
        }
        
        return "redirect:/admin";
        
    }

    //For  editing  user
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String EditUser(
            @RequestParam("username1") String username,
            @RequestParam("password1") String password,
            @RequestParam("firstname1") String firstname,
            @RequestParam("lastname1") String lastname,
            @RequestParam("email1") String email,
            @RequestParam("contact1") String contact,
            @RequestParam("company1") String companyName,
            final RedirectAttributes redirectAttributes) throws Exception {
        Company comany = manufacturerService.getCompanyByCompanyName(companyName);
        
        User user = userService.getUserByUsername(username);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setContact(contact);
        user.setEmail(email);
        user.setCompany(comany);
        userService.updateUser(user);
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        String admin_username = "admin";
        Integer user_role = 0;
        List<Company> OEMs = manufacturerService.getAllCompanyies();
        List Users = userService.getUsersByRole(user_role);
        User admin_user = userService.getUserByUsername(admin_username);
        // Add message to flash scope
        redirectAttributes.addFlashAttribute("admin", admin_user);
        redirectAttributes.addFlashAttribute("OEMs", OEMs);
        redirectAttributes.addFlashAttribute("Users", Users);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
        redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
        
        return "redirect:/admin";
        
    }

    //For  editing  equipment
    @RequestMapping(value = "/equipment/edit", method = RequestMethod.POST)
    public String EditEquipment(
            @RequestParam("username1") String username,
            @RequestParam("equipmentId1") Integer equipmentId,
            @RequestParam("name1") String name,
            @RequestParam("trl1") Integer trl,
            @RequestParam("manufacturer1") String manufacturer,
            final RedirectAttributes redirectAttributes) throws Exception {
        Company company = manufacturerService.getCompanyByCompanyName(manufacturer);
        Equipment equipment = equipmentService.getEquipmentById(equipmentId);
        
        User user = userService.getUserByUsername(username);
        equipment.setName(name);
        equipment.setTrl(trl);
        equipment.setManufacturer(company);
        equipmentService.updateEquipment(equipment);
        
        List<Equipment> equipmentList = equipmentService.getEquipmentByManufacturer(company);
        // Add message to flash scope
        redirectAttributes.addFlashAttribute("user", user);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Tool updated successfully!");
        redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
        
        return "redirect:/home";
        
    }

    //For  editing  user
    @RequestMapping(value = "/oem/edit", method = RequestMethod.POST)
    public String EditOEM(
            @RequestParam("companyId1") Integer companyId,
            @RequestParam("name1") String OEMname,
            @RequestParam("logo1") MultipartFile logo,
            final RedirectAttributes redirectAttributes) throws Exception {
        
        Company comany = manufacturerService.getCompanyByCompanyId(companyId);
        
        byte[] logoBytes = null;
        if (!logo.isEmpty()) {
            
            logoBytes = logo.getBytes();
            comany.setCompanyLogo(logoBytes);
            
        }
        comany.setCompanyName(OEMname);
        manufacturerService.updateCompany(comany);
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        String admin_username = "admin";
        Integer user_role = 0;
        List<Company> OEMs = manufacturerService.getAllCompanyies();
        List Users = userService.getUsersByRole(user_role);
        User admin_user = userService.getUserByUsername(admin_username);
        // Add message to flash scope
        redirectAttributes.addFlashAttribute("admin", admin_user);
        redirectAttributes.addFlashAttribute("OEMs", OEMs);
        redirectAttributes.addFlashAttribute("Users", Users);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "OEM updated successfully!");
        redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
        
        return "redirect:/admin";
        
    }

    //For  login
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            final RedirectAttributes redirectAttributes) throws Exception {

        // User user = userService.getUserByUsername(username);
        Company company = null;
        List<Equipment> equipmentList = null;
        List<Equipment> equipmentList_us = null;
        boolean authenticated = userService.authenticateUser(username, password);
        if (authenticated == true) {
            User user = userService.getUserByUsername(username);
            
            company = user.getCompany();
            equipmentList = equipmentService.getAllEquipment();
            equipmentList_us = equipmentService.getEquipmentByManufacturer(company);
            
            if (user.getRole() == 1 && user.getPassword().equals(password)) {
                Integer role = 0;
                List<Company> OEMs = manufacturerService.getAllCompanyies();
                List Users = userService.getUsersByRole(role);
                redirectAttributes.addFlashAttribute("OEMs", OEMs);
                redirectAttributes.addFlashAttribute("Users", Users);
                redirectAttributes.addFlashAttribute("admin", user);
                redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
                return "redirect:/admin";
            } else {
                redirectAttributes.addFlashAttribute("user", user);
                redirectAttributes.addFlashAttribute("equipmentList", equipmentList_us);
                return "redirect:/home";
            }
        }
        
        if (authenticated == false) {
            
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("msg", "Login failed! Invalid Username and/or Password. Please Try again.");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("msg", "Login failed! Invalid Username and/or Password. Please Try again.");
            return "redirect:/";
        }
        
    }

    //For  adding equipment  specification
    @RequestMapping(value = "/specification/add", method = RequestMethod.POST)
    public String addEquipmentSpecification(
            
           
            @RequestParam("equipmentId") Integer equipmentId,
            @RequestParam("image") MultipartFile image,
            @RequestParam("datasheet") MultipartFile datasheet,
            @RequestParam(value="specParameter" , required=false ) String specParameter,
            @RequestParam(value="specValue",required=false ) String specValue,
            final RedirectAttributes redirectAttributes) throws Exception {
        
        Equipment _equipment = equipmentService.getEquipmentById(equipmentId);
        Company company = _equipment.getManufacturer();
        User user = userService.getUsersByCompany(company).get(0);
        byte[] imageBytes = null;
        
        String pictureFiletype = image.getContentType();
        String datasheetFiletype = datasheet.getContentType();
        
        byte[] datasheetBytes = null;
        
        if (!image.isEmpty()) {
            
            imageBytes = image.getBytes();
            
        }
        if (!datasheet.isEmpty()) {
            
            datasheetBytes = datasheet.getBytes();
        }
        String specificationDetails=null;
        if((specParameter!= null && !specParameter.isEmpty())&&(specValue!= null && !specValue.isEmpty())){
        specificationDetails = specParameter + ":" + specValue + ",";
        }
        
        Specification equipmentSpec = new Specification();
        equipmentSpec.setSpecificationId(equipmentId);
        equipmentSpec.setPicture(imageBytes);
        equipmentSpec.setPictureFiletype(pictureFiletype);
        equipmentSpec.setDatasheet(datasheetBytes);
        equipmentSpec.setDatasheetFiletype(datasheetFiletype);
        equipmentSpec.setSpecificationDetails(specificationDetails);
        
        specificationService.addSpecification(equipmentSpec);
        
        Equipment equipment = equipmentService.getEquipmentById(equipmentId);
        
        equipment.setSpecification(equipmentSpec);
        
        equipmentService.updateEquipment(equipment);
        
        boolean results = specificationService.isSpecificationExists(equipmentSpec);
        
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        
        if (results == true) {
            
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("msg", "Equipment specicication added successfully!");
            redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
        } else {
            //existing equipment, call update

            // Add message to flash scope
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("msg", "Error while updating. Please try again!");
            redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
        }
        return "redirect:/home";
        
    }
    //For  adding equipment  specification

    @RequestMapping(value = "/oem/add", method = RequestMethod.POST)
    public String addOEM(
            @RequestParam("name") String OEMname,
            @RequestParam("logo") MultipartFile logo,
            final RedirectAttributes redirectAttributes) throws Exception {
        byte[] logoBytes = null;
        
        if (!logo.isEmpty()) {
            
            logoBytes = logo.getBytes();
            
        }
        
        Company company = new Company();
        company.setCompanyLogo(logoBytes);
        company.setCompanyName(OEMname);
        
        boolean results = manufacturerService.addCompany(company);
        
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        
        if (results == true) {
            String username = "admin";
            Integer role = 0;
            List<Company> OEMs = manufacturerService.getAllCompanyies();
            List Users = userService.getUsersByRole(role);
            User user = userService.getUserByUsername(username);
            // Add message to flash scope
            redirectAttributes.addFlashAttribute("admin", user);
            redirectAttributes.addFlashAttribute("OEMs", OEMs);
            redirectAttributes.addFlashAttribute("Users", Users);
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "OEM added successfully!");
            redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
        } else {
            //existing oem, call update
            String username = "admin";
            Integer role = 0;
            List<Company> OEMs = manufacturerService.getAllCompanyies();
            List<User> Users = userService.getUsersByRole(role);
            User user = userService.getUserByUsername(username);

            // Add message to flash scope
            redirectAttributes.addFlashAttribute("admin", user);
            redirectAttributes.addFlashAttribute("OEMs", OEMs);
            redirectAttributes.addFlashAttribute("Users", Users);
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("msg", "The OEM already exist!");
            redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
        }
        return "redirect:/admin";
    }

    // delete  equipment
    @RequestMapping(value = "/equipment/{equipmentId}/delete", method = RequestMethod.GET)
    public String deleteEquipment(@PathVariable("equipmentId") Integer equipmentId, final RedirectAttributes redirectAttributes) throws Exception {
        
        Equipment equipment = equipmentService.getEquipmentById(equipmentId);
        Company company = equipment.getManufacturer();
        User user = userService.getUsersByCompany(company).get(0);
        
        equipmentService.deleteEquipment(equipmentId);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("user", user);
        redirectAttributes.addFlashAttribute("msg", "Equipment successfully deleted!");
        
        return "redirect:/home";
        
    }
    // delete oem

    @RequestMapping(value = "/oem/{companyId}/delete", method = RequestMethod.GET)
    public String deleteOEM(@PathVariable("companyId") Integer companyId, final RedirectAttributes redirectAttributes) throws Exception {
        
        Company company = manufacturerService.getCompanyByCompanyId(companyId);
        
        List<Equipment> equipmentList = equipmentService.getEquipmentByManufacturer(company);
        List<User> UserList = userService.getUsersByCompany(company);
        
        if (!equipmentList.isEmpty() || !UserList.isEmpty()) {
            
            String username = "admin";
            Integer role = 0;
            List<Company> OEMs = manufacturerService.getAllCompanyies();
            List<User> Users = userService.getUsersByRole(role);
            User user = userService.getUserByUsername(username);

            // Add message to flash scope
            redirectAttributes.addFlashAttribute("admin", user);
            redirectAttributes.addFlashAttribute("OEMs", OEMs);
            redirectAttributes.addFlashAttribute("Users", Users);
            
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("msg", "Sorry! This OEM is being used , therefore cannot be deleted!");
            
        } else {
            manufacturerService.deleteCompany(companyId);
            String username = "admin";
            Integer role = 0;
            List<Company> OEMs = manufacturerService.getAllCompanyies();
            List<User> Users = userService.getUsersByRole(role);
            User user = userService.getUserByUsername(username);

            // Add message to flash scope
            redirectAttributes.addFlashAttribute("admin", user);
            redirectAttributes.addFlashAttribute("OEMs", OEMs);
            redirectAttributes.addFlashAttribute("Users", Users);
            
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "OEM successfully deleted!");
            
        }
        return "redirect:/admin";
        
    }
    // delete oem

    @RequestMapping(value = "/user/{username}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("username") String username, final RedirectAttributes redirectAttributes) throws Exception {
        
        User a_user = userService.getUserByUsername(username);
        Company company = a_user.getCompany();
        List<Equipment> equipmentList = equipmentService.getEquipmentByManufacturer(company);
        
        if (!equipmentList.isEmpty()) {
            
            String admin_username = "admin";
            Integer role = 0;
            List<Company> OEMs = manufacturerService.getAllCompanyies();
            List<User> Users = userService.getUsersByRole(role);
            User user = userService.getUserByUsername(admin_username);

            // Add message to flash scope
            redirectAttributes.addFlashAttribute("admin", user);
            redirectAttributes.addFlashAttribute("OEMs", OEMs);
            redirectAttributes.addFlashAttribute("Users", Users);
            
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("msg", "Sorry! There are equipment regitered user this user , therefore cannot be deleted!");
            
        } else {
            userService.deleteUser(username);
            String admin_username = "admin";
            Integer role = 0;
            List<Company> OEMs = manufacturerService.getAllCompanyies();
            List<User> Users = userService.getUsersByRole(role);
            User user = userService.getUserByUsername(admin_username);

            // Add message to flash scope
            redirectAttributes.addFlashAttribute("admin", user);
            redirectAttributes.addFlashAttribute("OEMs", OEMs);
            redirectAttributes.addFlashAttribute("Users", Users);
            
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "OEM successfully deleted!");
            
        }
        return "redirect:/admin";
        
    }

    /**
     *
     * @param action
     * @param equipmentId
     * @param response
     * @param redirectAttributes
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "download", method = RequestMethod.GET)
    public String downloadSpecification(
            @RequestParam("action") String action,
            @RequestParam("equipmentId") Integer equipmentId,
            HttpServletResponse response,
            final RedirectAttributes redirectAttributes) throws Exception {
        
        if (action.equalsIgnoreCase("image")) {
            Equipment equipment = equipmentService.getEquipmentById(equipmentId);
            Specification specification = equipment.getSpecification();
            byte[] image = specification.getPicture();
            String pictureFiletype = specification.getPictureFiletype();
            String fileName = "";
            if (pictureFiletype.contains("image/png")) {
                fileName = "dowloaded_image" + ".png";
                
            }
            if (pictureFiletype.contains("jpg") || pictureFiletype.contains("jpeg")) {
                fileName = "dowloaded_image" + ".jpg";
                
            }
            if (pictureFiletype.contains("gif")) {
                fileName = "dowloaded_image" + ".gif";
            }
            response.setContentType(pictureFiletype);
            response.setHeader("Content-Disposition", "attachment;     filename=\"" + fileName + "\"");
            FileCopyUtils.copy(image, response.getOutputStream());
        }
        if (action.equalsIgnoreCase("datasheet")) {
            
            Equipment equipment = equipmentService.getEquipmentById(equipmentId);
            Specification specification = equipment.getSpecification();
            byte[] datasheet = specification.getDatasheet();
            String datasheetFiletype = specification.getDatasheetFiletype();
            String fileName = "";
            
            if (datasheetFiletype.contains("pdf")) {
                
                fileName = "Datasheet" + ".pdf";
            }
            
            if (datasheetFiletype.contains("spreadsheet") || datasheetFiletype.contains("sheet")) {
                
                fileName = "Datasheet" + ".xlsx";
            }
            if (datasheetFiletype.contains("ms-excel")) {
                
                fileName = "Datasheet" + ".xls";
            }
            if (datasheetFiletype.contains("wordprocessingml")) {
                
                fileName = "Datasheet" + ".docx";
            }
            if (datasheetFiletype.contains("msword")) {
                
                fileName = "Datasheet" + ".doc";
            }
            
            if (datasheetFiletype.contains("presentationml") || datasheetFiletype.contains("presentation")) {
                
                fileName = "Datasheet" + ".pptx";
            }
            if (datasheetFiletype.contains("ms-powerpoint")) {
                
                fileName = "Datasheet" + ".ppt";
            }
            
            if (datasheetFiletype.contains("csv")) {
                
                fileName = "Datasheet" + ".csv";
            }
            
            response.setContentType(datasheetFiletype);
            response.setHeader("Content-Disposition", "attachment;     filename=\"" + fileName + "\"");
            FileCopyUtils.copy(datasheet, response.getOutputStream());
        }
        return "redirect:/home";
        
    }

    @RequestMapping(value = "/getLogo/{companyId}")
    public void getCompanyLogo(HttpServletResponse response, @PathVariable("companyId") Integer companyId) throws IOException, Exception {
        
        response.setContentType("image/png");
        Company company = manufacturerService.getCompanyByCompanyId(companyId);
        byte[] buffer = company.getCompanyLogo();
        InputStream inputStream = new ByteArrayInputStream(buffer);
        IOUtils.copy(inputStream, response.getOutputStream());
    }
    
    @RequestMapping(value = "/category/{categoryId}/{username}", method = GET)
    public String getByCategory(@PathVariable("categoryId") Integer categoryId, @PathVariable("username") String username, final RedirectAttributes redirectAttributes) throws Exception {
        
        Category category = categoryService.getCategoryById(categoryId);
//        List<Equipment> equipmentList = equipmentService.getEquipmentByCategory(category);
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        User user = userService.getUserByUsername(username);
        String no_record_found;
        
        if (equipmentList.isEmpty() || equipmentList.size() == 0) {
            no_record_found = "No Record Found";
            redirectAttributes.addFlashAttribute("No Record Found", no_record_found);
        }
        redirectAttributes.addFlashAttribute("equipmentList", equipmentList);
        redirectAttributes.addFlashAttribute("user", user);
        return "user_category";
        
    }
    
}
