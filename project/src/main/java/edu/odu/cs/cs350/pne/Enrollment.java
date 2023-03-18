package edu.odu.cs.cs350.pne;
public class Enrollment {
    int XLSTCap;
    int ENR;
    int LINK;
    int XLSTGroup;
    int OVERALLCAP;
    int XLSTENR;
    Course course;

    public Enrollment(){
        XLSTCap=0;
        ENR=0;
        LINK=0;
        XLSTGroup=0;
        OVERALLCAP=0;
        XLSTENR=0;
        course = new Course();
    }

    public int getXLSTCap() {
        return XLSTCap;
    }
    public int getENR() {
        return ENR;
    }
    public int getLINK(){
        return LINK;
    }
    public int getXLSTGroup(){
        return XLSTGroup;
    }
    public int getOVERALLCAP(){
        return OVERALLCAP;
    }
    public int getXLSTENR() {
        return XLSTENR;
    }
    public Course getCourse(){
        return course;
    }



}
