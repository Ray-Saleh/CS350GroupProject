package edu.odu.cs.cs350.pne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestSnapshot {
    
    @Test
    public void testConstructor()
    {
        Snapshot s = new Snapshot();

        assertThat(s.getYear(), is(0));
        assertThat(s.getSemester(), is(0));
    }
    
    @Test
    public void testCopyConstructor(){
        Snapshot s = new Snapshot(2020,10);

        assertThat(s.getYear(), is(2020));
        assertThat(s.getSemester(),is(10));
    }

    @Test
    public void setSemester(){
        Snapshot s = new Snapshot(2020,10);

        s.setSemester(20);
        
        assertThat(s.getYear(), is(2020));
        assertThat(s.getSemester(),is(20));
    }

    @Test
    public void SetYear(){
        Snapshot s = new Snapshot(2020,10);

        s.setYear(2030);
        
        assertThat(s.getYear(), is(2030));
        assertThat(s.getSemester(),is(10));
    }


}
