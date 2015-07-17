package edu.neu.webtoolFinal.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.neu.webtoolFinal.model.Category;
import edu.neu.webtoolFinal.model.Disguess;
import edu.neu.webtoolFinal.model.Dish;
import edu.neu.webtoolFinal.model.Flavor;
import edu.neu.webtoolFinal.model.Hot;
import edu.neu.webtoolFinal.model.Location;
import edu.neu.webtoolFinal.model.PictureForDish;
import edu.neu.webtoolFinal.model.User;

public class DishDAO extends DAO{
    
	
	public ArrayList selectDishByName(String name){
		Session session=getSession();
		Query q=getSession().createQuery("from Dish where name like :name");
			q.setString("name", name);
			
			
	
			return (ArrayList) q.list();
			
			
		} 
	
	public Dish createDish(String name,int price,Category category,Location location,Flavor flavor,User user){
    try{
		Dish dish=new Dish();
		dish.setCategory(category);
		dish.setName(name);
		dish.setUser(user);
		dish.setPrice(price);
		Date date=new Date();
		dish.setUpdateDate(date.toGMTString());

   		dish.setLocation(location);
			

		Session session=getSession();
		session.beginTransaction();
		session.save(dish);
		session.getTransaction().commit();
		session.close();				
		
		return selectDishByNameAndTime(name,date.toGMTString());
    }catch(Exception e){
    	System.out.println(e.getMessage());
    	return null;
    	
    }
		
		
	}
	
	public Dish selectDishByNameAndTime(String name,String date){
		Query q=getSession().createQuery("from Dish where name = :name and updateDate = :date");
		q.setString("name", name);
		q.setString("date", date);
		return (Dish) q.uniqueResult();
		
		
	}
	
	public ArrayList<Dish> selectAllDishes(){
		Query q=getSession().createQuery("from Dish order by updateDate desc");
		ArrayList<Dish> ld=(ArrayList<Dish>) q.list();
		return ld;
		
		
		
	}
	public Dish selectDishByID(int id){
		
		Query q=getSession().createQuery("from Dish where id = :id ");	
		q.setInteger("id", id);
		return (Dish) q.uniqueResult();
		
		
	}
	public ArrayList selectDishByUser(User user){
		Session session=getSession();
		Query q=getSession().createQuery("from Dish where user= :user");
			q.setEntity("user", user);
			
			
	
			return (ArrayList) q.list();
			
			
		}
	public boolean deleteDish(Dish dish){
		//delete all disguess
		//delete all picture
		//delete all hot 
		
	try{
		DiscussDAO dd=new DiscussDAO();
		ArrayList<Disguess> adl=dd.selectDisguess(dish);
		for(int i=0;i<adl.size();i++){
			Session session=getSession();
			session.beginTransaction();
			Disguess d=adl.get(i);
			int x=d.getId();
			Disguess dis =(Disguess) session.get(Disguess.class, x);
			session.delete(dis);
			
			session.getTransaction().commit();
			session.close();
	
		}
		PictureDAO pd=new PictureDAO();
		ArrayList<PictureForDish> pl=pd.selectPictureByDish(dish);
		for(int i=0;i<pl.size();i++){
			Session session=getSession();
			session.beginTransaction();
			int x=pl.get(i).getId();
			PictureForDish pfd=(PictureForDish) session.get(PictureForDish.class, x);
			
			session.delete(pfd);
			session.getTransaction().commit();
			session.close();
		
		}
		HotDAO hd=new HotDAO();
		ArrayList<Hot> hl=hd.getHotByDish(dish);
		for(int i=0;i<hl.size();i++){
			Session session=getSession();
			session.beginTransaction();
			int x=hl.get(i).getId();
			Hot hot=(Hot) session.get(Hot.class, x);
			session.delete(hot);
			session.getTransaction().commit();
			session.close();	

		}
		
		Session session=getSession();
		session.beginTransaction();
		int id=dish.getId();
		Dish dishn=(Dish) session.get(Dish.class, id);
		session.delete(dishn);
		session.getTransaction().commit();
		session.close();
		return true;
		
	}catch (Exception e){
		
		System.out.println(e.getMessage());
		
	}
		
		return false;
		
	}
		
		
		
	}
	
	
	


