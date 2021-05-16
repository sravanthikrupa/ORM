package com.capg.app.p1;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory(); 
		
		System.out.println("1");
		
		Session session = factory.openSession();// jdbc -> coonection object
		Transaction t = session.beginTransaction();
		
		// ---- write code for data base operation ----
		
		Student s= new Student();
		s.setName("Alex");
		s.setMarks(78);
		s.setAge(18);
		
		Courses technical = new Courses(1, "JAVA", 10);
		s.setTechnicalCourse(technical);
		
		Courses nonTechnical = new Courses(1, "YOGA", 5);
		s.setNonTechnicalCourse(nonTechnical);
		
		
		//Collections--------------------------------------------
		Certifications c = new Certifications(2,3);
		Certifications c1 = new Certifications(1,2);
		
		Set<Certifications> certificate = new HashSet<>();
		certificate.add(c);
		certificate.add(c1);
		
		s.setCertificate(certificate);
		
		
		//one to one---------------------------------------------
		Laptop laptop = new Laptop(1,"HP-122");
		s.setLaptop(laptop);
		
		
		
		
		//one to many
		University u = new University("JNTU", "Hyderabad");
		University u1 = new University("MRECW", "RangaReddy");
		List<University> uList = Arrays.asList(u,u1);
		
		s.setUniversity(uList);
		
		//Inheritance-----------
		Examinations exam = new Examinations(200, "Java", 100);
		
		InternalExaminations internalExam = new InternalExaminations(201, "Spring", 150, 30, "MCQ");
		ExternalExaminations externalExam = new ExternalExaminations(203, "Hibernate", 75, 25, "Coding");
		
		
		//inheritance mapping
		Examinations e1 = new InternalExaminations(202, s.getName(), s.getMarks(), 30, "MCQ");
		Examinations e2 = new ExternalExaminations(204, s.getName(), s.getMarks(), 25, "Coding");
		
		
		List<Examinations> eList = Arrays.asList(e1,e2);
		s.setExamList(eList);
		
		session.save(s);  // insert into Account .....
		session.save(exam);
		session.save(internalExam);
		session.save(externalExam);

		System.out.println("  -->> Data Saved ..");
		t.commit();
		
		//to retrive info-------------------------------------
		/*s = (Student)session.load(Student.class, 101);
		 * System.out.println(s);
		 */
		
		//update------------------------------------------------
		/*s = (Student)session.load(Student.class, 101);
		 * s.setAge(19);
		 * session.update(s);
		 * System.out.println(s);
		 */
		
		//delete-------------------------------------------
		/*s = (Student)session.load(Student.class, 101);
		 * session.delete(s);
		 */
		
		
		session.close();
		System.out.println("All Done");
		
	}
