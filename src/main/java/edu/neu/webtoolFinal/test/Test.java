package edu.neu.webtoolFinal.test;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.neu.webtoolFinal.DAO.CategoryDAO;
import edu.neu.webtoolFinal.DAO.FlavorDAO;
import edu.neu.webtoolFinal.DAO.HibernateUtil;
import edu.neu.webtoolFinal.DAO.RoleDAO;
import edu.neu.webtoolFinal.DAO.UserDAO;
import edu.neu.webtoolFinal.model.Category;
import edu.neu.webtoolFinal.model.Disguess;
import edu.neu.webtoolFinal.model.Flavor;
import edu.neu.webtoolFinal.model.Location;
import edu.neu.webtoolFinal.model.Role;
import edu.neu.webtoolFinal.model.User;

public class Test {

	public static void main(String args[]){
//		FlavorDAO fd=new FlavorDAO();
//		fd.addFlavor("Acid");
//		fd.addFlavor("Sweet");
//		fd.addFlavor("Bitter");
//		fd.addFlavor("Spicy");
//		fd.addFlavor("Salty");
//		
//		ArrayList<Flavor> fs=fd.selectFlavor();
//		for(int i=0;i<fs.size();i++){
//			System.out.println(fs.get(i).getName());
//			
//		}
//		
//		CategoryDAO cd=new CategoryDAO();
//		cd.addCategory("Apptizer");
//		cd.addCategory("Main Course");
//		cd.addCategory("Dissert");
//		cd.addCategory("Soup");

		
//		ArrayList<Category> cs=cd.selectCategory();
//		for(int i=0;i<cs.size();i++){
//			System.out.println(cs.get(i).getName());
//			
//		}
		
//		RoleDAO rd=new RoleDAO();
//		rd.addRole("Customer");	
//		rd.addRole("Admin");
//
//
//		
//		ArrayList<Role> rs=rd.selectRole();
//		for(int i=0;i<rs.size();i++){
//			System.out.println(rs.get(i).getName());
//			
//		}
//		
//		UserDAO ud=new UserDAO();
//		System.out.println("===");
//		System.out.println(ud.checkUserName("aa"));
//		
//		try{
//		Session session=HibernateUtil.getSessionFactory().openSession();
//		//String sql = "delete from Disguess where id=1";
//		Disguess d =(Disguess) session.get(Disguess.class, 2);
//		
//		session.beginTransaction();
//		session.delete(d);
// 
//		//Query query = session.createQuery(sql);
//		
//	//	query.uniqueResult();
//		session.getTransaction().commit();
//		session.close();
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//			
//			
//		}
//			
		Session session=HibernateUtil.getSessionFactory().openSession();
		User u=new User();
		u.setAge(25);
		Date date=new Date();
		u.setDate(date.toGMTString());
		u.setGender("female");
		u.setName("admin");
		u.setPassword("admin");
		Role role=(Role) session.get(Role.class, 2);
		u.setRole(role);
		Location location=(Location)session.get(Location.class, 11);
		u.setLocation(location);
		
	
		session.beginTransaction();
		session.save(u);
	    session.getTransaction().commit();
	    session.close();
		
		
	}
	
	
	
}
