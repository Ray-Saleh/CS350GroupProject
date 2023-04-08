package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

public class TestSemester {

    @Test
    public void testConstructor() {
        Semester s = new Semester();

        assertThat(s.getYear(), is("0000"));
        assertThat(s.getSeason(), is(""));
        assertTrue(s.getSnapshotList().isEmpty());
    }

    @Test
    public void testCConstructor() {
        ArrayList<Snapshot> ss = new ArrayList<Snapshot>();
        Semester s = new Semester("2023", "Fall", ss);

        assertThat(s.getYear(), is("2023"));
        assertThat(s.getSeason(), is("Fall"));
        assertTrue(s.getSnapshotList().isEmpty());
    }

    @Test
    public void testSetYear() {
        ArrayList<Snapshot> ss = new ArrayList<Snapshot>();
        Semester s = new Semester("2023", "Fall", ss);

        s.setYear("2024");

        assertThat(s.getYear(), is("2024"));
        assertThat(s.getSeason(), is("Fall"));
        assertTrue(s.getSnapshotList().isEmpty());
    }

    @Test
    public void testSetSeason() {
        ArrayList<Snapshot> ss = new ArrayList<Snapshot>();
        Semester s = new Semester("2023", "Fall", ss);

        s.setSeason("Spring");

        assertThat(s.getYear(), is("2023"));
        assertThat(s.getSeason(), is("Spring"));
        assertTrue(s.getSnapshotList().isEmpty());
    }

    @Test
    public void testSetSnapShot() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        Snapshot s1 = new Snapshot("FileName", courseList);

        ArrayList<Snapshot> ss = new ArrayList<Snapshot>();
        Semester s = new Semester("2023", "Fall", ss);

        s.addSnapshot(s1);

        assertThat(s.getYear(), is("2023"));
        assertThat(s.getSeason(), is("Fall"));
        assertThat(s.getSnapshotList(), contains(s1));

    }
}
