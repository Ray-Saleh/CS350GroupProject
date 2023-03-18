package edu.odu.cs.cs350.pne;   //need help with package


public class Course
{
        private String Class;
        private int courseCRN;
        private String semester;    //Fall/Spring/Summer
        private String instructor;
        public Course(String c, int n, String s, String i)
        {
            this.Class = c;
            this.courseCRN = n;
            this.semester = s;
            this.instructor = i;
        }
        public String getclass()
        {
            return this.Class;
        }

        public int getcourseCrn()
        {
            return this.courseCRN;
        }

        public String getsemester()
        {
            return this.instructor;
        }
}


