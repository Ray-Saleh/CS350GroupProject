package edu.odu.cs.cs350.pne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestOffering {

@Test
public void testConstructor(){
    Offering o = new Offering();
    

    assertThat(o.getCourseName(), is(""));
    assertTha(o.getTime(), is(""));
    assertThat(o.getSeats(), is(""));
    assertThat(o.getEnrollment(), is(""));
    assertThat(o.getMaxCap(), is(""));
    


}


    
}
