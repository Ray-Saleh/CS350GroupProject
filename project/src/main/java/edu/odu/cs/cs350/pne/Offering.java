package edu.odu.cs.cs350.pne;
import java.time.LocalDate;



public class Offering {
    private Course course;
    private LocalDate date;
    private int seats;
    private Enrollment enrollment;
    private String time;

    public Offering(){
        this.course = new Course();
        this.date = null;
        this.seats = 0;
        this.enrollment = new Enrollment();
        this.time = "";
    }

    public Offering(Course c, String t, int s, Enrollment e, LocalDate d){
        this.course = c;
        this.date = d;
        this.seats = s;
        this.enrollment = e;
        this.time = t;
    }

    public String getCourse() {
        return this.course.getSubject();
    }

    public String getTime() {
        return this.time;
    }

	public int getSeats() {
		return this.seats;
	}

    public int getEnrollment() {
        return this.enrollment.getENR();
    }

	public LocalDate getDate() {
		return this.date;
	}

    public int getCRSE() {
        return this.course.getCRSE();
    }

   public void setCourseName(String string) {
        this.course.setSubject(string);
    }

    public void setCRSE(int i) {
        this.course.setCRSE(i);
    }

    public void setDate(LocalDate r) {
        this.date = r;
    }

    public void setSeats(int i) {
        this.seats = i;
    }

    public void setEnrollment(int i) {
        this.enrollment.setENR(i);
    }
    

}
