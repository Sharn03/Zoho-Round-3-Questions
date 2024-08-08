package StudentManagementSystem;

import java.util.ArrayList;
import java.util.Objects;

public class StudentManagement {
	
	private ArrayList<Student>studentList;
	private ArrayList<Course>courseList;
	
	public StudentManagement()
	{
		this.studentList = new ArrayList<>();
		this.courseList = new ArrayList<>();
	}
	
	//add Student
	public void addStudent(Student std)
	{
		if(!Objects.isNull(std))
		{
			studentList.add(std);
		}
	}
	
	//add Course
	public void addCourse(Course course)
	{
		if(!Objects.isNull(course))
		{
			courseList.add(course);
		}
	}
	
	//enroll course for a student
	public void enrollStudentInCourse(String stdId,String courseId)
	{
		//getting student details
		Student std = findStudent(stdId);
		Course course = findCourse(courseId);
		
		if(std != null && course != null)
		{
			std.enrollStudentInCourse(course);
		}
		else
		{
			System.out.println( course.getCourseName()+" "+"There is no such Course");
		}
	}
	
	//drop the student from the course
	public void dropStudentFromCourse(String stdId,String courseId)
	{
		//getting student details
		Student std = findStudent(stdId);
		Course course = findCourse(courseId);
		
		if(std != null && course != null)
		{
			std.dropStudentFromCourse(course);
		}
		else
		{
			System.out.println( course.getCourseName()+" "+"There is no such Course");
		}
	}
	
	//find the course object
	private Course findCourse(String courseId) {
		for(Course course:courseList)
		{
			if(course.getCourseId() == courseId)
			{
				return course;
			}
		}
		return null;
	}
	
	//find student object
	private Student findStudent(String stdId) {
		for(Student std:studentList)
		{
			if(std.getStdId() == stdId)
			{
				return std;
			}
		}
		return null;
	}
	
	public void displayStudent(Student std)
	{
		if(!Objects.isNull(std))
		{
			std.displayStudentDetails(std);
	        
		}
		else
		{
			System.out.println("Student details not found");
		}
	}

	
}
