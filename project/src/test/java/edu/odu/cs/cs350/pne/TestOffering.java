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
    assertThat(o.getTime(), is(""));
}

@Test
public void testCopyConstructor(){
    Course c = new Course("CS", 150);
    Enrollment e = new Enrollment(0,10,0,0,0,0,c);
    Offering o = new Offering(c, "11:30 -> 12:30", 30, 
    e, LocalDateTime.now().toLocalDate());

    assertThat(o.getCourse(), is("CS"));
    assertThat(o.getCRSE(), is(150));
    assertThat(o.getTime(), is("11:30 -> 12:30"));
    assertThat(o.getSeats(), is(30));
    assertThat(o.getEnrollment(), is(10));
    assertThat(o.getDate(), is(LocalDateTime.now().toLocalDate()));
}

@Test
public void testSetCourseName(){
    Course c = new Course("CS", 150);
    Enrollment e = new Enrollment(0,10,0,0,0,0,c);
    Offering o = new Offering(c, "11:30 -> 12:30", 30, 
    e, LocalDateTime.now().toLocalDate());
    assertThat(o.getCourse(), is("CS"));

    o.setCourseName("CYSE");

    assertThat(o.getCourse(), is("CYSE"));
    assertThat(o.getCRSE(), is(150));
    assertThat(o.getTime(), is("11:30 -> 12:30"));
    assertThat(o.getSeats(), is(30));
    assertThat(o.getEnrollment(), is(10));
   assertThat(o.getDate(), is(LocalDateTime.now().toLocalDate()));

}

@Test
public void testSetCRSE(){
    Course c = new Course("CS", 150);
    Enrollment e = new Enrollment(0,10,0,0,0,0,c);
    Offering o = new Offering(c, "11:30 -> 12:30", 30, 
    e, LocalDateTime.now().toLocalDate());
    assertThat(o.getCourse(), is("CS"));

    o.setCRSE(330);

    assertThat(o.getCourse(), is("CS"));
    assertThat(o.getCRSE(), is(330));
    assertThat(o.getTime(), is("11:30 -> 12:30"));
    assertThat(o.getSeats(), is(30));
    assertThat(o.getEnrollment(), is(10));
    assertThat(o.getDate(), is(LocalDateTime.now().toLocalDate()));

}

@Test
public void setDate(){
    Course c = new Course("CS", 150);
    Enrollment e = new Enrollment(0,10,0,0,0,0,c);
    Offering o = new Offering(c, "11:30 -> 12:30", 30, 
    e, LocalDateTime.now().toLocalDate());
    assertThat(o.getCourse(), is("CS"));

    LocalDate r = LocalDate.of(2023, 1, 1);

    o.setDate(r);

    assertThat(o.getCourse(), is("CS"));
    assertThat(o.getCRSE(), is(150));
    assertThat(o.getTime(), is("11:30 -> 12:30"));
    assertThat(o.getSeats(), is(30));
    assertThat(o.getEnrollment(), is(10));
    assertNotEquals(o.getDate(), is(LocalDateTime.now().toLocalDate()));

}

@Test
public void setSeats(){
    Course c = new Course("CS", 150);
    Enrollment e = new Enrollment(0,10,0,0,0,0,c);
    Offering o = new Offering(c, "11:30 -> 12:30", 30, 
    e, LocalDateTime.now().toLocalDate());

    o.setSeats(35);

    assertThat(o.getCourse(), is("CS"));
    assertThat(o.getCRSE(), is(150));
    assertThat(o.getTime(), is("11:30 -> 12:30"));
    assertThat(o.getSeats(), is(35));
    assertThat(o.getEnrollment(), is(10));
    assertThat(o.getDate(), is(LocalDateTime.now().toLocalDate()));
}

@Test
public void setEnrollment(){
    Course c = new Course("CS", 150);
    Enrollment e = new Enrollment(0,10,0,0,0,0,c);
    Offering o = new Offering(c, "11:30 -> 12:30", 30, 
    e, LocalDateTime.now().toLocalDate());

    o.setEnrollment(11);

    assertThat(o.getCourse(), is("CS"));
    assertThat(o.getCRSE(), is(150));
    assertThat(o.getTime(), is("11:30 -> 12:30"));
    assertThat(o.getSeats(), is(30));
    assertThat(o.getEnrollment(), is(11));
    assertThat(o.getDate(), is(LocalDateTime.now().toLocalDate()));
}

@

    
}
