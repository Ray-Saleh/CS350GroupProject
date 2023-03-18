package edu.odu.cs.cs350.pne;

public class Section 
{
    int crn;
    int link;
    int enrollment;
    String course;
    int XLSTCap;

    public Section(){
        crn = 0;
        enrollment = 0;
        XLSTCap = 0;
    }

    public Object getcrn() {
        return crn;
    }
}