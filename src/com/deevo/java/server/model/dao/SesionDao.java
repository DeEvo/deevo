package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.shared.Sesion;


public class SesionDao {

public boolean existeSesion(Sesion sesion) {
		
		EntityManager em = EMF.get().createEntityManager();
		Sesion sesion2= null;
	    try {
	      sesion2 = em.find(Sesion.class, sesion.getIdSes());
	    }
	    finally {
	      em.close();
	    }
	    if(sesion2 == null) return false;
	    
	    return true;
		}
		


		public void createSesion(Sesion sesion) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(sesion);
				       tx.commit();
				     }catch ( EntityExistsException | RollbackException e){
						 throw new EntityExistsException();
				     }
				     catch (Throwable t) {
				       t.printStackTrace();
				       tx.rollback();
				       throw t;
				     }
				     finally {
				       em.close();
				     }
			  }

	  public Sesion retrieveSesion(Sesion sesion)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Sesion sesion2= null;
	    try {
	      sesion2 = em.find(Sesion.class, sesion.getIdSes());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return sesion2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<Sesion> retrieveSesions() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<Sesion> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM Sesion x ";
	            list= em.createQuery(qery).getResultList();
	          //  list = q.getResultList();
		    }catch(Throwable t){
		    	t.printStackTrace();
		        throw t;
	        } finally {
	            em.close();
	        }
	        return list;
		  }
	   
		  public Sesion updateSesion(Sesion sesion)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Sesion sesion2 = null;
		    try {
		     	tx.begin();
		     	sesion2 = em.merge(sesion);
		     	tx.commit();
		    }
		    catch (Throwable t) {
		      t.printStackTrace();
		      tx.rollback();
		      throw t;
		    }
		    finally {
		      em.close();
		    }
		    return sesion2;
		  }


}
