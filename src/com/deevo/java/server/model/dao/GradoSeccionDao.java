package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.GradoSeccion;


public class GradoSeccionDao {

	
	public boolean existeGradoSeccion(GradoSeccion gradoseccion) {
		
		EntityManager em = EMF.get().createEntityManager();
		GradoSeccion gradoseccion2= null;
	    try {
	      gradoseccion2 = em.find(GradoSeccion.class, gradoseccion.getId());
	    }
	    finally {
	      em.close();
	    }
	    if(gradoseccion2 == null) return false;
	    
	    return true;
		}
		


		public void createGradoSeccion(GradoSeccion gradoseccion) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(gradoseccion);
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

	  public GradoSeccion retrieveGradoSeccion(GradoSeccion gradoseccion)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    GradoSeccion gradoseccion2= null;
	    try {
	      gradoseccion2 = em.find(GradoSeccion.class, gradoseccion.getId());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return gradoseccion2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<GradoSeccion> retrieveGradoSeccions() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<GradoSeccion> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM GradoSeccion x ";
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
	   
		  public GradoSeccion updateGradoSeccion(GradoSeccion gradoseccion)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    GradoSeccion gradoseccion2 = null;
		    try {
		     	tx.begin();
		     	gradoseccion2 = em.merge(gradoseccion);
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
		    return gradoseccion2;
		  }


}
