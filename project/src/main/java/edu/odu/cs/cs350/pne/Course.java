package edu.odu.cs.cs350.pne;   //need help with package


public class Course
{
        private String subject;
        private int CRSE;
        public Course(String sub, int num)
        {
            this.subject = sub;
            this.CRSE = num;
          
        }
        public String getSubject()
        {
            return this.subject;
        }
        public int getCRSE()
        {
            return this.CRSE;
        }

}


