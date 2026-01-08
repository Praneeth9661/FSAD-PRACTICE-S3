package com.klu.model;

public class CourseRegistration {
	private int rollNO;
	private String studentName;
	private String courseName;
	private int semester;
	public CourseRegistration(int rollNO,String studentName) {
	    this.rollNO= rollNO;
	this.studentName=studentName;

}

public void setCourseName(String courseName)
{
	this.courseName = courseName;
	
	
}
public void setsemester(int semester){
	this.semester=semester;
}
public void display() {
	System.out.println("RollNo:"+rollNO);
	System.out.println("Name:"+studentName);
	System.out.println("Course:"+courseName);
	System.out.println("Semester:"+semester);
}


}