package edu.odu.cs.cs350.pne;

public class Section {

    private int crn;
    private Enrollment enrollment;
    private Course course;

    public Section() {
        crn = 0;
        enrollment = new Enrollment();
        course = new Course();
    }

    public Section(int r, Enrollment e, Course c) {
        this.crn = r;
        this.enrollment = e;
        this.course = c;
    }

    // setters and getters
    public int getLinked() {
        return this.enrollment.getLINK();
    }

    public void setLinked(int i) {
        this.enrollment.setLINK(i);
    }

    public int getcrn() {
        return this.crn;
    }

    public void setcrn(int i) {
        this.crn = i;
    }

    public int getCRSE() {
        return this.course.getCRSE();
    }

    public void setCRSE(int i) {
        this.course.setCRSE(i);
    }

    public String getSub() {
        return this.course.getSubject();
    }

    public void setSub(String s) {
        this.course.setSubject(s);
    }

    public int getXLSTCap() {
        return this.enrollment.getXLSTCap();

    }

    public void setXLSTCap(int i) {
        this.enrollment.setXLSTCap(i);
    }

    public int getENR() {
        return this.enrollment.getENR();
    }

    public void setENR(int i) {
        this.enrollment.setENR(i);
    }
}
