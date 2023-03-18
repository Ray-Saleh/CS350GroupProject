package edu.odu.cs.cs350.pne;
public class Snapshot {

  private int year;
  private int semester;



  public Snapshot(){
    this.year = 0;
    this.semester = 0;
  }

  public Snapshot(int y, int s){
    this.year = y;
    this.semester = s;
  }

public int getSemester() {
    return this.semester;
}

public int getYear() {
    return this.year;
}
//setters
public void setSemester(int s)
{
  this.semester = s;
}
public void setYear(int y)
{
  this.year = y;
}
    
}
/*
                            //idea of how to write in data from files found from   https://www.w3schools.com/java/java_files_create.asp
public class WriteToFile {
  public static void main(String[] args) {
    try {
      FileWriter myWriter = new FileWriter("filename.txt");
      myWriter.write("Files in Java might be tricky, but it is fun enough!");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}

*/