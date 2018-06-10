package alumini;

import Utilities.DBAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sky13nmu
 */
public class SchoolAttended {
    
    //Fields
    private String username;
    private String school;
    private int startDate;
    private int endDate;
    
    
    //Constructors
    SchoolAttended(){}
    SchoolAttended(String username, String school, int startDate, int endDate){
        
        this.username = username;
        this.school = school;
        this.startDate = startDate;
        this.endDate = endDate;
        
    }
    
    //ResultSet Constructor
    public SchoolAttended(ResultSet rs) throws SQLException{
        this.username = rs.getString("username");
        this.school = rs.getString("school");
        this.startDate = rs.getInt("startDate");
        this.endDate = rs.getInt("endDate");
    }
    
    //Username getter and setter
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    
    //School getter and setter
    public String getSchool(){
        return this.school;
    }
    
    public void setSchool(String school){
        this.school = school;
    }
    
    
    //Start Date getter and setter
    public int getStartDate(){
        return this.startDate;
    }
    
    public void setStartDate(int startDate){
        this.startDate = startDate;
    }
    
    
    //End Date getter and setter
    public int getEndDate(){
        return this.endDate;
    }
    
    public void setEnddate(int endDate){
        this.endDate = endDate;
    }
    
    //Persist method
    public void persist() throws ServletException {
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO schoolAttended(username, school, startDate, endDate) VALUES(?, ?, ?, ?)");
            
            ps.setString(1, username);
            ps.setString(2, school);
            ps.setInt(3, startDate);
            ps.setInt(4, endDate);
            
            ps.executeUpdate();
            
        }
        
        catch(Exception e){
            throw new ServletException("Persist Problem ", e);
        }
    }
    
    //Delete method
    public void delete() throws ServletException {
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM schoolAttended WHERE username='"+username+"' AND school='"+school+"' AND startDate = "+startDate+" AND endDate = "+endDate+";");
            ps.executeUpdate();
        }
        catch(Exception e){
            throw new ServletException("Deletion error ", e);
        }
    }
    
    //Search for user schools
    public static ArrayList getUserSchools(String username) throws ServletException{
        ArrayList userSchools = new ArrayList<SchoolAttended>();
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT * FROM schoolAttended WHERE username ='"+ username + "'");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                SchoolAttended school1 = new SchoolAttended(rs);
                userSchools.add(school1);
            }
        }
        catch(Exception e){
            throw new ServletException("returnAll Problem ", e);
        }
        return userSchools;
        
    }
    
    //Get all school attendees/alumini
    public static ArrayList getSchoolAlumini(String school) throws ServletException{
        ArrayList schoolAlumini = new ArrayList<SchoolAttended>();
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT * FROM schoolAttended WHERE school ='"+school+"'");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                SchoolAttended school1 = new SchoolAttended(rs);
                schoolAlumini.add(school1);
            }
        }
        catch(Exception e){
            throw new ServletException("SchoolAlumini Error", e);
        }
        return schoolAlumini;
    }
    
    //Gets schoolmates of user
    public static ArrayList getSchoolmates(String user) throws ServletException{
        ArrayList<SchoolAttended> schoolMates = new ArrayList<SchoolAttended>();
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT * FROM schoolAttended WHERE username ='" + user +"'");
            ResultSet rs = ps.executeQuery();
            ArrayList<SchoolAttended> schools = new ArrayList<SchoolAttended>();
            while(rs.next()){
                SchoolAttended school1 = new SchoolAttended(rs);
                schools.add(school1);
            }
            for(SchoolAttended i: schools){
                String userSchool = i.getSchool();
                int start = i.getStartDate();
                int end = i.getEndDate();
                PreparedStatement ps2 = con.prepareStatement("SELECT * FROM schoolAttended WHERE school ='"+ userSchool +"' AND startdate <= "+ end +" AND enddate >= "+ start +" AND username != '"+ user +"';");
                ResultSet rs2 = ps2.executeQuery();
                while(rs2.next()){
                    SchoolAttended school2 = new SchoolAttended(rs2);
                    schoolMates.add(school2);
                }
            }
            
        }
        catch(Exception e){
            throw new ServletException("Schoolmates lookup Error", e);
        }
        return schoolMates;
    }
    
}
