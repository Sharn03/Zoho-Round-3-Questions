package StudentManagementSystem;

import java.util.ArrayList;
import java.util.Objects;

public class Student {
	private String stdId;
	private String stdName;
	private ArrayList<Course>coursesList;
	public Student(String stdId, String stdName) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.coursesList = new ArrayList<>();
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public ArrayList<Course> getCoursesList() {
		return coursesList;
	}
	public void setCoursesList(ArrayList<Course> courses) {
		this.coursesList = courses;
	}
	
	//enroll the course for the student
	public void enrollStudentInCourse(Course course) {
		if(!Objects.isNull(course))
		{
			coursesList.add(course);
			System.out.println("Student is enrolled in the course:"+" "+course.getCourseName());
		}
		
	}
	
	//removing the particular course from the student 
	public void dropStudentFromCourse(Course course) {
		if(!Objects.isNull(course))
		{
			coursesList.remove(course);
			System.out.println("Student is drop from the course:"+" "+course.getCourseName());
		}
		
		
	}
	public void displayStudentDetails(Student std) {
		System.out.println("Student Name:"+" "+std.stdName);
		for(Course c:std.getCoursesList())
		{
			System.out.println("Course enrolled by student"+std.getStdName()+":"+c.getCourseName());
		}
		
	}
	
	
	
}
