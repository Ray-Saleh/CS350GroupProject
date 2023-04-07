package edu.odu.cs.cs350.pne;

public class Enrollment {

    //Cross list cap: Maximum number of students that can enroll in this section
    int XLSTCap;
    //Number of students enrolled in this section
    int ENR;
    //Used to associate labs with the lecture. All link codes consist of an upper-case char and a single digit int
    //String LINK;
    //Cross list cap: IDs which sections of a course belong to a single offering. (Array of Courses that match)
    String XLSTGroup;
    //The maximum number of students that can enroll in the offering to which this section belongs.
    int OVERALLCAP;
    //Cross listed enrollment
    int XLSTENR;


    public Enrollment(){
        XLSTCap=0;
        ENR=0;
        XLSTGroup="0";
        OVERALLCAP=0;
        XLSTENR=0;
       
    }

    public Enrollment(int inXLSTCap, int inENR, String inXLSTGroup, int inOVERALLCAP, int inXLSTENR, Course incourse){
        XLSTCap=inXLSTCap;
        ENR=inENR;
        XLSTGroup=inXLSTGroup;
        OVERALLCAP=inOVERALLCAP;
        XLSTENR=inXLSTENR;
        
    }
    ///Accesors 
    public int getXLSTCap() {
        return XLSTCap;
    }
    public int getENR() {
        return ENR;
    }
    public String getXLSTGroup(){
        return XLSTGroup;
    }
    public int getOVERALLCAP(){
        return OVERALLCAP;
    }
    public int getXLSTENR() {
        return XLSTENR;
    }

    ///Mutators
    public void setXLSTCap(int inXLSTCap) {
        XLSTCap = inXLSTCap;
    }
    public void setENR(int inENR) {
        ENR = inENR;
    }
    public void setXLSTGroup(String inXLSTGroup){
       XLSTGroup = inXLSTGroup;
    }
    public void setOVERALLCAP(int inOVERALLCAP){
        OVERALLCAP = inOVERALLCAP;
    }
    public void setXLSTENR(int inXLSTENR) {
       XLSTENR = inXLSTENR;
    }
   

}
