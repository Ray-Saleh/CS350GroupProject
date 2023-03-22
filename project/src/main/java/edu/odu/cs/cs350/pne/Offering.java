package edu.odu.cs.cs350.pne;
import java.time.LocalDate;



public class Offering {
    //numsecotions will be int for now
    //professor is string
    //overallcap and overall enrollment will be apart of enrollment
    //course will be an object of course


    private String professor;
    private int numSections;
    private Enrollment enrollment;
    private Course course;

    public Offering(){
        this.professor = "";
        this.numSections = 0;
        this.enrollment = new Enrollment();
        this.course = new Course();
    }
    public Offering(String p, int n, Enrollment e, Course c){
        this.professor = p;
        this.numSections = n;
        this.enrollment = e;
        this.course = c;
    }

	public String getProfessor() {
		return this.professor;
	}

    public int getNumSections() {
        return this.numSections;
    }

    public int getEnrollmentCap() {
        return this.enrollment.getOVERALLCAP();
    }

    public int getEnrolledNum() {
        return this.enrollment.getENR();
    }

	public String getCourseSubject() {
		return this.course.getSubject();
	}

    public int getCourseNumber() {
        return this.course.getCRSE();
    }





    
}
