package alumini;

import Utilities.DBAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;

/**
 *
 * @author sky13nmu
 */
public class Message {
    
    //Fields
    private int messageID;
    private boolean messageRead;
    private String fromUser;
    private String toUser;
    private String subject;
    private String message;
    private String date;
    
    //Constructors
    public Message(){}
    public Message(String fromUser, String toUser, String subject, String message){
        
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.subject = subject;
        this.message = message;
        this.messageRead = false;
        
    }
    
    public Message(ResultSet rs) throws SQLException{
        this.messageID = rs.getInt("messageID");
        this.messageRead = rs.getBoolean("messageRead");
        this.fromUser = rs.getString("fromUser");
        this.toUser = rs.getString("toUser");
        this.subject = rs.getString("subject");
        this.message = rs.getString("message");
        this.date = rs.getString("date");
    }
    
    //Message getter/setter
    public int getMessageID(){
        return messageID;
    }
    
    public void setMessageID(int messageID){
        this.messageID = messageID;
    }
    
    //MessageRead getter/setter
    public boolean getMessageRead(){
        return messageRead;
    }
    
    public void setMessageRead(boolean messageRead){
        this.messageRead = messageRead;
    }
    
    //From User getter and setter
    public String getFromUser(){
        return fromUser;
    }
    
    public void setFromUser(String fromUser){
        this.fromUser = fromUser;
    }
    
    
    //To User getter and setter
    public String getToUser(){
        return toUser;
    }
    
    public void setToUser(String toUser){
        this.toUser = toUser;
    }
    
    //Subject getter and setter
    public String getSubject(){
        return subject;
    }
    
    public void setSubject(String subject){
        this.subject = subject;
    }
    
    
    //Message getter and setter
    public String getMessage(){
        return message;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    //Date getter and setter
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    //Persist
        public void persist() throws ServletException{
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO message(messageRead, fromUser, toUser, subject, message, date) VALUES(?,?,?,?,?,?)");
               
            
            //Updates prepared statement with values
            ps.setBoolean(1, messageRead);
            ps.setString(2, fromUser);
            ps.setString(3, toUser);
            ps.setString(4, subject);
            ps.setString(5, message);
            Date date = new Date();
            StringBuilder string = new StringBuilder();
            string.append(date.getDate()).append("/");
            string.append(date.getMonth()).append("/");
            string.append(date.getYear() + 1900);
            ps.setString(6, string.toString());
            
            ps.executeUpdate();
        }
        catch(Exception e){
            throw new ServletException("Persist Problem ", e);
        }
    }
        
    public void delete() throws ServletException{
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM message WHERE messageID = ?;");
            
            //Update ps
            ps.setInt(1, messageID);
            
            ps.executeUpdate();
        }
        catch(Exception e){
            throw new ServletException("Deletion error", e);
        }
    }    
    
    public static void isRead(int ID) throws ServletException{
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps2 = con.prepareStatement("UPDATE message SET messageRead = ? WHERE messageID = ?");
            ps2.setBoolean(1, true);
            ps2.setInt(2, ID);
            ps2.executeUpdate();
        }
        catch(Exception e){
            throw new ServletException("Update exception", e);
        }
    }
    
    //Mutator methods
    public static ArrayList<Message> userInbox(String user) throws ServletException{
        ArrayList<Message> messages = new ArrayList<Message>();
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT * FROM message WHERE toUser = ?");
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Message msg = new Message(rs);
                messages.add(msg);
            }
        }
        catch(Exception e){
            throw new ServletException("Error fetching inbox", e);
        }
        return messages;
    }
    
    //Gets specific message
    public static Message getMessage(int ID) throws ServletException{
        Message newMsg = null;
        try{
            Connection con = DBAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM message WHERE messageID = ?");
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();

            
            while(rs.next()){ 
                newMsg = new Message(rs);
           }
        }
        catch(Exception e){
            throw new ServletException("Error reading message data");
        }
        return newMsg;
    }    
}
