package edu.odu.cs.cs350.pne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
//import java.lang.constant.DirectMethodHandleDesc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestDepartment {
    

    @Test
    public void testConstructor()
    {
        Department depart = new Department();
        //depart.readCSV();
        //depart.getEnrollment();

    }


    @Test
    public void testSmoothCurving(){
        Department d = new Department();
        int[] input1 = {1, 2, 3, 4, 5};
        int[] expectedOutput1 = {1, 2, 3, 4, 4};
        assertArrayEquals(expectedOutput1, d.smoothCurve(input1, 1));

        int[] input2 = {1, 2, 3, 4};
        int[] expectedOutput2 = {1, 2, 3, 3};
        assertArrayEquals(expectedOutput2, d.smoothCurve(input2, 1));
    }

}

