/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdatabase;

import java.sql.*;
import java.util.*;

/**
 *
 * @author vomin
 */
public class TestDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //---Thiet lap ket noi toi co so du lieu---///
        Driver driver = new org.postgresql.Driver();
        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String conString = "jdbc:postgresql://localhost:5432/VMH";
        Properties info = new Properties();
        //---Thong tin cua server postgres
        info.setProperty("characterEncoding", "utf8");
        info.setProperty("user", "postgres");
        info.setProperty("password", "1104");
        try {
            //---Tao connect vs server

            Connection connection = DriverManager.getConnection(conString, info);
            //---Statement---//
            Statement stmt = connection.createStatement();
            stmt = connection.createStatement();
            //---Tao bang moi ---//
            stmt = connection.createStatement();
            //--- Create new table ---//
            String sql = "CREATE TABLE COMPANY "
                    + "(ID INT PRIMARY KEY     NOT NULL,"
                    + " NAME           TEXT    NOT NULL, "
                    + " AGE            INT     NOT NULL, "
                    + " ADDRESS        CHAR(50), "
                    + " SALARY         REAL)";
            stmt.executeUpdate(sql);
            //--- Insert data in table ---//
            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
            stmt.executeUpdate(sql);
            stmt.close();
            //---/Statement---//
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("End process");
        }
        //---Statement---//
    }

}
