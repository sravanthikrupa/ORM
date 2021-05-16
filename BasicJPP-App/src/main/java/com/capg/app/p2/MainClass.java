package com.capg.app.p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {
public static void main(String[] args) {
		
		MainClass obj = new MainClass();
		
		Configuration cfg = new Configuration();
		SessionFactory fac = cfg.configure().buildSessionFactory();
		Session session = fac.openSession();
		
		Student s1 = obj.getStudentApp();  
		Student s2 = obj.getStudentApp(); 
		Student s3 = obj.getStudentApp();  // yatra.com
		
		Course1 c1 = obj.getCourses(); // the Taj
		Course1 c2 = obj.getCourses();
		Course1 c3 = obj.getCourses();
		
		
		
		///----- Creating collections for  Hotels to App1 ----
		
		List<Course1> courseListfor_App1 = new ArrayList<Course1>();
		courseListfor_App1.add(c1);
		courseListfor_App1.add(c2);
		courseListfor_App1.add(c3);
		
		List<Course1> courseListfor_App2 = new ArrayList<Course1>();
		courseListfor_App2.add(c1);
		courseListfor_App2.add(c2);
		
		List<Course1> courseListfor_App3 = new ArrayList<Course1>();
		courseListfor_App2.add(c2);
		courseListfor_App2.add(c3);
		
		
		
		// -------- Creating collections for  Apps to Hotel ---------
		
		List<Student> appListFor_Course1 = new ArrayList<Student>();
		appListFor_Course1.add(s1);
		appListFor_Course1.add(s2);
		
		List<Student> appListFor_Course2 = new ArrayList<Student>();
		appListFor_Course1.add(s2);
		appListFor_Course1.add(s3);
		
		List<Student> appListFor_Course3 = new ArrayList<Student>();
		appListFor_Course1.add(s3);
		appListFor_Course1.add(s1);
		
		
		
		
		// ------------ Adding Collection of Hotel to App ----- 
		
		s1.setCourseList(courseListfor_App1);
		s2.setCourseList(courseListfor_App2);
		s3.setCourseList(courseListfor_App3);
				
		// ------------ Adding Collection of App to Hotel ----- 
				
		c1.setStudentApps(appListFor_Course1);
		c2.setStudentApps(appListFor_Course2);
		c3.setStudentApps(appListFor_Course3);
		
				
				
		Transaction t = session.beginTransaction();
		
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		session.save(c1);
		session.save(c2);
		session.save(c3);
		
		
		t.commit();
		
		System.out.println(" Data Saved");
		
		
		
		
		
		
		
		
	}
	
	public Student getStudentApp()
	{
		Student app = new Student();
		System.out.println("Enter Student Id ");
		app.setSId(new Scanner(System.in).nextInt());
		
		System.out.println("Enter Student Name ");
		app.setName(new Scanner(System.in).nextLine());
		
		System.out.println("Enter student age ");
		app.setAge(new Scanner(System.in).nextInt());
		
		System.out.println("Enter Student mail ");
		app.setEmail(new Scanner(System.in).nextLine());
		
		return app;
	}
	
	public Course1 getCourses()
	{
		Course1 c = new Course1();
		System.out.println("Enter Course Name ");
		c.setCourseName(new Scanner(System.in).nextLine());
		System.out.println("Enter duration ");
		c.setDuration(new Scanner(System.in).nextInt());
		System.out.println("Enter Trainer Name ");
		c.setTrainerName(new Scanner(System.in).nextLine());
	
		return c;
	}
}