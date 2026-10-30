/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charitysystem;

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
public class CharityTransactionInformationExtractor {
    
         
        public ArrayList getCharityTransactionInfo(String chname)
    {

       ArrayList charitytraninfo=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
            

            String query="Select *from charityspentinfo where Charity_Name='"+chname+"'";

            ResultSet rs1=st1.executeQuery(query);
            
             while(rs1.next())
            {

             ArrayList temp=new ArrayList();
             
             String cname=rs1.getString(1);
             String description=rs1.getString(2);
             String amount=rs1.getString(3);
             String paidto=rs1.getString(4);
             String dtime=rs1.getString(5);
             String blockkey=rs1.getString(6);
             
            
              temp.add(cname); 
              temp.add(description);
              temp.add(amount);
              temp.add(paidto);
              temp.add(dtime);
              temp.add(blockkey);
             
              if(temp.size()!=0)
              charitytraninfo.add(temp);
             
            }
             
             
            st1.close();
            conn.close();


        }

        catch(Exception e)
        {
            System.out.println("Exception in CharityTransactionInformationExtractor Class is: "+e);

        }

       return charitytraninfo;
    }

      
      
    
}
