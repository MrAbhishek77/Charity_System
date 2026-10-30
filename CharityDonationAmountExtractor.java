/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donor;

import charitysystem.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class CharityDonationAmountExtractor {
    
         
        public ArrayList getCharityDonationInfo(String cname)
    {

       ArrayList charityfundinfo=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
            

            String query="Select *from charityfundinfo where Charity_Name='"+cname+"'";

            ResultSet rs1=st1.executeQuery(query);
            

             
             while(rs1.next())
            {

                //Name, Age, Sex, Qualification, Worth, Profession, Symbol_Name, Symbol_Image, Party_Name
             ArrayList temp=new ArrayList();   
             String indidonat=rs1.getString(2); 
             String chname=rs1.getString(3);
             String mpdonation=rs1.getString(5);
             
                         
              temp.add(chname); 
              temp.add(indidonat);
              temp.add(mpdonation);
              
              if(temp.size()!=0)
              {
                 charityfundinfo.add(temp); 
              }
                  
              
                          
              
            }
             
            st1.close();
            conn.close();


        }

        catch(Exception e)
        {
            System.out.println("Exception in CharityDonationAmountExtractor Class is: "+e);

        }

       return charityfundinfo;
    }

      
}
