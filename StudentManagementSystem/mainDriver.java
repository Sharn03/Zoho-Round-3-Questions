package StudentManagementSystem;

public class mainDriver {

	public static void main(String[] args) {
		
		Student std1 = new Student("101","Sharan");
		Student std2 = new Student("102","Mukesh");
		
		
		Course c1 = new Course("AERO1","Aeronautical");
		Course c2 = new Course("CSC2","Computer Science");
		Course c3 = new Course("ENG3","English");
		Course c4 = new Course("FRE4","French");
		Course c5 = new Course("MECH5","Mechanical");
		Course c6 = new Course("MAT6","Maths");
		
		
		
		StudentManagement sm = new StudentManagement();
		
		//adding the course to the stdMangement courseList
		sm.addCourse(c1);
		sm.addCourse(c2);
		sm.addCourse(c3);
		sm.addCourse(c4);
		sm.addCourse(c5);
		sm.addCourse(c5);
		
		
		//adding the student to the stdManagement studentList
		sm.addStudent(std1);
		sm.addStudent(std2);
		
		//enrolling student to different course
		 sm.enrollStudentInCourse("101", "AERO1");
		 sm.enrollStudentInCourse("101", "CSC2");
		 sm.enrollStudentInCourse("101", "ENG3");
		 sm.enrollStudentInCourse("101", "FRE4");
		 System.out.println();
		 
		 //displaying student std1
		 sm.displayStudent(std1);
		 System.out.println();
		 
		 //droping student 1 from french course
		 sm.dropStudentFromCourse("101", "FRE4");
		 
		//displaying student std1
		 sm.displayStudent(std1);
		 
		 
	     //sm.enrollStudentInCourse("102", "CSC2");
	     
	     
	    
		

	}

}
