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
public class DonationInformationExtractor {

      public ArrayList getAllTransactions(String userid)
    {

       ArrayList transactions=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
            

            String query="Select *from charityfundinfo where Donor_ID='"+userid+"'";

            ResultSet rs1=st1.executeQuery(query);
            

             while(rs1.next())
            {

              ArrayList temp=new ArrayList();  
              String dname=rs1.getString(1);
              String amount=rs1.getString(2);
              String cname=rs1.getString(3);
              
              temp.add(dname);
              temp.add(amount);
              temp.add(cname);
              
              transactions.add(temp);
               
              
            }
             
            st1.close();
            conn.close();


        }

        catch(Exception e)
        {
            System.out.println("Exception in DonationInformationExtractor Class is: "+e);

        }

       return transactions;
    }
    
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
            System.out.println("Exception in DonationInformationExtractor Class is: "+e);

        }

       return cgrant;
    }
    
       public ArrayList getDonorCharityTransactions(String userid)
    {

       ArrayList charatiesname=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
            

            String query="Select *from charityfundinfo where Donor_ID='"+userid+"'";

            ResultSet rs1=st1.executeQuery(query);
            

             while(rs1.next())
            {

              String chname=rs1.getString(3);
              charatiesname.add(chname);
                 
            }
             
            st1.close();
            conn.close();


        }

        catch(Exception e)
        {
            System.out.println("Exception in DonationInformationExtractor Class is: "+e);

        }

       return charatiesname;
    }
    
       
}


     
      