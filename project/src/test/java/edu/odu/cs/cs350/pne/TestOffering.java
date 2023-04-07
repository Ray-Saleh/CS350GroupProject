package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestOffering {

    @Test
    public void testConstructor() {
        Offering o = new Offering();

        assertThat(o.getCRN(), is(0));
        assertThat(o.getProfessor(), is(""));
        assertThat(o.getNumSections(), is(0));
        assertNotNull(o.getEnrollment());

    }

    @Test
    public void testCConstructor() {
        Enrollment e = new Enrollment(0, 0, "", 0, 0, new Course());
        Offering o = new Offering(1234, "Zeil", 5, e);

        assertThat(o.getCRN(), is(1234));
        assertThat(o.getProfessor(), is("Zeil"));
        assertThat(o.getNumSections(), is(5));
        assertThat(o.getEnrollment(), is(e));
    }

    @Test
    public void testSetProfessor() {
        Enrollment e = new Enrollment(0, 0, "", 0, 0, new Course());
        Offering o = new Offering(1234, "Zeil", 5, e);

        o.setProfessor("Kennedy");

        assertThat(o.getCRN(), is(1234));
        assertThat(o.getProfessor(), is("Kennedy"));
        assertThat(o.getNumSections(), is(5));
        assertThat(o.getEnrollment(), is(e));
    }

    @Test
    public void testSetCRN() {
        Enrollment e = new Enrollment(0, 0, "", 0, 0, new Course());
        Offering o = new Offering(1234, "Zeil", 5, e);

        o.setCRN(11);

        assertThat(o.getCRN(), is(11));
        assertThat(o.getProfessor(), is("Zeil"));
        assertThat(o.getNumSections(), is(5));
        assertThat(o.getEnrollment(), is(e));
    }

    @Test
    public void testSetNumSections() {
        Enrollment e = new Enrollment(0, 0, "", 0, 0, new Course());
        Offering o = new Offering(1234, "Zeil", 5, e);

        o.setNumSections(0);

        assertThat(o.getCRN(), is(1234));
        assertThat(o.getProfessor(), is("Zeil"));
        assertThat(o.getNumSections(), is(0));
        assertThat(o.getEnrollment(), is(e));
    }

    @Test
    public void testSetEnrollment() {
        Enrollment e = new Enrollment(0, 0, "", 0, 0, new Course());
        Offering o = new Offering(1234, "Zeil", 5, e);

        Enrollment e1 = new Enrollment(10, 10, "Apples", 10, 10, new Course());

        o.setEnrollment(e1);

        assertThat(o.getCRN(), is(1234));
        assertThat(o.getProfessor(), is("Zeil"));
        assertThat(o.getNumSections(), is(5));
        assertThat(o.getEnrollment(), is(e1));
    }

}
