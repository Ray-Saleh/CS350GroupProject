package edu.odu.cs.cs350.pne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import edu.odu.cs.cs350.pne.*;

public class TestEnrollment {

    @Test
public void testConstructor(){
    Enrollment enrollment=new Enrollment();
    assertThat(enrollment.getXLSTCap(), equalTo(0));
    assertThat(enrollment.getENR(), equalTo(0));
    assertThat(enrollment.getLINK(), equalTo(0));
    assertThat(enrollment.getXLSTGroup(), equalTo(0));
    assertThat(enrollment.getOVERALLCAP(), equalTo(0));
    assertThat(enrollment.getXLSTENR(), equalTo(0));
    assertNull(enrollment.getCourse());
}
    
}
