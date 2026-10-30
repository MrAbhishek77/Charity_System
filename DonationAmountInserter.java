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
public class DonationAmountInserter {
    
     public boolean insertMatchingPartnersDonationinfo(String dname, String amount, String pname, String accountno, String mdamount)
    {
        boolean flag=true;
        
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st=conn.createStatement();
            
            String query="Insert into charityfundinfo values('"+dname+"','"+amount+"','"+pname+"','"+accountno+"','"+mdamount+"')";
            
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
            System.out.println("Exception in DonationAmountInserter Class is: "+e);
            flag=false;
        }
        
        
        
        
        return flag;
    }
     
     public boolean insertCharityGrantinfo(String cname, String amount)
    {
        boolean flag=true;
        
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st=conn.createStatement();
            
            String query="Insert into charitygrantinfo values('"+cname+"','"+amount+"')";
            
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
            System.out.println("Exception in DonationAmountInserter Class is: "+e);
            flag=false;
        }
        
        
        
        
        return flag;
    }
     
     
    
    
    
}
