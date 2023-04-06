package edu.odu.cs.cs350.pne;
import java.util.ArrayList;

public class Course {
    private String subject;
    // CRSE = Course Number
    private String CRSE;
    
    ArrayList<Offering> offerringList;
    public Course() {
        this.subject = "null";
        this.CRSE =" 000";
        this.offerringList = new ArrayList<Offering>();
      }

    public Course(String sub, String inCRSE, ArrayList<Offering> inOfferringList) {
        this.offerringList = inOfferringList;
        this.subject = sub;
        this.CRSE = inCRSE;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getCRSE() {
        return this.CRSE;
    }

    public void setSubject(String subj) {
        subject = subj;
    }

    public void setCRSE(String inCRSE) {
        CRSE = inCRSE;
    }

    public void addOffering(Offering addOffering){
        offerringList.add(addOffering);
    }
    public Offering getOffering(int inCRN){
        for(int i= 0; i<offerringList.size(); i ++)
        {
           if( offerringList.get(i).getCRN() == inCRN)
           {
            return offerringList.get(i);
           }
        }   
        return null;    
    }
    
    public ArrayList<Offering> getOfferingList(){
        return offerringList;
    }

    public int getTotalEnrolled(){
        int total=0;
        for(int i =0 ; i<offerringList.size(); i++)
        {
          total = total+  offerringList.get(i).getEnrollment().getENR();
        }
        return total;
    }
    public int getOverallCap()
    {
        int total=0;
        for(int i =0 ; i<offerringList.size(); i++)
        {
          total = total+  offerringList.get(i).getEnrollment().getOVERALLCAP();
        }
        return total;
    }

}
