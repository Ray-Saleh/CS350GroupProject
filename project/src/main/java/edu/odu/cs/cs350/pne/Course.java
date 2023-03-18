<<<<<<< HEAD
package edu.odu.cs.cs350.pne;
public class Course {

    public Object getCourseSubject() {
        return null;
    }
    
=======
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

        }

>>>>>>> ae9b9c4d06e395a5a1d05a082a7b5d4216262dca
}


