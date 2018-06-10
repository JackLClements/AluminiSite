/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package alumini;
import Utilities.DBAccess;
import javax.servlet.ServletException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Jack L. Clements, jack.clements@uea.ac.uk
 */
public class SiteUser {
    
    //fields
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String dOB;
    private String email;
    private String bio;
    private String img;
    private String location;
    private String gender;
    
    //Default Constructor
    SiteUser(){};
    
    //Value constructor for registration
    SiteUser(String username, String password, String firstName, String lastName, String dOB, String email){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dOB = dOB;
        this.email = email;
    }
    
    //Constructor for ResultSet data type
    SiteUser(ResultSet rs) throws SQLException{
        this.username = rs.getString("username");
        this.password = rs.getString("password");
        this.firstName = rs.getString("firstName");
        this.lastName = rs.getString("lastName");
        this.dOB = rs.getString("dOB");
        this.email = rs.getString("email");
        this.bio = rs.getString("bio");
        this.img = rs.getString("img");
        this.location = rs.getString("location");
        this.gender = rs.getString("gender");
    }
    
    //Constructor for full table
    SiteUser(String username, String password, String firstName, String lastName, String dOB, String email, String bio, String img, String location, String gender){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dOB = dOB;
        this.email = email;
        this.bio = bio;
        this.img = img;
        this.location = location;
        this.gender = gender;
    }
    
    //Getter methods
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getDOB(){
        return this.dOB;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getBio(){
        return this.bio;
    }
    
    public String getImg(){
        return this.img;
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public String getGender(){
        return this.gender;
    }
    
    //Setter Methods
    
    public void setUsername(String username){
        this.username = username; 
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setDOB(String dOB){
        this.dOB = dOB;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setBio(String bio){
        this.bio = bio;
    }
    
    public void setImg(String img){
        this.img = img;
    }
     
    public void setLocation(String location){
        this.location = location;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public int getNoOfMessages() throws ServletException{
        int noOfMessages = 0;
        
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT COUNT (*) FROM message WHERE fromuser=?");
               
            
            //Updates prepared statement with values
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               noOfMessages = rs.getInt("count");
            }
        }
        catch(Exception e){
            throw new ServletException("Count Error", e);
        }
        return noOfMessages;
    }
    
    public int getSentMessages() throws ServletException{
        int noOfMessages = 0;
        
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT COUNT (*) FROM message WHERE touser=?");
               
            
            //Updates prepared statement with values
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               noOfMessages = rs.getInt("count");
            }
        }
        catch(Exception e){
            throw new ServletException("Count Error", e);
        }
        return noOfMessages;
    }
    
    
    //Method that takes username, password as parameters, and checks if they exist via SQL
    public static SiteUser checkLogIn(String username1, String password1) throws ServletException{
    SiteUser loggedInUser = null; 
    try{
        Connection con = DBAccess.getConnection();
        String statement = "SELECT DISTINCT * FROM siteUser WHERE username = '" + username1 + "' AND password = '" + password1 +"';";
        PreparedStatement ps = con.prepareStatement(statement);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            loggedInUser = new SiteUser(rs);
        }
        
    }
    catch(Exception e){
        throw new ServletException("lookUp Problem ", e);
    }
    return loggedInUser;
    }
    
    public static SiteUser getUser(String username1) throws ServletException{
        SiteUser user = null;
        try{
            Connection con = DBAccess.getConnection();
            String statement = "SELECT DISTINCT * FROM siteUser WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(statement);
            ps.setString(1, username1);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            user = new SiteUser(rs);
             }
        }
        catch(Exception e){
            throw new ServletException("lookUp Problem ", e);
        }
        return user;
    }
    

    
    public void persist() throws ServletException{
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO siteUser(username, password, firstName, lastName, dOB, email) VALUES(?,?,?,?,?,?)");
               
            
            //Updates prepared statement with values
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, dOB);
            ps.setString(6, email);
            
            ps.executeUpdate();
        }
        catch(Exception e){
            throw new ServletException("Persist Problem ", e);
        }
    }
    

    
    public void editBio() throws ServletException{
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE siteUser SET bio = ?, img = ?, location = ?, gender = ? WHERE username = ?;");
            ps.setString(1, bio);
            ps.setString(2, img);
            ps.setString(3, location);
            ps.setString(4, gender);
            ps.setString(5, username);
            ps.executeUpdate();
        
        }
        catch(Exception e){
            throw new ServletException("Edit problem", e);
        }
    }
    
    public void editAccount() throws ServletException{
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE siteUser SET firstName = '"+ firstName +"', lastName = '"+ lastName +"', password = '"+ password +"', email = '"+ email +"' WHERE username = '"+ username +"';");
            ps.executeUpdate();
        }
        catch(Exception e){
            throw new ServletException("Edit problem", e);
        }
    }
    
     public static ArrayList<SiteUser> getAllUsers() throws ServletException{
        ArrayList<SiteUser> users = new ArrayList<SiteUser>();
        try{
            Connection con = DBAccess.getConnection();
            String statement = "SELECT DISTINCT * FROM siteUser;";
            PreparedStatement ps = con.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SiteUser currentUser = new SiteUser(rs);
                users.add(currentUser);
            }
        }
        catch(Exception e){
            throw new ServletException("lookUp Problem ", e);
        }
        return users;
    } 
     
     public static int getNumOfUsers() throws ServletException{
         int noOfUsers = 0;
         try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT COUNT (*) FROM siteUser;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                noOfUsers = rs.getInt("count");
            }
         }
         catch(Exception e){
             throw new ServletException("SQL error", e);
         }
         return noOfUsers;
     }
     
     
    
    
    
}
