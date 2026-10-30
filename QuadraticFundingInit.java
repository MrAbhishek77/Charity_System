/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadraticfunding;

import donor.CharityDonationAmountExtractor;
import donor.MatchingPartnersInformationExtractor;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author 1450
 */
public class QuadraticFundingInit {
    
    public ArrayList getQuadraticFunding(String cname1, double donationamout)
    {
        
        ArrayList charitylistinfo=new MatchingPartnersInformationExtractor().getCharityDonationInfo();
          double matchingpoolamt=0.0;
          
          String dname="";
          String pname="";
        
        String chname="";
        for (int i = 0; i <charitylistinfo.size(); i++)
        {
            ArrayList row=(ArrayList) charitylistinfo.get(i);
            String clist=(String) row.get(2);
            String st []=clist.split(",");
            
            for (int j = 0; j <st.length; j++) 
            {
                String cname2=st[j];
                cname2=cname2.trim();
                cname1=cname1.trim();
                if(cname2.equals(cname1))
            {
                matchingpoolamt=Double.parseDouble((String) row.get(3));
                chname=clist;
                dname=(String) row.get(0);
                pname=(String) row.get(1);
            }
                
            }
            
        }
        
        String chnames []=chname.split(",");
        
        ArrayList quadlist=new ArrayList();
        
        for (int i = 0; i <chnames.length; i++) 
        {
           ArrayList temp=new ArrayList();
           ArrayList indivdon=new ArrayList();
           String chname1=chnames[i];
           ArrayList charityfundinfo= new CharityDonationAmountExtractor().getCharityDonationInfo(chname1);
           
           double totalamount=0.0;
           
           if(charityfundinfo.size()==0)
           {
               totalamount=0.0;
             //  indivdon.add("0.0");
           }
           else
           {
                for (int j = 0; j <charityfundinfo.size(); j++) 
            {
                ArrayList temp1=(ArrayList) charityfundinfo.get(j);
                String inddona=(String) temp1.get(1);
                String mpdona=(String) temp1.get(2);
                
                totalamount=totalamount+Double.parseDouble(inddona)+Double.parseDouble(mpdona);
                indivdon.add(inddona);
            }
               
           }
           
           
           
           
           temp.add(chname1);
           temp.add(Double.toString(totalamount));
           temp.add(indivdon);
           quadlist.add(temp);
        }
        
        
        
        System.out.println("Quadratic List: "+quadlist);
        System.out.println("Matching Partner Donation Amount: "+matchingpoolamt);
        System.out.println("Charity Name: "+cname1);
        
        boolean flag=false;
        for (int i = 0; i <quadlist.size(); i++) 
        {
            ArrayList row=(ArrayList) quadlist.get(i);
            String chname1=(String) row.get(0);
            
            if(chname1.equals(cname1))
            {
              ArrayList nod=(ArrayList) row.get(2);
            
            if(nod.size()>=5)
            {
               flag=true;
               break;
            }  
            }
            
        }
        double matchedamount=0.0;
        if(flag)
        {
       
        matchedamount=new QuadraticFund().getMatchedAmount(quadlist, donationamout, cname1,matchingpoolamt);
        matchedamount=Double.parseDouble(new DecimalFormat("##.##").format(matchedamount));
        System.out.println("Matched Amount for donation amount "+Double.toString(donationamout)+ " is "+matchedamount);
        }
        
      
        ArrayList result=new ArrayList();
        
        result.add(Double.toString(matchedamount));
        result.add(Double.toString(matchingpoolamt));
        result.add(dname);
        result.add(pname);
        
        
        return result;
        
    }
    
}
