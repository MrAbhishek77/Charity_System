
package quadraticfunding;

import java.util.ArrayList;

public class QuadraticFund 
{
    double getMatchedAmount(ArrayList master,double donationamount,String charity,double matchingpoolamt)
    {  
        double matchedamount=0;
        double matamtbfdon=getMatchedAmountBFDonation(master,charity,matchingpoolamt);
        System.out.println("Matched amount for Charity "+charity+" before Donation is "+matamtbfdon);
        
        double maramtafdon=getMatchedAmountAFDonation(master,charity,matchingpoolamt,donationamount);
        System.out.println("Matched amount for Charity "+charity+" After Donation is "+maramtafdon);
        
           matchedamount=   maramtafdon- matamtbfdon;
        return matchedamount;
    }
    
    
    
    
    public double getMatchedAmountBFDonation(ArrayList master,String charity,double matchingpoolamt)
    {
          double totalqfamt=0;
         ArrayList expamt=new ArrayList();
        for (int i = 0; i < master.size(); i++)
        {
            ArrayList ntemp=new ArrayList();
         ArrayList temp=(ArrayList)master.get(i);
         String charityname=(String)temp.get(0);
         String samt=(String)temp.get(1);
         double totalamt=Double.parseDouble(samt);
         ArrayList nod=(ArrayList)temp.get(2);
//            System.out.println("charityname "+charityname);
//            System.out.println("totalamt "+totalamt);
//            System.out.println("nod "+nod);
                  
            
            double tempsum=0;
            for (int j = 0; j < nod.size(); j++) 
            {
                String tamt=(String)nod.get(j);
                double ida=Double.parseDouble(tamt);
                tempsum=tempsum+Math.sqrt(ida);
            }
            double finsum=Math.pow(tempsum, 2);
//            System.out.println("FinSum for charity is "+finsum);
            
            totalqfamt=totalqfamt+finsum;
            ntemp.add(charityname);
            ntemp.add(samt);
            ntemp.add(Double.toString(finsum));
            expamt.add(ntemp);
//            System.out.println(ntemp);
//            System.out.println("------------------------");
        }
        System.out.println("Total QF1 amount is "+totalqfamt);
//        ArrayList matchedamtlist=new ArrayList();
double matchedamt=0;
        for (int i = 0; i < expamt.size(); i++)
        {
           ArrayList temp=(ArrayList)expamt.get(i);
           String charityname=(String)temp.get(0);
           String tstr=(String)temp.get(2);
           double sum=Double.parseDouble(tstr);
           
           double famt=(matchingpoolamt*sum)/totalqfamt;
         
           
//           ArrayList ntemp=new ArrayList();
//           ntemp.add(charityname);
//           ntemp.add(Double.toString(famt));
           // System.out.println(ntemp);
           if(charity.equals(charityname))
           {
              matchedamt= famt;
           }
        }
      return matchedamt;
    }
    
    
    public double getMatchedAmountAFDonation(ArrayList master,String charity,double matchingpoolamt,double donationamount)
    {
          double totalqfamt=0;
         ArrayList expamt=new ArrayList();
        for (int i = 0; i < master.size(); i++)
        {
            ArrayList ntemp=new ArrayList();
         ArrayList temp=(ArrayList)master.get(i);
         String charityname=(String)temp.get(0);
         String samt=(String)temp.get(1);
         double totalamt=Double.parseDouble(samt);
         ArrayList nod=(ArrayList)temp.get(2);
//            System.out.println("charityname "+charityname);
//            System.out.println("totalamt "+totalamt);
//            System.out.println("nod "+nod);
            if(charityname.equals(charity))
           nod.add(Double.toString(donationamount));
            double tempsum=0;
            for (int j = 0; j < nod.size(); j++) 
            {
                String tamt=(String)nod.get(j);
                double ida=Double.parseDouble(tamt);
                tempsum=tempsum+Math.sqrt(ida);
            }
            double finsum=Math.pow(tempsum, 2);
//            System.out.println("FinSum for charity is "+finsum);
            
            totalqfamt=totalqfamt+finsum;
            ntemp.add(charityname);
            ntemp.add(samt);
            ntemp.add(Double.toString(finsum));
            expamt.add(ntemp);
            System.out.println("expamt: "+expamt);
//            System.out.println("------------------------");
        }
        System.out.println("Total QF2 amount is "+totalqfamt);
//        ArrayList matchedamtlist=new ArrayList();
double matchedamt=0.0;
        for (int i = 0; i < expamt.size(); i++)
        {
           ArrayList temp=(ArrayList)expamt.get(i);
           String charityname=(String)temp.get(0);
           String tstr=(String)temp.get(2);
           double sum=Double.parseDouble(tstr);
           
            System.out.println("sum: "+sum);
         
           double famt=(matchingpoolamt*sum)/totalqfamt;

           if(charity.equals(charityname))
           {
              matchedamt= famt;
           }
        }
      return matchedamt;
    }
}
