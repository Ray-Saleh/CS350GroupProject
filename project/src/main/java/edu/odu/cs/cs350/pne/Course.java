package edu.odu.cs.cs350.pne;   //need help with package

public class Course 
{
    public class Course
    {
            private string class;
            private int courseCRN;
            private string semester;    //Fall/Spring/Summer
            private instructor;

            public course(string c, int n, string s, string i)
            {
                this.class = c;
                this.courseCRN = n;
                this.semester = s;
                this.instructor = i;
            }

            public string getclass()
            {
                return this.class;
            }
            
            public int getcourseCrn()
            {
                return this.courseCRN;
            }

            public string getsemester()
            {
                return this.instructor;
            }
            


    }
}
