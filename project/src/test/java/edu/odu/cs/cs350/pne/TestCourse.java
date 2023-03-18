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
        Course testCourse = new Course();
        
        assertThat(testCourse.getCourseSubject(), is(""));
        assertThat(testCourse.getCourseNumber(), is(00000));
    }

    @Test
    
    public void testsetCourseNumber(){
        Course course = new Course();

        course.setCourseNumber(12345);

        assertThat(course.getCourseSubject(), is(""));
        assertThat(course.getCourseNumber(), equalTo(12345));
    }

    public void testsetCourseName(){
        Course course = new Course();

        course.setCourseName("TestCourse");;

        assertThat(course.getCourseSubject(), is("TestCourse"));
        assertThat(course.getCourseNumber(), equalTo(00000));
    }
}
