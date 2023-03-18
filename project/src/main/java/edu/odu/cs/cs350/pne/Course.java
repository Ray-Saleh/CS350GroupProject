package edu.odu.cs.cs350.pne;
public class Course {
    String CourseName;
    int CourseCrn;

    public Course(){
        CourseName = "";
        CourseCrn = 00000;
    }

    public Course(String Name, int Crn){
        CourseName = Name;
        CourseCrn = Crn;
    }

    public Object getCourseSubject() {
        return CourseName;
    }

    public Object getCourseNumber() {
        return CourseCrn;
    }

    public void setCourseNumber(String inName) {
        CourseName = inName;
    }
    
    public void setCourseName(int inCrn) {
        CourseCrn = inCrn;
    }
}
