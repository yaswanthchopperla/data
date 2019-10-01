package com.hcl.hib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class MainProg {
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from Employee");
		q.setFirstResult(2);
		q.setMaxResults(2);
		Criteria c=s.createCriteria(Employee.class);
		c.setProjection(Projections.property("name"));
		//c.addOrder(Order.asc("dept"));
		//c.addOrder(Order.desc("name"));
		List<Employee> list=c.list();
//		
//		List<Employee> lst = q.list();
//		for (Object employ : list) {
//			Employee e = (Employee) employ;
//			System.out.println("Employ no..." + e.getEmpno());
//			System.out.println("Employ name..." + e.getName());
//			System.out.println("Employ dept..." + e.getDept());
//			System.out.println("Employ desig..." + e.getDesig());
//			System.out.println("Employ salary.." + e.getBasic());
//			System.out.println();
//		}
		System.out.println(list.toString());
		System.out.println("------------------------------------");
		
		Query query=s.getNamedQuery("HQL_GET_EMPLOYEE_BY_EMPNO");
		query.setInteger("empno", 2);
		Employee emp=(Employee) query.uniqueResult();
		System.out.println(emp);
		
	}
}
