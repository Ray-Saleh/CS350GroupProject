package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestCourse {

    @Test
    public void testConstructor() {
        Course c = new Course();
        ArrayList<Offering> offerings = new ArrayList<Offering>();

        assertThat(c.getCRSE(), is(" 000"));
        assertThat(c.getSubject(), is("null"));
        assertTrue(c.getOfferingList().isEmpty());

    }

    @Test
    public void testCopyConstructor() {
        Offering o = new Offering();
        ArrayList<Offering> offerings = new ArrayList<Offering>();

        Course c = new Course("CS", "150", offerings);

        assertThat(c.getCRSE(), is("150"));
        assertThat(c.getSubject(), is("CS"));
        assertTrue(c.getOfferingList().isEmpty());
    }

    @Test
    public void testsetCRSE() {
        Offering o = new Offering();
        ArrayList<Offering> offerings = new ArrayList<Offering>();

        Course c = new Course("CS", "150", offerings);
        c.setCRSE("350");

        assertThat(c.getCRSE(), is("350"));
        assertThat(c.getSubject(), is("CS"));
        assertTrue(c.getOfferingList().isEmpty());

    }

    @Test
    public void testSetSub() {
        Offering o = new Offering();
        ArrayList<Offering> offerings = new ArrayList<Offering>();

        Course c = new Course("CS", "150", offerings);
        c.setSubject("CYSE");

        assertThat(c.getCRSE(), is("150"));
        assertThat(c.getSubject(), is("CYSE"));
        assertTrue(c.getOfferingList().isEmpty());
    }

    @Test
    public void testAddOfferings() {
        Enrollment e = new Enrollment();
        Offering o = new Offering(10, "Zeil", 10, e);
        Offering o1 = new Offering(20, "Kennedy", 20, e);
        ArrayList<Offering> offerings = new ArrayList<Offering>();

        Course c = new Course("CS", "150", offerings);
        c.addOffering(o);
        c.addOffering(o1);

        assertThat(c.getCRSE(), is("150"));
        assertThat(c.getSubject(), is("CS"));
        assertThat(c.getOfferingList(), contains(o, o1));
    }

}