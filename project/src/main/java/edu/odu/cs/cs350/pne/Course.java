package edu.odu.cs.cs350.pne;
import java.util.ArrayList;

public class Course {
    private String subject;
    // CRSE = Course Number
    private String CRSE;
    
    ArrayList<Section> sectionList;
    public Course() {
        this.subject = "null";
        this.CRSE =" 000";
        this.sectionList = new ArrayList<Section>();
      }

    public Course(String sub, String inCRSE, ArrayList<Section> inSectionList) {
        this.sectionList = inSectionList;
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

    public void addSection(Section addSection){
        sectionList.add(addSection);
    }
    public Section getSection(String inCRSE){
        
   
        for(int i= 0; i<sectionList.size(); i ++)
        {
           if( sectionList.get(i).getLink().equals(inCRSE))
           {
            return sectionList.get(i);
           }
        }
        return null;
    }
    public ArrayList<Section> getSectionList(){
       
        return sectionList;
    }

    //TODO ensure that main class represents overall enrollment and cap
    public int getOverallCap(){
        
        return sectionList.get(0).getOV();

    }
    
    public int getTotalEnrolled(){
        return sectionList.get(0).getTE();
    }
    public String getCourse(){
        return this.subject+this.CRSE;
    }

}
