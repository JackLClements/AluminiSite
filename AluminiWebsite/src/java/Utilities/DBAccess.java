/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilities;
import java.sql.*;
/**
 *
 * @author Jack L. Clements, jack.clements@uea.ac.uk
 */
public class DBAccess {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        String jdbcDriver = "org.postgresql.Driver";
        Class.forName(jdbcDriver);
        String jdbcUrl = "jdbc:postgresql:postgres";
        String username = "dbuser";
        String password = "dbpassword";
        
        return (DriverManager.getConnection(jdbcUrl, username, password));
        
        
    }

}
