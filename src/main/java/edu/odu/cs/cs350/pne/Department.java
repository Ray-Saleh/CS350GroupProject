package edu.odu.cs.cs350.pne;

import java.io.File;
import java.util.List;

public class Department {
   

   

   public static void main(String[] arg){   
      String date = "202010";
      String year = "../../../../../../data/202010/";
      String[] pathNames;
      File dataFolder = new File(year);
      pathNames = dataFolder.list();
      for(String pathname: pathNames){
         System.out.println(pathname);
      }


   

      
      
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
}

