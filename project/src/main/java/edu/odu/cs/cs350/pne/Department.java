package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

//import com.opencsv.CSVWriter;

//import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;

public class Department {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java CsvReader <directory>");
            System.exit(1);
        }
        ArrayList<Semester> semesterList = new ArrayList<Semester>();

        //creates semesters and assigns information for each semester directory given
        
        
        for(int i=0;i<args.length; i++)
        {
         Semester tempSemester = new Semester();
         tempSemester.setSeason(args[i].substring(args[i].length()-2,args[i].length())); 
         tempSemester.setYear(args[i].substring(args[i].length()-6,args[i].length()-2));
         semesterList.add(tempSemester);    
         readCsvFiles(args[i], semesterList,i);
         simpleProjectionReport(tempSemester);

        }      
    }


    public static void readCsvFiles(String directory , ArrayList<Semester> semesterList , int i) {
        File dir = new File(directory);

        //directory check
        if (!dir.isDirectory()) {
            System.err.println("Error: " + directory + " is not a directory.");
            System.exit(1);
        }

        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".csv"));

        for (File file : files) {
            try {
               Snapshot tempSnapshot = new Snapshot();
                Scanner scanner = new Scanner(file);
                
                scanner.nextLine();
                tempSnapshot.setFileName(file.getName());
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    line = line.trim();
                   
                    String[] fields = line.split("\",\"");
                    tempSnapshot = readCSVLine(fields, tempSnapshot);
                   // System.out.println(fields[2] + "@");
                }

                semesterList.get(i).addSnapshot(tempSnapshot);
                scanner.close();
            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found - " + file.getName());
                System.exit(1);
            }
        }
    }

    //Reads a given line from a CSV file sends it to the apporitate location
    public static Snapshot readCSVLine(String[] fields, Snapshot tempSnapshot){
      Course tempCourse = new Course();
      Offering tempOffering = new Offering();
      Enrollment tempEnrollment = new Enrollment();
      
   
      tempCourse.setCRSE(fields[3]);
      tempCourse.setSubject(fields[2]);

      tempOffering.setProfessor(fields[21]);
      tempOffering.setCRN(Integer.parseInt(fields[1]));

      tempEnrollment.setXLSTCap(Integer.parseInt(fields[6]));
      tempEnrollment.setENR(Integer.parseInt(fields[7]));
      tempEnrollment.setLINK(fields[8]);
      tempEnrollment.setXLSTGroup(fields[9]);
      tempEnrollment.setOVERALLCAP(Integer.parseInt(fields[23]));
      tempEnrollment.setXLSTENR(Integer.parseInt(fields[24]));

      tempOffering.setEnrollment(tempEnrollment);

      if(tempSnapshot.getCourse(fields[3])!= null){
         tempSnapshot.getCourse(fields[3]).addOffering(tempOffering);
      }
      else{
         tempCourse.addOffering(tempOffering);
         tempSnapshot.addCourse(tempCourse);
      }

      return tempSnapshot;
    }

    public static int[] smoothCurve(int[] values, int windowSize) {
        int[] smoothedValues = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            int sum = 0;
            int count = 0;
            for (int j = Math.max(0, i - windowSize); j <= Math.min(values.length - 1, i + windowSize); j++) {
                sum += values[j];
                count++;
            }
            smoothedValues[i] = sum / count;
        }

        return smoothedValues;
    }

    public static void simpleProjectionReport(Semester outSemester){
      String filename = "SimpleOutput"+outSemester.getYear()+outSemester.getSeason()+".csv";
      File file = new File(filename);
      if (file.exists()) {
          file.delete();
          System.out.println("Deleted existing file " + filename);
      }
     
      String[] data = { "Course", "Enrollment", "Projected", "Cap" };      
      writeDataToCSV(data,filename);
    
      ArrayList<Course>  tempCourseList =outSemester.getSnapshot(outSemester.getSnapshotListSize()-1).getCourseList();

      for(int i=0;i<tempCourseList.size(); i++){
        
        int[] enrollmentOverAllSnapshots = new int[outSemester.getSnapshotListSize()];
        for(int x=0; x< outSemester.getSnapshotListSize(); x++){
            enrollmentOverAllSnapshots[x]=tempCourseList.get(i).getTotalEnrolled();
        }
       
        int[] smoothedEnrollmentOverAllSnapshots = smoothCurve(enrollmentOverAllSnapshots, i);
        int projected=smoothedEnrollmentOverAllSnapshots[outSemester.getSnapshotListSize()-1];
     

        data  = new String[] {tempCourseList.get(i).getSubject() + tempCourseList.get(i).getCRSE(),
            String.valueOf(tempCourseList.get(i).getTotalEnrolled()),
            String.valueOf(projected),
            String.valueOf(tempCourseList.get(i).getOverallCap())
        };
        
        writeDataToCSV(data,filename);    
      }
      System.out.println("Data has been written to " + filename + " successfully!");
}

    public static void writeDataToCSV(String[] data, String filename) {
        try {
            FileWriter csvWriter = new FileWriter(filename, true);
            for (int i = 0; i < data.length; i++) {
                csvWriter.append(data[i]);
                if (i != data.length - 1) {
                    csvWriter.append(","); // use a comma as the delimiter between columns
                }
            }
            csvWriter.append("\n"); // add a new line character to separate rows
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Detailed Projection Report outputed to a CSV file
    // Used the following as I had no idea how to write a CSV file
    // https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
    public static void detailedProjecitonReport(String outputPathname) {

        File file = new File(outputPathname);

        try {
            // File Writer object
            FileWriter outputFile = new FileWriter(file);

          //  6CSVWriter writer = new CSVWriter(outputFile);
          //  String[] header = { "d historical", "", "d current", "d projected", "Projected" };
           // writer.writeNext(header);
           // writer.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
/*
 * // private String subject;
 * // Pathname will be an incoming arg
 * // List of semesters with their location will be an arg
 * // Location of output will be an arg
 * // Optionally a date in format of YYYY-MM-DD will be an arg
 * public static void main(String[] arg) {
 * 
 * Scanner userInput = new Scanner(System.in);
 * String inputDirectory = new String("");
 * Enrollment e = new Enrollment();
 * 
 * System.out.println("Enter directory path to semesters:");
 * getDirectory(userInput.nextLine(), inputDirectory);
 * 
 * readCSV(inputDirectory);
 * System.out.println("Enter directory path for data Output:");
 * getEnrollment(e);
 * detailedProjecitonReport(userInput.nextLine());
 * 
 * userInput.close();
 * }
 * // test
 * 
 * public static void readCSV(String inputPathname) {
 * // Go to specified directory
 * // Check if Dates.txt is there if not abort
 * // The folders contain the snapshots
 * 
 * }
 * 
 * // Summery Projection written as standard output
 * public static void summeryProjectionReport(Enrollment enrolled) {
 * System.out.println(" of enrollment period has elapsed.");
 * System.out.println("Course Enrollment Projected Cap");
 * 
 * // for (Course c : enrolled.course )
 * System.out.println(enrolled.getCourse() + " " + enrolled.getENR() + " " +
 * enrolled.getENR() + " "
 * + enrolled.getOVERALLCAP());
 * 
 * }
 * 
 * // Do the calculations and output to specified folder
 * public static void getEnrollment(Enrollment enroll) {
 * 
 * }
 * 
 * public static void getDirectory(String inputPathname, String savedPathname) {
 * File directory = new File(inputPathname);
 * File[] files = directory.listFiles();
 * if (files != null) {
 * for (File file : files) {
 * if (file.isFile()) {
 * System.out.println(file.getName());
 * } else if (file.isDirectory()) {
 * System.out.println(file.getName());
 * }
 * }
 * savedPathname = inputPathname;
 * }
 * 
 * }
 * 
 * public static int[] smoothCurve(int[] values, int windowSize) {
 * int[] smoothedValues = new int[values.length];
 * 
 * for (int i = 0; i < values.length; i++) {
 * int sum = 0;
 * int count = 0;
 * for (int j = Math.max(0, i - windowSize); j <= Math.min(values.length - 1, i
 * + windowSize); j++) {
 * sum += values[j];
 * count++;
 * }
 * smoothedValues[i] = sum / count;
 * }
 * 
 * return smoothedValues;
 * }
 * }
 * 
 * /*
 * public static List<String[]> readCsvFiles(String directoryPath) throws
 * IOException
 * {
 * List<String[]> contentsList = new ArrayList<>(); //Create array list
 * File directory = new File(directoryPath);
 * 
 * for (File file : directory.listFiles()) // Iterate over all files in the
 * directory
 * {
 * if (file.isFile() && file.getName().endsWith(".csv"))
 * {
 * CSVReader reader = new CSVReader(new FileReader(file)); // Read the contents
 * of the CSV file into an array of strings
 * List<String[]> contents = reader.readAll();
 * reader.close();
 * contentsList.addAll(contents); // Add the contents array to the list of
 * contents arrays
 * }
 * }
 * return contentsList;
 * }
 * }
 * 
 * /*
 * CSVReader reader = new CSVReaderBuilder(new
 * FileReader("yourfile.csv")).build(); //"yourfile" is a variable and a place
 * holder for the moment
 * String [] nextLine;
 * while ((nextLine = reader.readNext()) != null)
 * {
 * // nextLine[] is an array of values from the line
 * System.out.println(nextLine[0] + nextLine[1] + "etc...");
 * }
 * 
 * //////////or for an iterator//////////////////
 * 
 * CSVReader reader = new CSVReaderBuilder(new
 * FileReader("yourfile.csv")).build();
 * CSVIterator iterator = new CSVIterator(reader);
 * for(String[] nextLine : iterator)
 * {
 * // nextLine[] is an array of values from the line
 * System.out.println(nextLine[0] + nextLine[1] + "etc...");
 * }
 */

/*
 * https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-
 * files-in-a-folder
 * 
 * File folder = new File("your/path");
 * File[] listOfFiles = folder.listFiles();
 * 
 * for (int i = 0; i < listOfFiles.length; i++) {
 * if (listOfFiles[i].isFile()) {
 * System.out.println("File " + listOfFiles[i].getName());
 * } else if (listOfFiles[i].isDirectory()) {
 * System.out.println("Directory " + listOfFiles[i].getName());
 * }
 * }
 */

/*
 * Another Reference:
 * https://stackabuse.com/java-list-files-in-a-directory/
 * 
 */
