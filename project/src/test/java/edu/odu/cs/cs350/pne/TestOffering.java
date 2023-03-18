package edu.odu.cs.cs350.pne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestOffering {

@Test
public void testConstructor(){
    Offering o = new Offering();
    assertThat(o.getCourse(), is(""));
    assertThat(o.getCRSE(), is(0));
    assertNull(o.getDate());
    assertEquals(o.getSeats(), 0);
    assertEquals(o.getEnrollment(), 0);
    assertEquals(o.getMaxCap(), 0);
    assertThat(o.getTime(), is(""));
}

@Test
public void testCopyConstructor(){
    Course c = new Course("CS", 150);
    Offering o = new Offering(c, "11:30 -> 12:30", 30, 
    10, 50, LocalDateTime.now().toLocalDate());

    assertThat(o.getCourse(), is("CS"));
    assertThat(o.getCRSE(), is(150));
    assertThat(o.getTime(), is("11:30 -> 12:30"));
    assertThat(o.getSeats(), is(30));
    assertThat(o.getEnrollment(), is(10));
    assertThat(o.getMaxCap(), is(50));
    assertThat(o.getDate(), is(LocalDateTime.now().toLocalDate()));
}

@Test
public void testSetCourseName(){
    Course c = new Course("CS", 150);
    Offering o = new Offering(c, "11:30 -> 12:30", 30, 
    10, 50, LocalDateTime.now().toLocalDate()); 
    assertThat(o.getCourse(), is("CS"));

    o.setCourseName("CYSE");

    assertThat(o.getCourse(), is("CYSE"));
    assertThat(o.getCRSE(), is(150));
    assertThat(o.getTime(), is("11:30 -> 12:30"));
    assertThat(o.getSeats(), is(30));
    assertThat(o.getEnrollment(), is(10));
    assertThat(o.getMaxCap(), is(50));
    assertThat(o.getDate(), is(LocalDateTime.now().toLocalDate()));

}

@Test
public void testSetCRSE(){
    Course c = new Course("CS", 150);
    Offering o = new Offering(c, "11:30 -> 12:30", 30, 
    10, 50, LocalDateTime.now().toLocalDate()); 
    assertThat(o.getCourse(), is("CS"));

    o.setCRSE(330);

    assertThat(o.getCourse(), is("CS"));
    assertThat(o.getCRSE(), is(330));
    assertThat(o.getTime(), is("11:30 -> 12:30"));
    assertThat(o.getSeats(), is(30));
    assertThat(o.getEnrollment(), is(10));
    assertThat(o.getMaxCap(), is(50));
    assertThat(o.getDate(), is(LocalDateTime.now().toLocalDate()));

}


    
}
