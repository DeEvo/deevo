package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.EstadoTipo;



public class EstadoTipoDao {

	
public boolean existeEstadoTipo(EstadoTipo estadotipo) {
		
		EntityManager em = EMF.get().createEntityManager();
		EstadoTipo estadotipo2= null;
	    try {
	      estadotipo2 = em.find(EstadoTipo.class, estadotipo);
	    }
	    finally {
	      em.close();
	    }
	    if(estadotipo2 == null) return false;
	    
	    return true;
		}
		


		public void createEstadoTipo(EstadoTipo estadotipo) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(estadotipo);
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

	  public EstadoTipo retrieveEstadoTipo(EstadoTipo estadotipo)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    EstadoTipo estadotipo2= null;
	    try {
	      estadotipo2 = em.find(EstadoTipo.class, estadotipo.getCodEstTipo());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return estadotipo2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<EstadoTipo> retrieveEstadoTipos() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<EstadoTipo> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM EstadoTipo x ";
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
	   
		  public EstadoTipo updateEstadoTipo(EstadoTipo estadotipo)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    EstadoTipo estadotipo2 = null;
		    try {
		     	tx.begin();
		     	estadotipo2 = em.merge(estadotipo);
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
		    return estadotipo2;
		  }

}
