package edu.odu.cs.cs350.pne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestSection 
{
    @Test
    public void TestSection()
    {
        Section testSection = new Section();

        assertThat(testSection.getcrn(), is(""));
        // assertThat(testSection.getLINK(), is(""));
        // assertThat(testSection.getEnrollment(), is(""));
        assertThat(testSection.getcrn(), is(""));
        assertThat(testSection.getXLSTCap(), is(""));
    }
}
