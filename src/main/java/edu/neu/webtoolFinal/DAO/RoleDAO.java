package edu.neu.webtoolFinal.DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.neu.webtoolFinal.model.Flavor;
import edu.neu.webtoolFinal.model.Role;

public class RoleDAO extends DAO{

	public boolean addRole(String name){
		try{
		if((!"".equals(name))||(name!=null))
			
		{
			Role r=new Role();
			r.setName(name);
			Session session=getSession();
			session.beginTransaction();
			session.save(r);
			session.getTransaction().commit();
			session.close();
		    return true;
		}
		}catch (Exception e){
			
			System.out.println(e.getMessage());
			
			
		}
		return false;
		
		
		
	}
	public ArrayList<Role> selectRole(){
		
		
		Query q = getSession().createQuery("from Role");
		ArrayList<Role> rs=(ArrayList<Role>) q.list();
		return rs;
		
	}
	
	public Role getRoleByName(String name){
		Query q = getSession().createQuery("from Role where name=:name");
		q.setString("name", name);
		Role role=(Role) q.uniqueResult();
		return role;
		
		
		
	}
	
}
