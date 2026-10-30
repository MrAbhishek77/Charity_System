package charitysystem;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import donor.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class CharityGrantExtractor {

     
    
      public String getCharityTransactions(String cname)
    {

       String cgrant="";

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
            

            String query="Select *from charitygrantinfo where Charity_Name='"+cname+"'";

            ResultSet rs1=st1.executeQuery(query);
            

             if(rs1.next())
            {

              cgrant=rs1.getString(2);
                 
            }
             
            st1.close();
            conn.close();


        }

        catch(Exception e)
        {
            System.out.println("Exception in CharityGrantExtractor Class is: "+e);

        }

        if(cgrant.isEmpty())
        {
            cgrant="0.0";
        }
       return cgrant;
    }
    
       
}


     
      