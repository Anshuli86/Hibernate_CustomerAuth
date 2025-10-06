package com.user;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Customer1;
import org.hibernate.query.Query;

public class Test {
	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ss=sf.openSession();
		
		Scanner s=new Scanner(System.in);
		while(true) {
			System.out.println("------------------Welcome to Customer Auth Service-----------------------");
			System.out.println("1.Register yourself\n2.Login to portal\n3.Logout");
			System.out.println("Enter Your Choice");
			int ch=s.nextInt();
			
			switch (ch) {
			case 1: 
				Customer1 c1=new Customer1();
				System.out.println("Enter your name:");
				c1.setName(s.next()+s.nextLine());
				System.out.println("Enter email:");
				c1.setEmail(s.next());
				System.out.println("Enter mobNo:");
				c1.setMobNo(s.nextLong());
				System.out.println("Enter your age:");
				c1.setAge(s.nextInt());
				
				c1.setTimeStamp(new Date());
				c1.setUsername(c1.getName()+"@auth");
				c1.setPassword(UUID.randomUUID().toString().substring(0, 8));
				
				Transaction tx1 = ss.beginTransaction();  
                ss.persist(c1);                            
                tx1.commit(); 
				System.out.println("User registered succesfully....\nYou can use below credentials to login");
				System.out.println("UserName:"+c1.getUsername());
				System.out.println("Password:"+c1.getPassword());
				break;
			
			case 2:
				String retriveAll="from Customer1";
				Query<Customer1> query =ss.createQuery(retriveAll, Customer1.class);
				List<Customer1> list=query.getResultList();
				System.out.println("Enter username to login:");
				String un=s.next();
				boolean flag=false;
				Customer1 log=null;
				for(Customer1 cs:list) {
					if(un.equals(cs.getUsername())) {
						flag=true;
						log=cs;
						break;
					}
				}
				if(flag) {
					System.out.println("Enter password to login:");
					String ps=s.next();
					if(ps.equals(log.getPassword())) {
						System.out.println("Login done.......");
					}else {
						System.out.println("Password Incorrect............");
					}	
				}else {
					System.out.println("user not found");
				}
				break;
				
			case 3:
				System.out.println("Enter your registration id:");
				int id=s.nextInt();
				Customer1 customer=ss.find(Customer1.class, id);
				if(customer!=null) {
					Transaction tx3 = ss.beginTransaction();
                    ss.remove(customer);                     
                    tx3.commit(); 
					System.out.println("Not registered with us.......");
					continue;
				}
				System.exit(0);
	
			default:
				System.out.println("Wrong input");
			}
		}
	}
}
