package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.Profesor;


public class ProfesorDao {

	
public boolean existeProfesor(Profesor profesor) {
		
		EntityManager em = EMF.get().createEntityManager();
		Profesor profesor2= null;
	    try {
	      profesor2 = em.find(Profesor.class, profesor.getProCod());
	    }
	    finally {
	      em.close();
	    }
	    if(profesor2 == null) return false;
	    
	    return true;
		}
		


		public Profesor createProfesor(Profesor profesor) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(profesor);
				       em.flush();
				       em.refresh(profesor);
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
			 return profesor;
			  }

	  public Profesor retrieveProfesor(Profesor profesor)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Profesor profesor2= null;
	    try {
	      profesor2 = em.find(Profesor.class, profesor.getProCod());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return profesor2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<Profesor> retrieveProfesors() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<Profesor> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM Profesor x ";
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
	   
		  public Profesor updateProfesor(Profesor profesor)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Profesor profesor2 = null;
		    try {
		     	tx.begin();
		     	profesor2 = em.merge(profesor);
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
		    return profesor2;
		  }

}
