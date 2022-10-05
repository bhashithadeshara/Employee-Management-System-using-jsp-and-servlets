/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bhast
 */
public class DbCon {
    
    public static Connection createConnection() throws ClassNotFoundException, SQLException{
    
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","");
        return con;
    }
    
    public static int regEmployee(Employee emp){
    
        int status = 0;
        
        try {
            PreparedStatement ps = createConnection().prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1,emp.getNicNo());
            ps.setString(2,emp.getFname());
            ps.setString(3,emp.getLname());
            ps.setString(4,emp.getTitle());
            ps.setString(5,emp.getRemarks());
            ps.setString(6,emp.getPassword());
            ps.setString(7,emp.getUsername());
            ps.setInt(8,emp.getAge());
            ps.setDouble(9,emp.getAnnualIncome());
            
            status = ps.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
}
