package edu.odu.cs.cs350.pne;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
//import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Department {

  //private String subject;
      //Pathname will be an incoming arg
      //List of semesters with their location will be an arg
      //Location of output will be an arg
      //Optionally a date in format of YYYY-MM-DD will be an arg


      public static void main(String[] args) {
         if (args.length == 0) {
             System.err.println("Usage: java CsvReader <directory>");
             System.exit(1);
         }
         
         //fake output 
         String filename = "Fake_Output.csv";
         File file = new File(filename);
         if (file.exists()) {
               file.delete();
               System.out.println("Deleted existing file " + filename);
         }
         String[] data1 = {"CRN", "Subj", "CRSE", "XLST Cap"};
         String[] data2 = {"1", "CS", "330", "30"};
         String[] data3 = {"2", "CS", "350", "30"};
         String[] data4 = {"3", "CS", "361", "30"};
         writeDataToCSV(data1, "Fake_Output.csv");
         writeDataToCSV(data2, "Fake_Output.csv");
         writeDataToCSV(data3, "Fake_Output.csv");
         writeDataToCSV(data4, "Fake_Output.csv");


         String directory = args[0];
 
         readCsvFiles(directory);
     }

   public static void readCsvFiles(String directory) {
      File dir = new File(directory);

      if (!dir.isDirectory()) {
          System.err.println("Error: " + directory + " is not a directory.");
          System.exit(1);
      }

      File[] files = dir.listFiles((dir1, name) -> name.endsWith(".csv"));

      for (File file : files) {
          try {
              Scanner scanner = new Scanner(file);
              scanner.useDelimiter(",");

              while (scanner.hasNextLine()) {
                  String line = scanner.nextLine();
                  String[] fields = line.split(",");
                  // Do something with the fields
              }

              scanner.close();
          } catch (FileNotFoundException e) {
              System.err.println("Error: File not found - " + file.getName());
              System.exit(1);
          }
      }
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
         System.out.println("Data has been written to " + filename + " successfully!");
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}



/*
 * import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvReader {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java CsvReader <directory>");
            System.exit(1);
        }

        String directory = args[0];

        readCsvFiles(directory);
    }

    public static void readCsvFiles(String directory) {
        File dir = new File(directory);

        if (!dir.isDirectory()) {
            System.err.println("Error: " + directory + " is not a directory.");
            System.exit(1);
        }

        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".csv"));

        for (File file : files) {
            try {
                Scanner scanner = new Scanner(file);
                scanner.useDelimiter(",");

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] fields = line.split(",");
                    // Do something with the fields
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found - " + file.getName());
                System.exit(1);
            }
        }
    }
}

 * 
 */

  