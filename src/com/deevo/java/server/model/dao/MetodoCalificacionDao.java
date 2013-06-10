package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.MetodoCalificacion;



public class MetodoCalificacionDao {

	
public boolean existeMetodoCalificacion(MetodoCalificacion metodocalificacion) {
		
		EntityManager em = EMF.get().createEntityManager();
		MetodoCalificacion metodocalificacion2= null;
	    try {
	      metodocalificacion2 = em.find(MetodoCalificacion.class, metodocalificacion);
	    }
	    finally {
	      em.close();
	    }
	    if(metodocalificacion2 == null) return false;
	    
	    return true;
		}
		


		public void createMetodoCalificacion(MetodoCalificacion metodocalificacion) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(metodocalificacion);
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

	  public MetodoCalificacion retrieveMetodoCalificacion(MetodoCalificacion metodocalificacion)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    MetodoCalificacion metodocalificacion2= null;
	    try {
	      metodocalificacion2 = em.find(MetodoCalificacion.class, metodocalificacion.getMetCod());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return metodocalificacion2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<MetodoCalificacion> retrieveMetodoCalificacions() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<MetodoCalificacion> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM MetodoCalificacion x ";
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
	   
		  public MetodoCalificacion updateMetodoCalificacion(MetodoCalificacion metodocalificacion)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    MetodoCalificacion metodocalificacion2 = null;
		    try {
		     	tx.begin();
		     	metodocalificacion2 = em.merge(metodocalificacion);
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
		    return metodocalificacion2;
		  }

}
