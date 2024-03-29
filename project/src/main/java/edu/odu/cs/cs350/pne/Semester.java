package edu.odu.cs.cs350.pne;
import java.util.ArrayList;
public class Semester {
    
    String Year;
    String Season;
    ArrayList<Snapshot> snapshotList;

    String start = "";
    String end = "";

    public Semester() {
        Year = "0000";
        Season = "";
        snapshotList = new ArrayList<Snapshot>();
    }

    public Semester(String inYear, String inSeason, ArrayList<Snapshot> inSnapShotList) {
        Year = inYear;
        Season = inSeason;
        snapshotList = inSnapShotList;
    }

    public String getYear() {
        return Year;
    }

    public String getSeason() {
        return Season;
    }

    public void setYear(String inYear) {
        Year = inYear;
    }

    public void setSeason(String inSeason) {
        Season = inSeason;
    }


    public Snapshot getSnapshot(int i)
    {
        return snapshotList.get(i);
    }

    public void addSnapshot(Snapshot inSnapshot)
    {
       snapshotList.add(inSnapshot);
    }

    public ArrayList<Snapshot> getSnapshotList(){
        return snapshotList;
    }

    public int getSnapshotListSize(){
        return snapshotList.size();
    }
}
