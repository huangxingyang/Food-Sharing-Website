package edu.neu.webtoolFinal.DAO;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.neu.webtoolFinal.model.Location;

public class LocationDAO extends DAO{
	
	public Location checkLocation(String location){
		 Session session=getSession();
		 Query q = session.createQuery("from Location where locationInfo = :location");
		 q.setString("location", location);
		
		 Location l=(Location) q.uniqueResult();
	     return l;

		
	}
	
	public Location insertLocation(String locationInfo){
		Session session=getSession();
		Location l=checkLocation(locationInfo);
		if(l==null){
			
			l=new Location();
			l.setLocationInfo(locationInfo);
			session.beginTransaction();
			session.save(l);
			session.getTransaction().commit();
			
			 Query q = session.createQuery("from Location where locationInfo = :location");
			 q.setString("location", locationInfo);
			 l=(Location) q.uniqueResult();
			 session.close();
			 return l;
			 
  		}else{
  			
  			return l;
             
			
		}
		
		
	}

}
