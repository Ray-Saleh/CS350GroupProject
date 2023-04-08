    package edu.odu.cs.cs350.pne;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;
    import static org.hamcrest.MatcherAssert.assertThat;
    import static org.hamcrest.Matchers.*;

    import edu.odu.cs.cs350.pne.*;

    public class TestDepartment {



    @Test
    public void testSummaryReport(){
        Department testingSummeryReport = new Department();
        testingSummeryReport.
    }

    @Test
    public void testDetailedReport(){

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

        int[] input3 = {1, 2, 3, 4, 5, 6};
        int[] expectedOutput3 = {1, 2, 3, 4, 5, 5};
        assertArrayEquals(expectedOutput3, d.smoothCurve(input3, 1));

        int[] input4 = {1, 2, 3, 4, 5};
        int[] expectedOutput4 = {1, 2, 3, 4, 4};
        assertArrayEquals(expectedOutput4, d.smoothCurve(input4, 1));

        int[] input5 = {1, 2, 3, 4, 5, 6};
        int[] expectedOutput5 = {1, 2, 3, 4, 5, 5};
        assertArrayEquals(expectedOutput5, d.smoothCurve(input5, 1));

        
    }

    }
    
