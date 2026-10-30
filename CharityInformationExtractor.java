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
public class CharityInformationExtractor {
    
         
        public ArrayList getCharityInfo(String cname)
    {

       ArrayList charityinfo=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
            



            String query="Select *from charityinfo where CharityName='"+cname+"'";

            ResultSet rs1=st1.executeQuery(query);
            

            
             
             while(rs1.next())
            {

                //Name, Age, Sex, Qualification, Worth, Profession, Symbol_Name, Symbol_Image, Party_Name
             String chname=rs1.getString(1);
             String chrnum=rs1.getString(2);
             String add=rs1.getString(3);
             String cnum=rs1.getString(4);
             String email=rs1.getString(5);
             String desrci=rs1.getString(6);
             String categ=rs1.getString(7);
            
             
            
             
            
              charityinfo.add(chname); 
              charityinfo.add(chrnum);
              charityinfo.add(add);
              charityinfo.add(cnum);
              charityinfo.add(email);
              charityinfo.add(desrci);
              charityinfo.add(categ);
             
              
             
             
              Blob b1 = rs1.getBlob("CharityLogo");
              byte barr1[] = b1.getBytes(1, (int) b1.length());
              charityinfo.add(barr1);
              
             
            }
             
            st1.close();


        }

        catch(Exception e)
        {
            System.out.println("Exception in CharityInformationExtractor Class is: "+e);

        }

       return charityinfo;
    }

      
        public ArrayList getCharityNames()
    {

       ArrayList charitynames=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/charitygrant","root","root");
            Statement st1=conn.createStatement();
            



            String query="Select *from charityinfo";

            ResultSet rs1=st1.executeQuery(query);
            

            
             
             while(rs1.next())
            {

             String name=rs1.getString(1);
              charitynames.add(name); 
              
            }
             
            st1.close();


        }

        catch(Exception e)
        {
            System.out.println("Exception in CharityInformationExtractor Class is: "+e);

        }

       return charitynames;
    }
    
    
    
}
