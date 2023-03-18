package edu.odu.cs.cs350.pne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.lang.constant.DirectMethodHandleDesc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestDepartment {
    

    @Test
    public void testConstructor()
    {
        Department depart = new Department();
        depart.readCSV();
        depart.getEnrollment();

    }

}

