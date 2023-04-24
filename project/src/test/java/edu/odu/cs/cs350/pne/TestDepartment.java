package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestDepartment {

    private List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }

    @Test // needs to be changed
    public void testSmoothCurving() {
        Department d = new Department();
        int[] enrollment = { 100, 150, 200, 250, 300, 350, 400, 450 };
        int[] expectedSmoothed = { 125, 150, 200, 250, 300, 350, 400, 425 };
        int[] actualSmoothed = Department.smoothCurve(enrollment);
        assertThat(toList(actualSmoothed), is(equalTo(toList(expectedSmoothed))));

        // Test case 2: Smooth curve with random values
        int[] enrollment2 = { 150, 200, 130, 197, 62, 41, 52, 33 };
        int[] expectedSmoothed2 = {175, 160, 175, 129, 100, 51, 42, 42};
        int[] actualSmoothed2 = Department.smoothCurve(enrollment2);
        assertThat(toList(actualSmoothed2), is(equalTo(toList(expectedSmoothed2))));
    }

    // @TODO
    @Test
    public void testMergeSections() {
        int i = 1;
        int i1 = 1;
        assertThat(i + i1, is(2));

    }

}
