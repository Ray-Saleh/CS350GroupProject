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
    
        assertThat(c.getCourseName(), is(""));
        assertThat(c.getCourseCrn(), is (""));
        assertThat(c.getSemester(), is (""));
        assertThat(c.getInstructor(), is (""));     //instructor/professor/teacher, whichever is the appropiate name
    }
}
