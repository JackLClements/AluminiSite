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
public class School {
    
    //Fields
    private String schoolName;
    private int opened;
    private String description;
    private String image;
    private String website;
    private String location;
    private String latitude;
    private String longnitude;
    
    //Constructors
    School(){}
    School(String schoolName, int opened, String description, String image, 
            String website, String location, String latitude, String longnitude){
        
        this.schoolName = schoolName;
        this.opened = opened;
        this.description = description;
        this.image = image;
        this.website = website;
        this.location = location;
        this.latitude = latitude;
        this.longnitude = longnitude;
    }
    
    //Constructor for ResultSet data type
    School(ResultSet rs) throws SQLException{
        this.schoolName = rs.getString("schoolName");
        this.opened = rs.getInt("opened");
        this.description = rs.getString("description");
        this.image = rs.getString("image");
        this.website = rs.getString("website");
        this.location = rs.getString("location");
        this.latitude = rs.getString("latitude");
        this.longnitude = rs.getString("longnitude");
    }
    
    //School Name getter and setter
    public String getSchoolName(){
        return schoolName;
    }
    
    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }
    
    
    //Opened getter and setter
    public int getOpened(){
        return opened;
    }
    
    public void setOpened(int opened){
        this.opened = opened;
    }
    
    
    //Description getter and setter
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    
    //Image getter and setter
    public String getImage(){
        return image;
    }
    
    public void setImage(String image){
        this.image = image;
    }
    
    
    //Website getter and setter
    public String getWebsite(){
        return website;
    }
    
    public void setWebsite(String website){
        this.website = website;
    }
    
    
    //Location getter and setter
    public String getLocation(){
        return location;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    
    //Latitude getter and setter
    public String getLatitude(){
        return latitude;
    }
    
    public void setLatitude(String latitude){
        this.latitude = latitude;
    }
    
    public String getLongnitude(){
        return longnitude;
    }
    
    public void setLongnitude(String longnitude){
        this.longnitude = longnitude;
    }
    
    //Persist Method
    public void persist() throws ServletException{
        try{
            Connection con = DBAccess.getConnection();
            String statement = "INSERT INTO school(schoolName, opened, description, image, website, location, latitude, longnitude) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(statement);
            ps.setString(1, schoolName);
            ps.setInt(2, opened);
            ps.setString(3, description);
            ps.setString(4, image);
            ps.setString(5, website);
            ps.setString(6, location);
            ps.setString(7, latitude);
            ps.setString(8, longnitude);
            
            ps.executeUpdate();
        }
        catch(Exception e){
            throw new ServletException("Persist error", e);
        }
    }
    
    //Static method to get all schools
    
    public static String [] getAllSchools() throws ServletException{
        ArrayList<String> schools = new ArrayList<String>();
        try{
            Connection con = DBAccess.getConnection();
            String statement = "SELECT DISTINCT * FROM school;";
            PreparedStatement ps = con.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                School currentSchool = new School(rs);
                schools.add(currentSchool.getSchoolName());
            }
        }
        catch(Exception e){
            throw new ServletException("lookUp Problem ", e);
        }
        String [] finalSchools = new String[schools.size()];
        finalSchools = schools.toArray(finalSchools);
        return finalSchools;
    } 
    

    public static ArrayList returnAll() throws ServletException{
        ArrayList schoolList = new ArrayList();
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT * FROM school");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                School aSchool = new School(rs);
                schoolList.add(aSchool);
            }
        }
        catch(Exception e){
            throw new ServletException("returnAll Problem ", e);
        }
        return schoolList;
    }
    
    public static School getSchool(String name) throws ServletException{
        School school = null;
        try{
            Connection con = DBAccess.getConnection();
            String statement = "SELECT DISTINCT * FROM school WHERE schoolname = '" + name + "';";
            PreparedStatement ps = con.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                school = new School(rs);
            }
            
        }
        catch(Exception e){
            throw new ServletException("getSchool error", e);
        }
        return school;
    }
    
        public static int getSchools() throws ServletException{
        int noShcools = 0;
        
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT COUNT (*) FROM school");
               
            
            //Updates prepared statement with values
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               noShcools = rs.getInt("count");
            }
        }
        catch(Exception e){
            throw new ServletException("Count Error", e);
        }
        return noShcools;
    }
    
}