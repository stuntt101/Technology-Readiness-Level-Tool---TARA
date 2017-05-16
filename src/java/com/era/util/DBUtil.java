/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.util;

import com.era.model.Category;
import com.era.model.Company;
import com.era.model.Equipment;
import com.era.model.Specification;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LQwabe
 */
public class DBUtil {

    public static Connection getConnection() {
        Connection connection = null;
        if (connection != null) {
            return connection;
        }
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipment_readiness_db",
                    "root", "13579");

//             connection = DriverManager.getConnection("jdbc:mysql://mysql-instance1.cvi6sv5aebma.us-west-2.rds.amazonaws.com:3306/equipment_readiness_db",
//                    "csir", "csir.nre");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Equipment getEquipmentById(int EquipmentId) {
        Equipment equipment = new Equipment();

        try {
            PreparedStatement preparedStatement = DBUtil.getConnection().
                    prepareStatement("select * from equipment where equipment_id=?");
            preparedStatement.setInt(1, EquipmentId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {

                equipment.setEquipmentId(rs.getInt("equipment_id"));
                equipment.setName(rs.getString("name"));
                equipment.setTrl(rs.getInt("trl"));
                Category category = new Category(rs.getInt("category"));
                Company company = new Company(rs.getInt("manufacturer"));
                Specification specification = new Specification(rs.getInt("specification"));
                equipment.setSpecification(specification);
                equipment.setCategory(category);
                equipment.setManufacturer(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipment;
    }
}
