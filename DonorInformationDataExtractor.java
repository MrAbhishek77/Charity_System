package donor;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class DonorInformationDataExtractor {

       
       public ArrayList getDonorData(String usid)
    {

       ArrayList donorinfo=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
            



            String query="Select *from donorinfo where Donor_Username='"+usid+"'";

            ResultSet rs1=st1.executeQuery(query);
            

            
             if(rs1.next())
            {


             String name=rs1.getString(1);
             String add=rs1.getString(2);
             String mob=rs1.getString(3);
             String email=rs1.getString(4);
             String pan=rs1.getString(5);
             String uid=rs1.getString(6);
             String pass=rs1.getString(7);
           
            
             
    
              donorinfo.add(name);
              donorinfo.add(add);
              donorinfo.add(mob);
              donorinfo.add(email);
              donorinfo.add(pan);
              donorinfo.add(uid);
              donorinfo.add(pass);
              
              


            }
             
             st1.close();
             conn.close();

        }

        catch(Exception e)
        {
            System.out.println("Exception in DonorInformationDataExtractor Class is: "+e);

        }

       return donorinfo;
    }

      
}


     
      