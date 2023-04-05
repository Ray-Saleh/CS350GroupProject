/*package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestSection {
    @Test
    public void TestSection() {
        Section s = new Section();
        assertThat(s.getcrn(), is(0));
        assertThat(s.getSub(), is(""));
        assertThat(s.getCRSE(), is(000));
        // assertThat(s.getLINK(), is(0));
        // assertThat(s.getXLSTCap(), is(0));
    }

    @Test
    public void testCopyConstructor() {
        Course c = new Course("cs", 150);
        Enrollment e = new Enrollment(10, 10, 10, 10, 10, 10, c);
        Section s = new Section(1010, e, c);

        assertThat(s.getcrn(), is(1010));
        assertThat(s.getSub(), is("cs"));
        assertThat(s.getCRSE(), is(150));
        assertThat(s.getLINK(), is(10));
        assertThat(s.getXLSTCap(), is(10));
    }

    public void testSetLinked() {

    }
}
*/