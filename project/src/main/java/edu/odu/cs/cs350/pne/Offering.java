package edu.odu.cs.cs350.pne;
import java.time.LocalDate;



public class Offering {
    private String courseName;
    private LocalDate date;
    private int seats;
    private int enrollment;
    private int maxCap;
    private String time;

    public Offering(){
        this.courseName = "";
        this.date = null;
        this.seats = 0;
        this.enrollment = 0;
        this.maxCap = 0;
        this.time = "";
    }

    public Offering(String c, String t, int s, int e, int mc, LocalDate d){
        this.courseName = c;
        this.date = d;
        this.seats = s;
        this.enrollment = e;
        this.maxCap = mc;
        this.time = t;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getTime() {
        return this.time;
    }

	public int getSeats() {
		return this.seats;
	}

    public int getEnrollment() {
        return this.enrollment;
    }

    public int getMaxCap() {
        return this.maxCap;
    }

	public LocalDate getDate() {
		return this.date;
	}
    

}
