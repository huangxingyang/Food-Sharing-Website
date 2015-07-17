package edu.neu.webtoolFinal.DAO;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.neu.webtoolFinal.model.Location;
import edu.neu.webtoolFinal.model.Role;
import edu.neu.webtoolFinal.model.User;

public class UserDAO extends DAO{

	public boolean CreateUser(String name,String gender,int age,Location location,Role role,String password ){
		//check location and role before create user;
		try{
			
			
			
		Date date=new Date();
		User user=new User();
		user.setAge(age);
		user.setPassword(password);
		user.setDate(date.toGMTString());
		user.setGender(gender);
		user.setName(name);
		user.setRole(role);
		user.setLocation(location);
		
		Session session=getSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return true;
		
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}
		return false;
	}
	public boolean checkUserName(String name){
		Session session=getSession();
//		Query q=session.createQuery("from User");
		Query q=session.createQuery("from User where name = :name");
		q.setString("name", name);
		if(q.list().size()!=0){
			
			return false;			
		}
		return true;
	
	}
	
	public User selectUserByUserNameAndPassword(String username,String password){
		
		Session session=getSession();
		Query q=session.createQuery("from User where name = :name and password = :password");
		q.setString("name", username);
		q.setString("password", password);
		User u=(User) q.uniqueResult();
		
		return u;
	}
	

	
}
