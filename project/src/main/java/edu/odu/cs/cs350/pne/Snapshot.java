package edu.odu.cs.cs350.pne;
import java.util.ArrayList;
public class Snapshot {


  ArrayList<Course> courseList;
  String fileName;
  public Snapshot(){
  
    fileName = "emptySnapshot";
    courseList =new ArrayList<Course>();
  }

  public Snapshot(String inFileName,  ArrayList<Course> inCourseList){
   this. fileName = inFileName;
    this.courseList = inCourseList;
  }


public void setFileName(String inName)
{
  fileName = inName;
}

public String getFileName(){
  return fileName;
}

public void addCourse(Course addCourse){
  courseList.add(addCourse);
}
public Course getCourse(String inCRSE){
  for(int i= 0; i<courseList.size(); i ++)
  {
    
     if( courseList.get(i).getCRSE().equals(inCRSE))
     {
      return courseList.get(i);
     }
  }   
  return null;
}

public ArrayList<Course> getCourseList(){
  return courseList;
}

//setters

    
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