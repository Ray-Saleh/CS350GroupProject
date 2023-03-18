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

    public Enrollment(int inXLSTCap, int inENR, int inLINK, int inXLSTGroup, int inOVERALLCAP, int inXLSTENR, Course incourse){
        XLSTCap=inXLSTCap;
        ENR=inENR;
        LINK=inLINK;
        XLSTGroup=inXLSTGroup;
        OVERALLCAP=inOVERALLCAP;
        XLSTENR=inXLSTENR;
        course = incourse;
    }
    ///Accesors 
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
    ///Mutators
    public void setXLSTCap(int inXLSTCap) {
        XLSTCap = inXLSTCap;
    }
    public void setENR(int inENR) {
        ENR = inENR;
    }
    public void setLINK(int inLINK){
       LINK = inLINK;
    }
    public void setXLSTGroup(int inXLSTGroup){
       XLSTGroup = inXLSTGroup;
    }
    public void setOVERALLCAP(int inOVERALLCAP){
        OVERALLCAP = inOVERALLCAP;
    }
    public void setXLSTENR(int inXLSTENR) {
       XLSTENR = inXLSTENR;
    }
    public void setCourse(Course inCourse){
        course = inCourse;
    }

}
