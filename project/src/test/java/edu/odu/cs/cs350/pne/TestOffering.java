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
    Offering o = new Offering("CS150", "11:30 -> 12:30", 30, 
    10, 50, LocalDateTime.now().toLocalDate());

    assertThat(o.getCourseName(), is("CS150"));
    assertThat(o.getTime(), is("11:30 -> 12:30"));
    assertThat(o.getSeats(), is(30));
    assertThat(o.getEnrollment(), is(10));
    assertThat(o.getMaxCap(), is(50));
    assertThat(o.getDate(), is(LocalDateTime.now().toLocalDate()));
}


    
}
