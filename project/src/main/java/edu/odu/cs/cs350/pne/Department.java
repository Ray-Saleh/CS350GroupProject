package edu.odu.cs.cs350.pne;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Random;

public class Department {

   
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java CsvReader <directory>");
            System.exit(1);
        }

        // creates semesters and assigns information for each semester directory given
        // in args[] in the command line
        ArrayList<Semester> semesterList = new ArrayList<Semester>();
        for (int i = 0; i < args.length - 1; i++) {
            // Initializing semester for semester Directory at args[i]
            Semester tempSemester = new Semester();
            tempSemester.setSeason(args[i].substring(args[i].length() - 2, args[i].length()));
            tempSemester.setYear(args[i].substring(args[i].length() - 6, args[i].length() - 2));

            // Reads Data In
            readCsvFiles(args[i], tempSemester);

            semesterList.add(tempSemester);
        }

        Semester mergedSemesters = mergeSemesters(semesterList);
        String lArg = args[args.length - 1];

        ProjectionReports(mergedSemesters, lArg);
    }

    public static void readCsvFiles(String directory, Semester tempSemester) {

        String start = null;
        String end = null;

        // Directory check : ensures directory exist
        File dir = new File(directory);
        if (!dir.isDirectory()) {
            System.err.println("Error: " + directory + " is not a directory.");
            System.exit(-1);
        }

        File[] dates = dir.listFiles((dir1, name) -> name.endsWith(".txt"));
        for (File date : dates) {
            try{
                Scanner scanner = new Scanner(date);
              start =scanner.nextLine();
              end =scanner.nextLine();
            

            }catch (FileNotFoundException e) {
                System.err.println("Error: File not found - " + date.getName());
                System.exit(1);
            }
        }
        
        if(tempSemester.start != "")
        {
            start = tempSemester.start;
        }
        if(tempSemester.end != "")
        {
            end = tempSemester.end;
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
                    // Read each line of data and stored needed data
                    tempSnapshot = readCSVLine(fields, tempSnapshot);

                }
                tempSemester.addSnapshot(tempSnapshot);
                scanner.close();
            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found - " + file.getName());
                System.exit(1);
            }
        }
    }

    // Reads each line of data and stored needed data
    // Reads a given line from a CSV file sends it to the apporitate location
    public static Snapshot readCSVLine(String[] fields, Snapshot tempSnapshot) {
        Course tempCourse = new Course();
        Offering tempOffering = new Offering();
        Enrollment tempEnrollment = new Enrollment();
        Section tempSection = new Section();

        // Adds course data to tempCourse
        tempCourse.setCRSE(fields[3]);
        tempCourse.setSubject(fields[2]);

        // Adds Section data to tempSection
        if (fields[8].length() != 0) {
            tempSection.setLINK(fields[8].substring(1, 2));
        } else {
            tempSection.setLINK("1");
        }
        // Adds Offering data to tempOffering
        tempOffering.setProfessor(fields[21]);
        tempOffering.setCRN(Integer.parseInt(fields[1]));

        // Adds enrollment data to tempEnrollment
        tempEnrollment.setXLSTCap(Integer.parseInt(fields[6]));
        tempEnrollment.setENR(Integer.parseInt(fields[7]));
        tempEnrollment.setXLSTGroup(fields[9]);
        tempEnrollment.setOVERALLCAP(Integer.parseInt(fields[23]));
        tempEnrollment.setXLSTENR(Integer.parseInt(fields[24]));

        // Adds tempEnrollment to tempOffering
        tempOffering.setEnrollment(tempEnrollment);

        // If the course exists in the list of courses check to see if the section exist
        // in the list of sections
        if (tempSnapshot.getCourse(fields[3]) != null) {

            // If section already exist in the array of section just add the offering to the
            // existing sections's array of offerings
            if (tempSnapshot.getCourse(fields[3]).getSection(tempSection.getLink()) != null) {

                tempSnapshot.getCourse(fields[3]).getSection(tempSection.getLink()).addOffering(tempOffering);
            }
            // If section doesn't already exist in the section array, create new section in
            // the array of section, and add tempOffering to that course
            else {
                tempSection.addOffering(tempOffering);
                tempSnapshot.getCourse(fields[3]).addSection(tempSection);
            }

        }
        // If course doesn't already exist in the course array, add tempOffering to the
        // tempSection,
        // add tempSection to that courseList , add temp section to new course in the
        // array of courses
        else {
            tempSection.addOffering(tempOffering);
            tempCourse.addSection(tempSection);
            tempSnapshot.addCourse(tempCourse);
        }
        return tempSnapshot;
    }

    // TODO fix smooth curves
    public static int[] smoothCurve(int[] values) {
        int[] smoothedValues = new int[values.length];
        int windowSize = (int) Math.ceil((double) values.length / 10); // dynamic window size

        for (int i = 0; i < values.length; i++) {
            int sum = 0;
            int count = 0;
            for (int j = Math.max(0, i - windowSize); j <= Math.min(values.length - 1, i + windowSize); j++) {
                sum += values[j];
                count++;
            }

            smoothedValues[i] = (sum / count);
        }

        return smoothedValues;
    }

    public static void ProjectionReports(Semester outSemester, String SemName) {

        // Detailed :: Steps up file path for Detailed Project Report CVS Sheet
        String filename = SemName + "DetailedProjection.xlsx";
        File file = new File(filename);
        if (file.exists()) {
            System.out.println(filename + "Already Exist");
        }

        // Simple :: Sets up First Line of Consle output
        String[] data = { "Course", "Enrollment", "Projected", "Cap" };
        writeDataToConsle(data, filename);
        writeDataToCSV(data, filename);

        ArrayList<Course> tempCourseList = outSemester.getSnapshot(outSemester.getSnapshotListSize() - 1)
                .getCourseList();

        // TODO Detailed:: Sets up First Line of CSV Sheet output

        // Loops Through All the Courses avaiable in the given Semester
        for (int i = 0; i < tempCourseList.size(); i++) {

            // Gathers All the needed data for a specific course across all the snapshots in
            // outSemester
            int[] enrollmentOverAllSnapshots = new int[outSemester.getSnapshotListSize()];
            for (int x = 0; x < outSemester.getSnapshotListSize(); x++) {
                // Gathers all total enrollment
                //enrollmentOverAllSnapshots[x] = tempCourseList.get(i).getTotalEnrolled();

               // System.out.printf( Integer.toString(outSemester.getSnapshot(x).getCourse(tempCourseList.get(i).getCRSE()).getTotalEnrolled()));
               if(outSemester.getSnapshot(x).getCourse(tempCourseList.get(i).getCRSE()) != null){
                 enrollmentOverAllSnapshots[x] = outSemester.getSnapshot(x).getCourse(tempCourseList.get(i).getCRSE()).getTotalEnrolled();
                }

                // Gathers etc.

            }

            // Uses collected data to find and calculated needed data
            int[] smoothedEnrollmentOverAllSnapshots = smoothCurve(enrollmentOverAllSnapshots); // TODO FIX THIS
            int projected = smoothedEnrollmentOverAllSnapshots[outSemester.getSnapshotListSize() - 1];
            Random r = new Random();
            int randomNum = r.nextInt(10);
            if (tempCourseList.get(i).getOverallCap() != projected) {
                int temp = projected += randomNum;
                if (temp > projected) {
                    if (temp > projected) {
                        temp -= 1;
                    }
                    projected = temp;
                }

                // Outputs data line by line

                /// Simple :: formats the need data in an array of Strings and sends it to
                /// writeDataToConsle
                data = new String[] { tempCourseList.get(i).getSubject() + tempCourseList.get(i).getCRSE(),
                        String.valueOf(tempCourseList.get(i).getTotalEnrolled()),
                        String.valueOf(projected),
                        String.valueOf(tempCourseList.get(i).getOverallCap())
                };
                writeDataToCSV(data, filename);
                writeDataToConsle(data, filename);

                // TODO Detailed :: Formated data for line of a CSV sheets

            }
        

        }
        System.out.println("\n\nData has been written to " + filename + " successfully!");

    }

    // Prints Data to CSV sheet line by line
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

    // Prints Data to Consle Line by line
    public static void writeDataToConsle(String[] data, String filename) {
        int columnSpacing = 12;
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-" + columnSpacing + "s", data[i]);
        }
        System.out.printf("\n");
    }

    // TODO Merges an array of semesters
    public static Semester mergeSemesters(ArrayList<Semester> inSemesterList) {
        Semester outSemester = new Semester();
        for (int i = 0; i < inSemesterList.size(); i++) {
            for (int x = 0; x < inSemesterList.get(i).getSnapshotList().size(); x++) {
                outSemester.addSnapshot(inSemesterList.get(i).getSnapshot(x));
            }
        }
        return outSemester;
    }


    public static void excelTemplate(ArrayList<Course> course, String excelOutput,ArrayList<Semester> semesterList) throws IOException {
        Workbook workbook = new HSSFWorkbook();

        for (int i = 0; i < course.size(); i++) {

            Sheet sheet = workbook.createSheet(course.get(i).getCourse());
            // Create the header in the worksheet
            
            Row row = sheet.createRow(0);
            Cell headerCell = row.createCell(0);

            int numCells = 0;

            for(numCells=0; numCells+1 <= 2*semesterList.size(); numCells++){
                // Create cells in the header and set their values
                headerCell = row.createCell(numCells); 
                headerCell.setCellValue("d historical");

                for(int g = 1; g < semesterList.get(numCells).getSnapshotListSize(); g++){
                    row = sheet.createRow(g);
                    Cell data = row.createCell(numCells);
                    data.setCellValue(g/semesterList.get(numCells).getSnapshotListSize());
                }

                headerCell = row.createCell(numCells+1); 
                headerCell.setCellValue("Previous Semester");
                numCells =+1;
                for(int g = 1; g<semesterList.get(numCells).getSnapshotListSize(); g++){
                    row = sheet.createRow(i);
                    Cell data = row.createCell(numCells);
                    data.setCellValue(course.get(i).getTotalEnrolled());
                }
          
            }
    //After Above is implemented this can change appropriately
            numCells =+ 1;
            headerCell = row.createCell(numCells);
            headerCell.setCellValue("d current");
            for(int g = 1; g<semesterList.size(); g++){
                row = sheet.createRow(g);
                Cell data = row.createCell(numCells);
                data.setCellValue(g/semesterList.get(numCells).getSnapshotListSize());
            }

            numCells =+1;
            headerCell = row.createCell(numCells);
            headerCell.setCellValue("Current Semester");
            for(int g = 1; g<semesterList.get(numCells).getSnapshotListSize(); g++){
                row = sheet.createRow(i);
                Cell data = row.createCell(numCells);
                data.setCellValue(course.get(i).getTotalEnrolled());
            }

            headerCell = row.createCell(4);
            headerCell.setCellValue("d projected");

            headerCell = row.createCell(5);
            headerCell.setCellValue("Projected");

            Row rowData = sheet.createRow(1);
            Cell cellData = rowData.createCell(0);
            cellData.setCellValue(.1);
          
    // //After Above is implemented this can change appropriately
    //             headerCell = row.createCell(2);
    //             headerCell.setCellValue(); //d current Value

    //             headerCell = row.createCell(3);
    //             headerCell.setCellValue(); //current Semester enrolled

    //             headerCell = row.createCell(4);
    //             headerCell.setCellValue(); //d projected value

    //             headerCell = row.createCell(5);
    //             headerCell.setCellValue(); // Projected value

 FileOutputStream out = new FileOutputStream(new File(excelOutput));
            workbook.write(out);
        }
    }

}