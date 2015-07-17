package edu.neu.webtoolFinal.DAO;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.neu.webtoolFinal.model.Disguess;
import edu.neu.webtoolFinal.model.Dish;
import edu.neu.webtoolFinal.model.User;

public class DiscussDAO extends DAO{

	public Disguess addNewDiscuss(User user,Dish dish, String text){
		Disguess dis=new Disguess();
		Date date=new Date();
		dis.setDish(dish);
		dis.setText(text);
		dis.setUser(user);
		dis.setDate(date.toGMTString());
		
       try{
    	   Session session=getSession();
    	   session.beginTransaction();
    	   session.save(dis);
    	   session.getTransaction().commit();
    	   session.close();
    	   
    	   return getDisgussByDishAndDATE(dish, date.toGMTString());
    	   
       }
       catch(Exception e){
    	   System.out.println(e.getMessage());
    	   
       }
		return null;
	}
	
	public ArrayList<Disguess> selectDisguess(Dish dish){
		Query q=getSession().createQuery("from Disguess where dish = :dish");
		q.setEntity("dish", dish);
		return (ArrayList<Disguess>) q.list();
		
		
	}
	
	public Disguess getDisgussByDishAndDATE(Dish dish,String date){
		Query q=getSession().createQuery("from Disguess where dish = :dish and date = :date");
		q.setEntity("dish", dish);
		q.setString("date", date);
		
		return (Disguess) q.uniqueResult();
		
		
		
	}
	public Disguess selectDiscussById(int id){
		try{
			Query q=getSession().createQuery("from Disguess where id = :id");
			q.setInteger("id", id);
			return (Disguess) q.uniqueResult();
			
			
			
			
		}catch (Exception e){
			
			System.out.println(e.getMessage());
			
		}
		
		return null;
		
		
		
		
	}
	
	public void deleteDiscuss(Disguess d){
		Session session=getSession();
		session.beginTransaction();
		Disguess ds=(Disguess) session.get(Disguess.class,d.getId());
		session.delete(ds);
		session.getTransaction().commit();
		session.close();
		
		
		
	}
	
	
	
}
