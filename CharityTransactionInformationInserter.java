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
public class CharityTransactionInformationInserter {
    
     public boolean insertCharityTransactioninfo(String name, String description, String amount, String paidto, String dtime, String blockkey)
    {
       
        boolean flag=true;
        
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st=conn.createStatement();
            
            String query="Insert into charityspentinfo values('"+name+"','"+description+"','"+amount+"','"+paidto+"','"+dtime+"','"+blockkey+"')";
            
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
            System.out.println("Exception in CharityTransactionInformationInserter Class is: "+e);
            flag=false;
        }
        
        
        return flag;
    }
    
      public boolean insertTerminalBlockinfo(String blockkey)
    {
       
        boolean flag=true;
        
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st=conn.createStatement();
            
            String query="Insert into terminalblockkey values('"+blockkey+"')";
            
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
            System.out.println("Exception in CharityTransactionInformationInserter Class in insertTerminalBlockinfo is: "+e);
            flag=false;
        }
        
        
        return flag;
    }
    
    
}
