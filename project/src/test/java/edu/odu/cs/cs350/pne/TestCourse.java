package edu.odu.cs.cs350.pne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestCourse 
{
    @Test
    public void testConstructor(){
        Course testCourse = new Course("CS",350);
        Course testCourse2 = new Course();

        assertThat(testCourse.getSubject(), is("CS"));
        assertThat(testCourse.getCRSE(), is(350));
        //If fullCourseName is deleted delete the next line
        assertThat(testCourse.fullCourseName(), is("CS350"));

        assertThat(testCourse2.getSubject(),is(""));
        assertThat(testCourse2.getCRSE(), is(000));
        //If fullCourseName is deleted delete the next line
        assertThat(testCourse2.fullCourseName(), is("000"));

        testCourse2.setSubject("ENGL");
        assertThat(testCourse2.getSubject(),is("ENGL"));
        assertThat(testCourse.getSubject(), is("CS"));
        assertThat(testCourse2.getCRSE(), is(000));
        assertThat(testCourse.getCRSE(), is(350));
        
        //If fullCourseName is deleted delete the next two lines
        assertThat(testCourse2.fullCourseName(), is("ENGL000"));
        assertThat(testCourse.fullCourseName(), is("CS350"));

        testCourse2.setCRSE(250);
        assertThat(testCourse2.getSubject(),is("ENGL"));
        assertThat(testCourse.getSubject(), is("CS"));
        assertThat(testCourse2.getCRSE(), is(250));
        assertThat(testCourse.getCRSE(), is(350));

        //If fullCourseName is deleted delete the next two lines
        assertThat(testCourse2.fullCourseName(), is("ENGL250"));
        assertThat(testCourse.fullCourseName(), is("CS350"));
    }



}
