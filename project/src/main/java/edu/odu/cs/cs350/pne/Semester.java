package edu.odu.cs.cs350.pne;
public class Semester {
    
    int Year;
    String Season;
    Offering offering;

    public Semester() {
        Year = 0000;
        Season = "";
        offering = new Offering();
    }

    public Semester(int inYear, String inSeason, Offering inOffering) {
        Year = inYear;
        Season = inSeason;
        offering = inOffering;
    }

    public int getYear() {
        return Year;
    }

    public String getSeason() {
        return Season;
    }

    public Offering getOffering() { 
        return offering;
    }

    public void setYear(int inYear) {
        Year = inYear;
    }

    public void setSeason(String inSeason) {
        Season = inSeason;
    }

    public void setOffering(Offering inOffering)
    {
        offering = inOffering;
    }

    public void readCSV() {

    }

    public void outputCSV() {

    }

    public int calcProjection(){
        int futureEnrollment = 0;


        return futureEnrollment;
    }



}
