/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package charitysystem;
import java.sql.*;

/**
 *
 * @author Innovatus
 */
public class LoginChecker {


    public boolean checkCharityLogin(String uid, String pass)
    {
        boolean flag=true;

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st=conn.createStatement();

            String query="Select * from charityinfo where CharityUsername='"+uid+"'and CharityPassword='"+pass+"'";

            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
             flag=true;   
            }
            
            else
            {
                flag=false;
            }
          

        }

        catch(Exception e)
        {
            System.out.println("Exception in Login Checker Class is: "+e);
            flag=false;
        }




        return flag;
    }

     public boolean checkDonorLogin(String uid, String pass)
    {
        boolean flag=true;

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st=conn.createStatement();

            String query="Select * from donorinfo where Donor_Username='"+uid+"'and Donor_Password='"+pass+"'";

            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
             flag=true;   
            }
            
            else
            {
                flag=false;
            }
          

        }

        catch(Exception e)
        {
            System.out.println("Exception in Login Checker Class is: "+e);
            flag=false;
        }




        return flag;
    }

}
