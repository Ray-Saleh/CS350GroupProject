package edu.odu.cs.cs350.pne;
import java.util.ArrayList;

public class Section { 
    private String Link;
    ArrayList<Offering> offerringList;

    public Section() {
        this.offerringList = new ArrayList<Offering>();
        this.Link= "";
    }

    public Section(ArrayList<Offering> oL, String l) {
        this.offerringList = oL;
        this.Link = l;
    }

    // setters and getters
    public void setLINK(String inLink)
    {
        Link = inLink;
    }

    public String getLink()
    {
        return Link;
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

    public int getTE()
    {
        int total=0;
        for(int i =0 ; i<offerringList.size(); i++)
        {
          total = total+  offerringList.get(i).getEnrollment().getENR();
        }
        return total;
    }
    
    public int getOV() 
    {
        int total=0;
        for(int i =0 ; i<offerringList.size(); i++)
        {
          total = total+  offerringList.get(i).getEnrollment().getOVERALLCAP();
        }
        return total;
    }
}
