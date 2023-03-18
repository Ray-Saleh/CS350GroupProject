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

        assertThat(testCourse2.getSubject(),is(""));
        assertThat(testCourse2.getCRSE(), is(000));

        testCourse2.setSubject("ENGL");
        assertThat(testCourse2.getSubject(),is("ENGL"));
        assertThat(testCourse.getSubject(), is("CS"));
        assertThat(testCourse2.getCRSE(), is(000));
        assertThat(testCourse.getCRSE(), is(350));

        testCourse2.setCRSE(250);
        assertThat(testCourse2.getSubject(),is("ENGL"));
        assertThat(testCourse.getSubject(), is("CS"));
        assertThat(testCourse2.getCRSE(), is(250));
        assertThat(testCourse.getCRSE(), is(350));
    }

<<<<<<< HEAD
    @Test
    
        assertThat(c.getCourseName(), is(""));
        assertThat(c.getCourseCrn(), is (""));
        assertThat(c.getSemester(), is (""));
        assertThat(c.getInstructor(), is (""));     //instructor/professor/teacher, whichever is the appropiate name
    }
=======


>>>>>>> b719334ec29f14c9b5da86136544ef72e8a25173
}
