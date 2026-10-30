/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package donor;
import java.sql.*;

/**
 *
 * @author Innovatus
 */
public class DonorInformationUpdate {
    
    
    public boolean updateDonorInfo(String name, String add,String mob,String email, String pancard, String username, String pass)
    {
        boolean flag=true;
        
        
        
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st=conn.createStatement();
            
            String query="Update donorinfo set Donor_Name='"+name+"',Donor_Address='"+add+"',Donor_Mobile='"+mob+"',Donor_Email='"+email+"',Donor_Pan_Card='"+pancard+"',Donor_Password='"+pass+"' where Donor_Username='"+username+"'";


            
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
            System.out.println("Exception in DonorInformationUpdate Class is: "+e);
            flag=false;
        }
        
        
        
        
        return flag;
    }
    
}
