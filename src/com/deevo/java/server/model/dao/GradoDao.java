package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.Grado;



public class GradoDao {

	
public boolean existeGrado(Grado grado) {
		
		EntityManager em = EMF.get().createEntityManager();
		Grado grado2= null;
	    try {
	      grado2 = em.find(Grado.class, grado);
	    }
	    finally {
	      em.close();
	    }
	    if(grado2 == null) return false;
	    
	    return true;
		}
		


		public void createGrado(Grado grado) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(grado);
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

	  public Grado retrieveGrado(Grado grado)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Grado grado2= null;
	    try {
	      grado2 = em.find(Grado.class, grado.getCodGrado());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return grado2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<Grado> retrieveGrados() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<Grado> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM Grado x ";
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
	   
		  public Grado updateGrado(Grado grado)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Grado grado2 = null;
		    try {
		     	tx.begin();
		     	grado2 = em.merge(grado);
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
		    return grado2;
		  }

}
