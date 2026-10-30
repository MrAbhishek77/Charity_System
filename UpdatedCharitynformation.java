/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package charitysystem;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Innovatus
 */
public class UpdatedCharitynformation {
    
     public boolean updateCharityinfo(String name, String rno, String address, String contactno, String email, String descrip, String category,String branchno, String uname, byte f1[],FileInputStream fis1, String pass)
    {
        boolean flag=true;
        
        try
        {
            
            System.out.println("charity registraion number: "+rno);
            System.out.println("charity address number: "+address);
            System.out.println("charity phone number: "+contactno);
            
            rno=rno.trim();
            address=address.trim();
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            PreparedStatement ps=conn.prepareStatement("Update charityinfo set "
                       + " CharityName= ?,CharityRegistrationNumber = ?,CharityAddress = ?,CharityContactNumbers= ?,CharityEmail= ?,CharityDescription= ?,"
                       + " CharityCategory= ?,CharityBranches= ?,CharityPassword = ?,CharityLogo=?, where CharityUsername = ?"); 
            
          
//            "Update candidateinfo set "
//                       + " Age = ?,Sex = ?,Qualification = ? , Worth = ? , Profession= ? ,"
//                       + "Symbol_Name = ?,Symbol_Image = ? ,Party_Name = ? where Name = ? "
                
              
               ps.setString(1,name);  
               ps.setString(2,rno);  
               ps.setString(3,address);  
               ps.setString(4,contactno);                
               ps.setString(5,email);  
               ps.setString(6,descrip);  
               ps.setString(7,category);  
               ps.setString(8,branchno);
               ps.setString(9,uname);
               ps.setString(10,pass);
               
               
             
    
               
         if(fis1==null)
             {
                 if(f1.length>0)
                 {
                     
                     InputStream is = null;
                     is = new ByteArrayInputStream(f1);
                     ps.setBinaryStream(11, is, is.available());
                     System.out.println("Old image1 inserted ");
                 }
                
                
             }
             else
             {
               ps.setBinaryStream(11,fis1,fis1.available());
               
                      System.out.println("New image1 inserted");           
             }
             
             
            
            
           
             int x=ps.executeUpdate();
            
            if(x>0)
                flag=true;
            else
                flag=false;
          
            ps.close();
            
        }
        
        catch(Exception e)
        {
            System.out.println("Exception in UpdatedCharityInformation Class is: "+e);
            flag=false;
        }
        
        
//        
//        
        return flag;
    }
    
    
}
