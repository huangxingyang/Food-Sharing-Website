package edu.neu.webtoolFinal.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DAO {
     
   public Session getSession(){
	   return HibernateUtil.getSessionFactory().openSession();
   }
   @Autowired 
   protected DAO() {
   }


   protected void begin() {
       getSession().beginTransaction();
   }

   protected void commit() {
       getSession().getTransaction().commit();
   }

   protected void rollback() {
       try {
           getSession().getTransaction().rollback();
       } catch (HibernateException e) {
          
       }
       try {
           getSession().close();
       } catch (HibernateException e) {
          
       }
      
   }

   public  void close() {
       getSession().close();
   }
	
	
}
