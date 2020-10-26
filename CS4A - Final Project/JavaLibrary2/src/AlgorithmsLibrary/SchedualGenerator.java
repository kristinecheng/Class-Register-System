
package AlgorithmsLibrary;

import CourseLibrary.Course;
import CourseScheduler.CourseSchedule;
import FacultyLibrary.Faculty;
import IdLibrary.RandomId;
import StudentLibrary.Student;
import java.util.ArrayList;

/*
 * This interface is for the flexibility of using different algorithm 
 * 
 */
public interface SchedualGenerator 
{
    public CourseSchedule defaultSchedule(ArrayList<Student> students, ArrayList<Faculty> faculty, ArrayList<Course> course, 
                                          ScheduleAlgorithms schedule, RandomId id) throws Exception;
}
