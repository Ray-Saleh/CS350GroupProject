package edu.odu.cs.cs350.pne; 


public class Course
{
        private String subject;
        private int CRSE;

        public Course()
        {
            this.subject = "";
            this.CRSE= 000;
        }
        public Course(String sub, int num){
            this.subject = sub;
            this.CRSE = num;
          
        }

        public String getSubject(){
            return this.subject;
        }

        public int getCRSE(){
           return this.CRSE;
        }

        public void setSubject(String subj){
            this.subject =  subj;
        }

        public void setCRSE(int courseNum){
            this.CRSE = courseNum;
        }

        //Not necessary if we wanted to do this anytime we want both
        public String fullCourseName(){
            return this.subject + this.CRSE;
        }

}


