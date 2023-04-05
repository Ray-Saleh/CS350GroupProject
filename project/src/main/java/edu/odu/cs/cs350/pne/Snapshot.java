package edu.odu.cs.cs350.pne;

public class Snapshot {

  private int year;
  private int semester;

  public Snapshot() {
    this.year = 0;
    this.semester = 0;
  }

  public Snapshot(int y, int s) {
    this.year = y;
    this.semester = s;
  }

  public int getSemester() {
    return this.semester;
  }

  public int getYear() {
    return this.year;
  }

  // setters
  public void setSemester(int s) {
    this.semester = s;
  }

  public void setYear(int y) {
    this.year = y;
  }

}
