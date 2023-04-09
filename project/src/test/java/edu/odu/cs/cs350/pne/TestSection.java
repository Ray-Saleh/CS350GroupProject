
package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;

public class TestSection {

    @Test
    public void testConstructor() {
        Section s = new Section();

        assertThat(s.getLink(), is(""));
        assertTrue(s.getOfferingList().isEmpty());
    }

    @Test
    public void testCConstructor() {
        ArrayList<Offering> o = new ArrayList<Offering>();
        Section s = new Section(o, "Apples");

        assertThat(s.getLink(), is("Apples"));
        assertTrue(s.getOfferingList().isEmpty());
    }

    @Test
    public void testSetLinked() {
        ArrayList<Offering> o = new ArrayList<Offering>();
        Section s = new Section(o, "Apples");
        s.setLINK("Boatz n Hoez");
        assertThat(s.getLink(), is("Boatz n Hoez"));
        assertTrue(s.getOfferingList().isEmpty());

    }

    @Test
    public void testAddOffering() {
        Enrollment e = new Enrollment();
        Offering f = new Offering(69, "Zeil", 420, e);
        Offering f1 = new Offering(420, "Kennedy", 69, e);

        ArrayList<Offering> o = new ArrayList<Offering>();
        Section s = new Section(o, "Apples");
        s.addOffering(f);
        s.addOffering(f1);
        assertThat(s.getLink(), is("Apples"));

        // check that s.getOfferingList() contains(f,f1);
        assertThat(s.getOfferingList(), contains(f, f1));
    }
}
