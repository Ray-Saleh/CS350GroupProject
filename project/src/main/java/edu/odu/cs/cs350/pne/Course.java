package edu.odu.cs.cs350.pne;

import java.util.ArrayList;

public class Course {
    private String subject;
    // CRSE = Course Number
    private String CRSE;

    ArrayList<Section> sectionList;

    // constructor
    public Course() {
        this.subject = "null";
        this.CRSE = " 000";
        this.sectionList = new ArrayList<Section>();
    }

    // copy constructor
    public Course(String sub, String inCRSE, ArrayList<Section> inSectionList) {
        this.sectionList = inSectionList;
        this.subject = sub;
        this.CRSE = inCRSE;
    }

    // returns the subject
    public String getSubject() {
        return this.subject;
    }

    // gets course
    public String getCRSE() {
        return this.CRSE;
    }

    // sets subject
    public void setSubject(String subj) {
        subject = subj;
    }

    // sets crse name
    public void setCRSE(String inCRSE) {
        CRSE = inCRSE;
    }

    // adds section to the arraylist
    public void addSection(Section addSection) {
        sectionList.add(addSection);
    }

    // gets all the sections
    public Section getSection(String inCRSE) {

        for (int i = 0; i < sectionList.size(); i++) {
            if (sectionList.get(i).getLink().equals(inCRSE)) {
                return sectionList.get(i);
            }
        }
        return null;
    }

    // returns the arraylist of sections
    public ArrayList<Section> getSectionList() {

        return sectionList;
    }

    // returns overallcap of classes
    public int getOverallCap() {

        return sectionList.get(0).getOV();

    }

    // returns total enrolled
    public int getTotalEnrolled() {
        return sectionList.get(0).getTE();
    }
    public String getCourse(){
        return this.subject+this.CRSE;
    }

}
