/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package donor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Innovatus
 */
public class DonorDBInformationInserter {
    
     public boolean insertDonorinfo(String name, String address, String mobile, String email, String pan, String uname, String pass)
    {
        boolean flag=true;
        
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st=conn.createStatement();
            
            String query="Insert into donorinfo values('"+name+"','"+address+"','"+mobile+"','"+email+"','"+pan+"','"+uname+"','"+pass+"')";
            
//            
            
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;
            
            st.close();
            conn.close();
            
        }
        
        catch(Exception e)
        {
            System.out.println("Exception in DonorDBInformationInserter Class is: "+e);
            flag=false;
        }
        
        
        
        
        return flag;
    }
    
    
}
