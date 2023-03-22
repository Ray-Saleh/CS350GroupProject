package edu.odu.cs.cs350.pne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestOffering {

    @Test
    public void testConstructor(){
        Offering o = new Offering();
        assertThat(o.getProfessor(), is(""));
        assertThat(o.getNumSections(), is(0));
        assertThat(o.getEnrollmentCap(), is(0));
        assertThat(o.getEnrolledNum(), is(0));
        assertThat(o.getCourseSubject(), is(""));
        assertThat(o.getCourseNumber(), is(0));
    }

    @Test
    public void testCConstructor(){
        Course c = new Course("CS",150);
        Enrollment e = new Enrollment(0,10,0,
        0,20,0,c);
        Offering o = new Offering("Zeil", 5, e,c);

        assertThat(o.getProfessor(), is("Zeil"));
        assertThat(o.getNumSections(), is(5));
        assertThat(o.getEnrollmentCap(), is(20));
        assertThat(o.getEnrolledNum(), is(10));
        assertThat(o.getCourseSubject(), is("CS"));
        assertThat(o.getCourseNumber(), is(150));
    }

    @Test
    public void testSetProfessor(){
        Course c = new Course("CS",150);
        Enrollment e = new Enrollment(0,10,0,
        0,20,0,c);
        Offering o = new Offering("Zeil", 5, e,c);

        o.setProfessor("Kennedy");
        assertThat(o.getProfessor(), is("Kennedy"));
        assertThat(o.getNumSections(), is(5));
        assertThat(o.getEnrollmentCap(), is(20));
        assertThat(o.getEnrolledNum(), is(10));
        assertThat(o.getCourseSubject(), is("CS"));
        assertThat(o.getCourseNumber(), is(150));

    }

    @Test
    public void testSetNumSections(){
        Course c = new Course("CS",150);
        Enrollment e = new Enrollment(0,10,0,
        0,20,0,c);
        Offering o = new Offering("Zeil", 5, e,c);

        o.setNumSections(6);
        assertThat(o.getProfessor(), is("Zeil"));
        assertThat(o.getNumSections(), is(6));
        assertThat(o.getEnrollmentCap(), is(20));
        assertThat(o.getEnrolledNum(), is(10));
        assertThat(o.getCourseSubject(), is("CS"));
        assertThat(o.getCourseNumber(), is(150));
    }

    @Test
    public void testSetEnrollmentCap(){
        Course c = new Course("CS",150);
        Enrollment e = new Enrollment(0,10,0,
        0,20,0,c);
        Offering o = new Offering("Zeil", 5, e,c);

        o.setEnrollmentCap(50);
        assertThat(o.getProfessor(), is("Zeil"));
        assertThat(o.getNumSections(), is(5));
        assertThat(o.getEnrollmentCap(), is(50));
        assertThat(o.getEnrolledNum(), is(10));
        assertThat(o.getCourseSubject(), is("CS"));
        assertThat(o.getCourseNumber(), is(150));
    }

    @Test
    public void testSetEnrollmentNum(){
        Course c = new Course("CS",150);
        Enrollment e = new Enrollment(0,10,0,
        0,20,0,c);
        Offering o = new Offering("Zeil", 5, e,c);

        o.setEnrollmentNum(20);
        assertThat(o.getProfessor(), is("Zeil"));
        assertThat(o.getNumSections(), is(5));
        assertThat(o.getEnrollmentCap(), is(20));
        assertThat(o.getEnrolledNum(), is(20));
        assertThat(o.getCourseSubject(), is("CS"));
        assertThat(o.getCourseNumber(), is(150));
    }

    @Test
    public void testSetCourseSubject(){
        Course c = new Course("CS",150);
        Enrollment e = new Enrollment(0,10,0,
        0,20,0,c);
        Offering o = new Offering("Zeil", 5, e,c);

        o.setCourseSubject("CYSE");
        assertThat(o.getProfessor(), is("Zeil"));
        assertThat(o.getNumSections(), is(5));
        assertThat(o.getEnrollmentCap(), is(20));
        assertThat(o.getEnrolledNum(), is(10));
        assertThat(o.getCourseSubject(), is("CYSE"));
        assertThat(o.getCourseNumber(), is(150));
    }

    @Test 
    public void setCourseNumber(){
        Course c = new Course("CS",150);
        Enrollment e = new Enrollment(0,10,0,
        0,20,0,c);
        Offering o = new Offering("Zeil", 5, e,c);

        o.setCourseNumber(330);
        assertThat(o.getProfessor(), is("Zeil"));
        assertThat(o.getNumSections(), is(5));
        assertThat(o.getEnrollmentCap(), is(20));
        assertThat(o.getEnrolledNum(), is(10));
        assertThat(o.getCourseSubject(), is("CS"));
        assertThat(o.getCourseNumber(), is(330));


    }

}
