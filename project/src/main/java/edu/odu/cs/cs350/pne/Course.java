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

        public void getCRSE(){
           
        }

        public void setSubject(String subj){

        }

}


