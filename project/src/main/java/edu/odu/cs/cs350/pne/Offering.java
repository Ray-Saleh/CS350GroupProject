package edu.odu.cs.cs350.pne;

public class Offering {
    // numsecotions will be int for now
    // professor is string
    // overallcap and overall enrollment will be apart of enrollment
    // course will be an object of course

    private int crn;
    private String professor;
    private int numSections;
    private Enrollment enrollment;

    public Offering() {
        this.crn = 0;
        this.professor = "";
        this.numSections = 0;
        this.enrollment = new Enrollment();

    }

    public Offering(int inCRN, String p, int n, Enrollment e) {
        this.crn = inCRN;
        this.professor = p;
        this.numSections = n;
        this.enrollment = e;

    }

    public String getProfessor() {
        return this.professor;
    }

    public void setProfessor(String string) {
        this.professor = string;
    }

    public void setCRN(int inCRN) {
        this.crn = inCRN;
    }

    public int getCRN() {
        return this.crn;
    }

    public void setEnrollment(Enrollment inEnrollment) {
        this.enrollment = inEnrollment;
    }

    public Enrollment getEnrollment() {
        return this.enrollment;
    }

    public void setNumSections(int tempNum){
        numSections= tempNum;   
    }

    public int getNumSections(){
        return numSections;
    }
}
