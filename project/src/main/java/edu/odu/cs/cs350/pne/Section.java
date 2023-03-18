package edu.odu.cs.cs350.pne;
public class Section 
{
    int crn;
    int link;
    String eStudent;   //"enrolled Student"
    String course;
    int XLSTCap;    //max number of students to each section

    public class Course
    {
        private String subject;
        private int crn;
        
        public Course()
        {
            this.subject = "";
            this.crn = 0;
        }
        public Course(String s, int c)
        {
            this.subject = s;
            this.crn = c;
        }
    }
    public class crn
    {
        private int classCrn;

        public crn()
        {
            this.classCrn = 0;
        }
        public crn(int n)
        {
            this.classCrn = n;
        }
    }

    public class eStudent   //"enrolled Student"
    {
        private String name;
        
        public eStudent()
        {
            this.name = "";
        }
        public eStudent(String a)
        {
            this.name = a;
        }
    }
    public class XLSTCap
    {
        private int cap;

        public XLSTCap()
        {
                this.cap = 0;
        }
        public XLSTCap(int p)
        {
                this.cap = p;
        }
    }
    //getters
    public int getXLSTCap()
    {
        return XLSTCap;
    }
    public String geteStudent()
    {
        return eStudent;
    }
    public int getCourse()
    {
        return course;
    }
    public int getcrn()
    {
        return crn;
    }
    //setters
    public void setXLSTCap(String x)
    {
        this.XLSTCap = x;
    }
    public void seteStudent(String s)
    {
        this.eStudent = s;
    }
    public void setcourse(String c)
    {
        this.course = c;
    }
    public setcrn(int n)
    {
        this.crn = n;
    }

}
