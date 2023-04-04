package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;

//import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Department {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java CsvReader <directory>");
            System.exit(1);
        }

        // fake output
        String filename = "Fake_Output.csv";
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
            System.out.println("Deleted existing file " + filename);
        }
        String[] data1 = { "CRN", "Subj", "CRSE", "XLST Cap" };
        String[] data2 = { "1", "CS", "330", "30" };
        String[] data3 = { "2", "CS", "350", "30" };
        String[] data4 = { "3", "CS", "361", "30" };
        writeDataToCSV(data1, "Fake_Output.csv");
        writeDataToCSV(data2, "Fake_Output.csv");
        writeDataToCSV(data3, "Fake_Output.csv");
        writeDataToCSV(data4, "Fake_Output.csv");
        // comment from here to fake output comment to remove the fakeoutput

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
                // line under this line prints all files within said directory
                // System.out.println(file.getName());
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

    // Detailed Projection Report outputed to a CSV file
    // Used the following as I had no idea how to write a CSV file
    // https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
    public static void detailedProjecitonReport(String outputPathname) {

        File file = new File(outputPathname);

        try {
            // File Writer object
            FileWriter outputFile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outputFile);
            String[] header = { "d historical", "", "d current", "d projected", "Projected" };
            writer.writeNext(header);
            writer.close();

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
