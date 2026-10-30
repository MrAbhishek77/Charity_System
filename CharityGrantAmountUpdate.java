/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package charitysystem;
import donor.*;
import java.sql.*;

/**
 *
 * @author Innovatus
 */
public class CharityGrantAmountUpdate {
    
    
    public boolean updateDonationAmount(String name, String grantamount)
    {
        boolean flag=true;
        
        
        
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st=conn.createStatement();
            
            String query="Update charitygrantinfo set Charity_Grant='"+grantamount+"' where Charity_Name='"+name+"'";


            
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
            System.out.println("Exception in CharityGrantAmountUpdate Class is: "+e);
            flag=false;
        }
        
        
        
        
        return flag;
    }
    
}
