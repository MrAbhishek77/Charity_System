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
public class MatchingPartnersInformationExtractor {

      public ArrayList getPoolNames(String userid)
    {

       ArrayList poolnames=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
            



            String query="Select *from matchingpartnerinfo where Donar_Name='"+userid+"'";

            ResultSet rs1=st1.executeQuery(query);
            

            
             
             while(rs1.next())
            {

             String pname=rs1.getString(2);
              poolnames.add(pname); 
              
            }
             
            st1.close();
            conn.close();


        }

        catch(Exception e)
        {
            System.out.println("Exception in MatchingPartnersInformationExtractor Class is: "+e);

        }

       return poolnames;
    }
    
      public ArrayList getCharityNames()
    {

       ArrayList charitynames=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
            

            String query="Select *from matchingpartnerinfo";

            ResultSet rs1=st1.executeQuery(query);
            

             while(rs1.next())
            {

             String cname=rs1.getString(3);
              charitynames.add(cname); 
              
            }
             
            st1.close();
            conn.close();


        }

        catch(Exception e)
        {
            System.out.println("Exception in MatchingPartnersInformationExtractor Class is: "+e);

        }

       return charitynames;
    }
    
       
       public ArrayList getMatchingPartnerData(String pname)
    {

       ArrayList mpartnerinfo=new ArrayList();

       
        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
    
            String query="Select *from matchingpartnerinfo where Pool_Name='"+pname+"'";

            ResultSet rs1=st1.executeQuery(query);
    
            
             if(rs1.next())
            {


             String pnames=rs1.getString(2);
             String charities=rs1.getString(3);
             String amount=rs1.getString(4);
          
    
              mpartnerinfo.add(pnames);
              mpartnerinfo.add(charities);
              mpartnerinfo.add(amount);
            
            }
             
             st1.close();
             conn.close();

        }

        catch(Exception e)
        {
            System.out.println("Exception in MatchingPartnersInformationExtractor Class is: "+e);

        }

       return mpartnerinfo;
    }
       
        public String getCharitiesName(String pname)
    {

      String charities="";

       
        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
    
            String query="Select *from matchingpartnerinfo where Pool_Name='"+pname+"'";

            ResultSet rs1=st1.executeQuery(query);
    
            
             if(rs1.next())
            {


             
             charities=rs1.getString(3);
           
          
    
            
            
            }
             
             st1.close();
             conn.close();

        }

        catch(Exception e)
        {
            System.out.println("Exception in MatchingPartnersInformationExtractor Class is: "+e);

        }

       return charities;
    }
        
          public ArrayList getCharityDonationInfo()
    {

       ArrayList charitydoninfo=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
            

            String query="Select *from matchingpartnerinfo";

            ResultSet rs1=st1.executeQuery(query);
            
             while(rs1.next())
            {
             ArrayList temp=new ArrayList();
             
             String dname=rs1.getString(1);
             String pname=rs1.getString(2);
             String cname=rs1.getString(3);
             String amount=rs1.getString(4);
             
             temp.add(dname);
             temp.add(pname);
             temp.add(cname);
             temp.add(amount);
             charitydoninfo.add(temp); 
              
            }
             
            st1.close();
            conn.close();


        }

        catch(Exception e)
        {
            System.out.println("Exception in MatchingPartnersInformationExtractor Class is: "+e);

        }

       return charitydoninfo;
    }

          
          public ArrayList getCharitiesNames(String userid)
    {

        ArrayList chnames=new ArrayList();  
       
        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
    
            String query="Select *from matchingpartnerinfo where Donar_Name='"+userid+"'";

            ResultSet rs1=st1.executeQuery(query);
    
            
             while(rs1.next())
            {

             String charities=rs1.getString(3);             
             chnames.add(charities);
          
            }
             
             st1.close();
             conn.close();

        }

        catch(Exception e)
        {
            System.out.println("Exception in MatchingPartnersInformationExtractor Class is: "+e);

        }

       return chnames;
    }
      
}


     
      