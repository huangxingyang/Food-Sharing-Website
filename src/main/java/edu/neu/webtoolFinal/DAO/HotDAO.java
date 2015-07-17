package edu.neu.webtoolFinal.DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.neu.webtoolFinal.model.Dish;
import edu.neu.webtoolFinal.model.Hot;
import edu.neu.webtoolFinal.model.User;

public class HotDAO extends DAO{

	public boolean newHot(Dish dish,User user){
		try{
		Session session=getSession();
		session.beginTransaction();
		Hot hot=new Hot();
		hot.setDish(dish);
		hot.setUser(user);
		session.save(hot);
		session.getTransaction().commit();
		session.close();
		return true;
		
		}catch(Exception e){
			System.out.println(e.getMessage());
			
			
		}
		return false;
		
	}
	
	public ArrayList<Hot> getHotByDish(Dish dish){
		Query q=getSession().createQuery("from Hot where dish = :dish");
		q.setEntity("dish", dish);
		return (ArrayList<Hot>) q.list();
		
	}
	

	
	
}
