package alumini;

import Utilities.DBAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sky13nmu
 */
public class NewsPosts {
    
    //Fields
    private String newsDate;
    private String newsAuthor;
    private String newsTitle;
    private String newsContent;
    
    
    //Constructors
    NewsPosts(){}
    NewsPosts(String newsAuthor, String newsTitle, 
            String newsContent){
        
        this.newsAuthor = newsAuthor;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }
    
    NewsPosts(ResultSet rs) throws SQLException{
        this.newsDate = rs.getString("newsDate");
        this.newsAuthor = rs.getString("newsAuthor");
        this.newsTitle = rs.getString("newsTitle");
        this.newsContent = rs.getString("newsContent");
    }
    
    //NewsDate getter and setter
    public String getNewsDate(){
        return newsDate;
    }
    
    public void setNewsDate(String newsDate){
        this.newsDate = newsDate;
    }
    
    
    //News Author getter and setter
    public String getNewsAuthor(){
        return newsAuthor;
    }
    
    public void setNewsAuthor(String newsAuthor){
        this.newsAuthor = newsAuthor;
    }
    
    
    //News Title getter and setter
    public String getNewsTitle(){
        return newsTitle;
    }
    
    public void setNewsTitle(String newsTitle){
        this.newsTitle = newsTitle;
    }
    
    
    //News Content getter and setter
    public String getNewsContent(){
        return newsContent;
    }
    
    public void setNewsContent(String newsContent){
        this.newsContent = newsContent;
    }
    
    //Persist
    public void persist() throws ServletException{
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO newsPosts VALUES (?,?,?,?)");
            
            //get current date
            Date date = new Date();
            StringBuilder string = new StringBuilder();
            string.append(date.getDate()).append("/");
            string.append(date.getMonth()).append("/");
            string.append(date.getYear() + 1900);
            
            ps.setString(1, string.toString());
            ps.setString(2, newsAuthor);
            ps.setString(3, newsTitle);
            ps.setString(4, newsContent);
            
            ps.executeUpdate();
        }
        catch(Exception e){
            throw new ServletException("Persist Error", e);
        }
    }
    
     public static ArrayList<NewsPosts> userNews() throws ServletException{
        ArrayList<NewsPosts> news = new ArrayList<NewsPosts>();
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT * FROM newsPosts");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                NewsPosts newNews = new NewsPosts(rs);
                news.add(newNews);
            }
        }
        catch(Exception e){
            throw new ServletException("Error fetching inbox", e);
        }
        return news;
    }
     
    public static NewsPosts getNewsPost(String title) throws ServletException{
        NewsPosts newPost = null;
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM newsPosts WHERE newsTitle = ?");
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){ 
                newPost = new NewsPosts(rs);
           }
        }
        catch(Exception e){
            throw new ServletException("Get error", e);
        }
        return newPost;
    }
    
}
