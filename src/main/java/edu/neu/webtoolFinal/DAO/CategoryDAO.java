package edu.neu.webtoolFinal.DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.neu.webtoolFinal.model.Category;
import edu.neu.webtoolFinal.model.Flavor;

public class CategoryDAO extends DAO{
	
	public boolean addCategory(String name){
		try{
		if((!"".equals(name))||(name!=null))
			
		{
			Category ca=new Category();
			ca.setName(name);
			Session session=getSession();
			session.beginTransaction();
			session.save(ca);
			session.getTransaction().commit();
			session.close();
		    return true;
		}
		}catch (Exception e){
			
			System.out.println(e.getMessage());
			
			
		}
		return false;
		
		
		
	}
	
	public Category selectCategoryByName(String Name){
		
		
		Query q = getSession().createQuery("from Category where name = :name");
		q.setString("name", Name);
		Category c=(Category) q.uniqueResult();
		return c;
		
	}
	public ArrayList<Category> selectCategory(){
		
		
		Query q = getSession().createQuery("from Category");
		ArrayList<Category> cs=(ArrayList<Category>) q.list();
		return cs;
		
	}

}
