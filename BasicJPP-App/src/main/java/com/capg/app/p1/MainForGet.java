package com.capg.app.p1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainForGet {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();

		System.out.println("1");

		Session session = factory.openSession();// jdbc -> coonection object
		Transaction t = session.beginTransaction();
		
		Student s = (Student) session.get(Student.class, 1);
		//
		System.out.println("\n Student Info :- "+s);
		System.out.println("\n Laptop Information :- "+s.getLaptop());
		System.out.println("\n Laptop Brand  :- "+s.getLaptop().getBrandName());
		
		
		Laptop laptop = session.get(Laptop.class, s.getLaptop().getId());
		
		System.out.println("\n Laptop Info :- "+ laptop);
		System.out.println("\n Student Info  :- "+laptop.getStudent());
		System.out.println("\n Student Name   :- "+laptop.getStudent().getName());
		
		/*University u =  session.get(University.class, s.getUniversity().getId());
		
		System.out.println("\n University Info :- "+ u);
		System.out.println("\n Student Info  :- "+ u.getStudent());
		System.out.println("\n Student Name   :- "+u.getStudent().getName());
		*/t.commit();
		

	}
