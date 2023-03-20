package edu.odu.cs.cs350.pne;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Department {

   private String subject;
      //Pathname will be an incoming arg
      //List of semesters with their location will be an arg
      //Location of output will be an arg
      //Optionally a date in format of YYYY-MM-DD will be an arg
   public static void main(String[] arg){   
     
      Scanner directoryLocation = new Scanner(System.in);
       System.out.println("Enter directory path to semesters:");
    getDirectory(directoryLocation.nextLine());
   
    readCSV(directoryLocation.nextLine());
    getEnrollment();
    

    directoryLocation.close();
   }

      public static void readCSV(String pathname){
         //Go to specified directory
         //Check if Dates.txt is there if not abort
         //The folders contain the snapshots
        
      }

      //Do the calculations and output to specified folder
      public static void getEnrollment(){
         
      }

      public static void getDirectory(String pathname){
         File directory = new File(pathname); 
         File[] files = directory.listFiles();
         if (files != null) {
            for (File file : files) {
               if (file.isFile()) {
                  System.out.println(file.getName());
               }
               else if(file.isDirectory()){
                  System.out.println(file.getName());
               }
            }
         }

      }
   
    // String year = arg[0];
    // File dataFolder = new File(year);

    // System.out.println(dataFolder.list());
    
    // // pathNames = dataFolder.list();
    // // for(String pathname: pathNames){
    // //    System.out.println(pathname);
    // // }

      
   }

    
/* 
CSVReader reader = new CSVReaderBuilder(new FileReader("yourfile.csv")).build();    //"yourfile" is a variable and a place holder for the moment
     String [] nextLine;
     while ((nextLine = reader.readNext()) != null) 
     {
        // nextLine[] is an array of values from the line
        System.out.println(nextLine[0] + nextLine[1] + "etc...");
     }

//////////or for an iterator//////////////////

CSVReader reader = new CSVReaderBuilder(new FileReader("yourfile.csv")).build();
     CSVIterator iterator = new CSVIterator(reader);
     for(String[] nextLine : iterator) 
     {
        // nextLine[] is an array of values from the line
        System.out.println(nextLine[0] + nextLine[1] + "etc...");
     }
*/

/*
https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder

File folder = new File("your/path");
File[] listOfFiles = folder.listFiles();

for (int i = 0; i < listOfFiles.length; i++) {
  if (listOfFiles[i].isFile()) {
    System.out.println("File " + listOfFiles[i].getName());
  } else if (listOfFiles[i].isDirectory()) {
    System.out.println("Directory " + listOfFiles[i].getName());
  }
}
*/

/*
   Another Reference:
 * https://stackabuse.com/java-list-files-in-a-directory/
 * 
 */

