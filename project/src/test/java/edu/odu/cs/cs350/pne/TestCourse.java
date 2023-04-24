package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestCourse {

    @Test
    public void testConstructor() {
        Course c = new Course();

        assertThat(c.getCRSE(), is(" 000"));
        assertThat(c.getSubject(), is("null"));
        assertTrue(c.getSectionList().isEmpty());
    }

    @Test
    public void testCopyConstructor() {
        ArrayList<Section> sList = new ArrayList<Section>();
        Course c = new Course("CS", "150", sList);

        assertThat(c.getCRSE(), is("150"));
        assertThat(c.getSubject(), is("CS"));
        assertTrue(c.getSectionList().isEmpty());
    }

    @Test
    public void testsetCRSE() {
        ArrayList<Section> sList = new ArrayList<Section>();
        Course c = new Course("CS", "150", sList);
       
        c.setCRSE("350");

        assertThat(c.getCRSE(), is("350"));
        assertThat(c.getSubject(), is("CS"));
        assertTrue(c.getSectionList().isEmpty());

    }

    @Test
    public void testSetSub() {
        ArrayList<Section> sList = new ArrayList<Section>();
        Course c = new Course("CS", "150", sList);

        c.setSubject("CYSE");

        assertThat(c.getCRSE(), is("150"));
        assertThat(c.getSubject(), is("CYSE"));
        assertTrue(c.getSectionList().isEmpty());
    }

    @Test
    public void testAddOfferings() {

        ArrayList<Offering> o = new ArrayList<Offering>();
        Section s1 = new Section(o, "s");
        Section s2 = new Section(o, "r");
        ArrayList<Section> sList = new ArrayList<Section>();

        Course c = new Course("CS", "150", sList);

        c.addSection(s1);
        c.addSection(s2);

        assertThat(c.getCRSE(), is("150"));
        assertThat(c.getSubject(), is("CS"));
        assertThat(c.getSectionList(), contains(s1, s2));
    }
    
}