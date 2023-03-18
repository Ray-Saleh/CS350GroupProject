package edu.odu.cs.cs350.pne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestCourse 
{
    @Test
    public void testConstructor()
    {
        Course c = new Course();
        
    
        assertThat(c.getclass(), is(""));
        assertThat(c.getcourseCrn(), is (""));
        assertThat(c.getsemester(), is (""));
        assertThat(c.getinstructor(), is (""));     //instructor/professor/teacher, whichever is the appropiate name
    }
}
