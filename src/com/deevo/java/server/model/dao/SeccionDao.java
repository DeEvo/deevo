package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.Seccion;


public class SeccionDao {

	
public boolean existeSeccion(Seccion seccion) {
		
		EntityManager em = EMF.get().createEntityManager();
		Seccion seccion2= null;
	    try {
	      seccion2 = em.find(Seccion.class, seccion.getCodSeccion());
	    }
	    finally {
	      em.close();
	    }
	    if(seccion2 == null) return false;
	    
	    return true;
		}
		


		public void createSeccion(Seccion seccion) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(seccion);
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

	  public Seccion retrieveSeccion(Seccion seccion)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Seccion seccion2= null;
	    try {
	      seccion2 = em.find(Seccion.class, seccion.getCodSeccion());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return seccion2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<Seccion> retrieveSeccions() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<Seccion> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM Seccion x ";
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
	   
		  public Seccion updateSeccion(Seccion seccion)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Seccion seccion2 = null;
		    try {
		     	tx.begin();
		     	seccion2 = em.merge(seccion);
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
		    return seccion2;
		  }


}
