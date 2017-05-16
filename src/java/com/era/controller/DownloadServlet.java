/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.era.model.Equipment;
import com.era.model.Specification;
import com.era.service.EquipmentService;
import com.era.service.SpecificationService;
import com.era.util.DBUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author LQwabe
 */
public class DownloadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private SpecificationService specificationService;

    private WebApplicationContext springContext;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
        beanFactory.autowireBean(this);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("image")) {
            Integer equipmentId = Integer.parseInt(request.getParameter("equipmentId"));

            Equipment equipment = equipmentService.getEquipmentById(equipmentId);
            Specification specification = specificationService.getSpecificationById(equipmentId);
            String picture_filetype = specification.getPictureFiletype();
            String picture_uploaded = "";

            if (picture_filetype.contains("image/png")) {
                picture_uploaded = "Tool_image" + equipmentId + ".png";

            }
            if (picture_filetype.contains("jpg") || picture_filetype.contains("jpeg")) {
                picture_uploaded = "Tool_image" + equipmentId + ".jpg";

            }
            if (picture_filetype.contains("gif")) {
                picture_uploaded = "Tool_image" + equipmentId + ".gif";
            }

            response.setContentType(picture_filetype);
            response.setHeader("Content-Disposition", "attachment;     filename=\"" + picture_uploaded + "\"");
            ServletOutputStream sos;
            sos = response.getOutputStream();
            sos.write(specification.getPicture());
            sos.flush();
            sos.close();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DownloadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DownloadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
