package com.conexion.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAFECESA
 */
public class ConectaDB {
    
    public Connection getConnection(){
        Connection  cn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbprueba","root","");
        } catch (SQLException e2) {
            System.out.println("Error: "+e2.getMessage());
        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return cn;
    }

}
