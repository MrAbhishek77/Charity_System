/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package charitysystem;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Innovatus
 */
public class CharityInformationDBInserter {
    
     public boolean insertCharityinfo(String name, String rno, String add, String contactno, String email, String descrip, String category,String branchno, String uname, String pass, String path1)
    {
        boolean flag=true;
        
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
           
            
            PreparedStatement ps=conn.prepareStatement("insert into charityinfo values(?,?,?,?,?,?,?,?,?,?,?)");  
            
               ps.setString(1,name);  
               ps.setString(2,rno);  
               ps.setString(3,add);  
               ps.setString(4,contactno);  
               ps.setString(5,email);  
               
               ps.setString(6,descrip);  
               ps.setString(7,category);
               ps.setString(8,branchno);
               ps.setString(9,uname);
               ps.setString(10,pass);
                
               
               
          if(path1==null)
          {
               String str =name;
              byte[] content = str.getBytes();
              Blob blob = ps.getConnection().createBlob();
              blob.setBytes(1, content);
              ps.setBlob(11, blob);
          }
          else
          {
              FileInputStream fis=new FileInputStream(path1);
               ps.setBinaryStream(11,fis,fis.available());
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
            System.out.println("Exception in CharityInformationDBInserter Class is: "+e);
            flag=false;
        }
        
        
        
        
        return flag;
    }
    
    
}
