package edu.odu.cs.cs350.pne;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestEnrollment {

    @Test
    public void testConstructor(){
        Enrollment enrollment=new Enrollment();

        assertThat(enrollment.getENR(), equalTo(0));
        assertThat(enrollment.getOVERALLCAP(), equalTo(0));    
    }   

    @Test 
    public void testsetXLSTCap(){
        Enrollment enrollment=new Enrollment();
        
        enrollment.setXLSTCap(10);
 
        assertThat(enrollment.getENR(), equalTo(0)); 
        assertThat(enrollment.getOVERALLCAP(), equalTo(0)); 
    }
    @Test 
    public void testsetENR(){
        Enrollment enrollment=new Enrollment();

        enrollment.setENR(10);

        assertThat(enrollment.getENR(), equalTo(10));
        assertThat(enrollment.getOVERALLCAP(), equalTo(0));    
    }
    
    @Test 
    public void testsetXLSTGroup(){
        Enrollment enrollment=new Enrollment();

        enrollment.setXLSTGroup("10");
 
        assertThat(enrollment.getENR(), equalTo(0));     
        assertThat(enrollment.getOVERALLCAP(), equalTo(0));
    }
    
    @Test 
    public void testsetOVERALLCAP(){
        Enrollment enrollment=new Enrollment();
        
        enrollment.setOVERALLCAP(10);

        assertThat(enrollment.getENR(), equalTo(0));
        assertThat(enrollment.getOVERALLCAP(), equalTo(10));
    }
    
    @Test 
    public void testsetXLSTENR(){
        Enrollment enrollment=new Enrollment();  

        enrollment.setXLSTENR(10);

        assertThat(enrollment.getENR(), equalTo(0));    
        assertThat(enrollment.getOVERALLCAP(), equalTo(0));
    }
}
