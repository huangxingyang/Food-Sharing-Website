package edu.neu.webtoolFinal.DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.neu.webtoolFinal.model.Flavor;

public class FlavorDAO extends DAO{

	public boolean addFlavor(String name){
		try{
		if((!"".equals(name))||(name!=null))
			
		{
			Flavor flavor=new Flavor();
			flavor.setName(name);
			Session session=getSession();
			session.beginTransaction();
			session.save(flavor);
			session.getTransaction().commit();
			session.close();
		    return true;
		}
		}catch (Exception e){
			
			System.out.println(e.getMessage());
			
			
		}
		return false;
		
		
		
	}
	public ArrayList<Flavor> selectFlavor(){
		
		
		Query q = getSession().createQuery("from Flavor");
		ArrayList<Flavor> fs=(ArrayList<Flavor>) q.list();
		return fs;
		
	}
	
	public Flavor selectFlavorByName(String name){
		Query q=getSession().createQuery("from Flavor where name = :name");
		q.setString("name", name);
		Flavor f=(Flavor) q.uniqueResult();
		return f;
		
		
		
	}
	
	
}
