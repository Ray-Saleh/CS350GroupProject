package edu.odu.cs.cs350.pne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestOffering {

    @Test
    public void testConstructor(){
        Offering o = new Offering();
        assertThat(o.getProfessor(), is(""));
        assertThat(o.getNumSections(), is(0));
    
    }

    @Test
    public void testCConstructor(){
     
        Offering o = new Offering(1,"Zeil", 5, new Enrollment());

        assertThat(o.getProfessor(), is("Zeil"));
        assertThat(o.getNumSections(), is(5));

    }

    @Test
    public void testSetProfessor(){
       
       
        Offering o = new Offering(1,"Zeil", 5, new Enrollment());
       
        o.setProfessor("Kennedy");
        assertThat(o.getProfessor(), is("Kennedy"));
        assertThat(o.getNumSections(), is(5));

    }





    @Test
    public void testSetEnrollmentNum(){
       

        Offering o = new Offering(1,"Zeil", 5, new Enrollment());
        o.setCRN(20);
        assertThat(o.getProfessor(), is("Zeil"));
        assertThat(o.getNumSections(), is(5));
      
    }

}
