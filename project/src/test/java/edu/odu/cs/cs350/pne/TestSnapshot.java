package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;

public class TestSnapshot {

    @Test
    public void testConstructor() {
        Snapshot s = new Snapshot();

        assertThat(s.getFileName(), is("emptySnapshot"));
        assertTrue(s.getCourseList().isEmpty());

    }

    @Test
    public void testCopyConstructor() {
        ArrayList<Course> c = new ArrayList<Course>();
        Snapshot s = new Snapshot("Ray", c);

        assertThat(s.getFileName(), is("Ray"));
        assertTrue(s.getCourseList().isEmpty());

    }

    @Test
    public void testSetFileName() {
        ArrayList<Course> c = new ArrayList<Course>();
        Snapshot s = new Snapshot("Ray", c);

        s.setFileName("Say");

        assertThat(s.getFileName(), is("Say"));
        assertTrue(s.getCourseList().isEmpty());

    }

    @Test
    public void setCourseList() {
        ArrayList<Section> s1 = new ArrayList<Section>();
        Course c1 = new Course("CS", "250", s1);
        ArrayList<Course> c = new ArrayList<Course>();
        Snapshot s = new Snapshot("Ray", c);

        s.addCourse(c1);

        assertThat(s.getFileName(), is("Ray"));
        assertThat(s.getCourseList(), contains(c1));
    }

}
