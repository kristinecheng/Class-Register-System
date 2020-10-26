
package AlgorithmsLibrary;

import java.util.ArrayList;
import CourseScheduler.*;
import CourseLibrary.*;
import FacultyLibrary.*;
import IdLibrary.*;
import StudentLibrary.*;


public class DefaultAlgorithm implements SchedualGenerator
{   
    /**
     * This function generate the sessions based on the students wish list, 
     * it will randomly assigned the instructor and sessions to the classes. 
     * @param students Student list 
     * @param faculty Faculty list 
     * @param course COurse list 
     * @param schedule parameter to choose which algorithm to use 
     * @param id parameter to generate random session id 
     * @return CourseScheduel type value 
     * @throws Exception 
     */
    @Override
    public CourseSchedule defaultSchedule(ArrayList<Student> students, ArrayList<Faculty> faculty, ArrayList<Course> course, 
                                          ScheduleAlgorithms schedule, RandomId id) throws Exception
    {
         
        ArrayList<Sessions> course_sessions = new ArrayList<>();
        
        for (int i = 0; i < course.size(); i++)
        {
            for (int j = 0; j < schedule.getSession_per_course(); j++)
            {
                Course c = course.get(i);
                Faculty instructor = new Faculty();
                
                for (Faculty f : faculty)
                {
                    if (f.getCourse_taught().contains(c.getCourse_id()) && f.getNumCourses() < schedule.getSession_per_instructor())
                    {
                        instructor = f;
                        f.addCourse();

                        break;
                    }
                  
                }
                
                ArrayList<Student> studentsInSession = new ArrayList<Student>();
                
                for(Student s : students)
                {
                    if (s.getCourse_taken().contains(c.getCourse_id()) && s.getNumCourses() < schedule.getSession_per_student())
                    {
                        studentsInSession.add(s);
                        s.addCourse();
                        s.getCourse_taken().remove(c.getCourse_id());
                        
                    }
                }
                
                String sessionsId = id.generateID();
                course_sessions.add(new Sessions(sessionsId, studentsInSession, instructor, c));
            }
        }
        
        return new CourseSchedule(course_sessions);
    }
    
}
