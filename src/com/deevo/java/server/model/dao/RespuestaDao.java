package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.shared.Respuesta;


public class RespuestaDao {

	
public boolean existeRespuesta(Respuesta respuesta) {
		
		EntityManager em = EMF.get().createEntityManager();
		Respuesta respuesta2= null;
	    try {
	      respuesta2 = em.find(Respuesta.class, respuesta.getId());
	    }
	    finally {
	      em.close();
	    }
	    if(respuesta2 == null) return false;
	    
	    return true;
		}
		


		public void createRespuesta(Respuesta respuesta) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(respuesta);
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

	  public Respuesta retrieveRespuesta(Respuesta respuesta)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Respuesta respuesta2= null;
	    try {
	      respuesta2 = em.find(Respuesta.class, respuesta.getId());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return respuesta2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<Respuesta> retrieveRespuestas() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<Respuesta> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM Respuesta x ";
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
	   
		  public Respuesta updateRespuesta(Respuesta respuesta)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Respuesta respuesta2 = null;
		    try {
		     	tx.begin();
		     	respuesta2 = em.merge(respuesta);
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
		    return respuesta2;
		  }


}
