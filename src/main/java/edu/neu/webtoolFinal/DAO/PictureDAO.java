package edu.neu.webtoolFinal.DAO;

import java.util.ArrayList;
import java.util.Date;






import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.neu.webtoolFinal.model.Dish;
import edu.neu.webtoolFinal.model.Picture;
import edu.neu.webtoolFinal.model.PictureForDish;
import edu.neu.webtoolFinal.model.PictureForUser;
import edu.neu.webtoolFinal.model.User;

public class PictureDAO extends DAO{
	public boolean createPictureForDish(String name,Dish dish,String type){
		try{
		PictureForDish pd=new PictureForDish();
		Date date=new Date();
		pd.setDate(date.toGMTString());
		pd.setDish(dish);
		pd.setType(type);
		pd.setUrl(name);
		Session session=getSession();
		session.beginTransaction();
		session.save(pd);
		session.getTransaction().commit();
		session.close();
		return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
			
		}
		
		
	}
	public boolean creatPictureForUser(String url,User user,String type){
		try{
		PictureForUser pfu=new PictureForUser();
		Date date=new Date();
		pfu.setDate(date.toGMTString());
		pfu.setType(type);
		pfu.setUrl(url);
		pfu.setUser(user);
		Session session=getSession();
		session.beginTransaction();
		session.save(pfu);
		session.getTransaction().commit();
		session.close();
		return true;
		
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
			
			
		}
		
		
		
		
		
	}
    public ArrayList<PictureForDish> selectPictureByDish(Dish dish){
    	Query q=getSession().createQuery("from PictureForDish where dish = :dish ");
    	q.setEntity("dish", dish);
    	ArrayList<PictureForDish> al=(ArrayList<PictureForDish>) q.list();
    	return al;
    	
    	
    	
    }
    public String selectPictureByUser(User user){
    	Query q=getSession().createQuery("from PictureForUser where user = :user order by date desc");
    	q.setEntity("user", user);
    	
    	ArrayList<PictureForUser> al=(ArrayList<PictureForUser>) q.list();
    	if(al.size()==0){
    		return "";
    		
    	}
    	return al.get(0).getUrl();
    	
    	
    	
    	
    }
	

}
