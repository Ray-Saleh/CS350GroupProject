package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestCourse {
    @Test
    public void testCourse() {
        Course c = new Course();
        assertThat(c.getCRSE(), is(000));
        assertThat(c.getSubject(), is(""));

    }

    @Test
    public void testInput(){
        Course c = new Course("MATH", 124);
        assertThat(c.getCRSE(), is(124));
        assertThat(c.getSubject(), is("MATH"));
    }

    @Test
    public void testsetCRSE(){
        Course c = new Course();
        c.setCRSE(452);
        assertThat(c.getCRSE(), is(452));
        assertThat(c.getSubject(), is(""));
    }
}
