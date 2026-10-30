/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package donor;
import java.sql.*;
import static jdk.internal.org.objectweb.asm.commons.GeneratorAdapter.AND;

/**
 *
 * @author Innovatus
 */
public class MatchingPartnerInformationUpdate {
    
    
    public boolean updateMatchingPartnerInfo(String name, String pname,String charities,String amount)
    {
        boolean flag=true;
     
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st=conn.createStatement();
            
            String query="Update matchingpartnerinfo set Charities_Name='"+charities+"', Amount='"+amount+"' where Donar_Name='"+name+"' and Pool_Name='"+pname+"'";
 
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
            System.out.println("Exception in MatchingPartnerInformationUpdate Class is: "+e);
            flag=false;
        }
       
        return flag;
    }
    
    public boolean updateMatchingPartnerDonationamount(String name, String pname,String amount)
    {
        boolean flag=true;
     
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st=conn.createStatement();
            
            String query="Update matchingpartnerinfo set Amount='"+amount+"' where Donar_Name='"+name+"' and Pool_Name='"+pname+"'";
 
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
            System.out.println("Exception in MatchingPartnerInformationUpdate Class is: "+e);
            flag=false;
        }
       
        return flag;
    }
    
}
