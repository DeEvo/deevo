package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.share.Respuesta;

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
		


		public void createRespuesta(Respuesta respuesta) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(respuesta);
				       tx.commit();
				     }
				     catch (Throwable t) {
				       t.printStackTrace();
				       tx.rollback();
				     }
				     finally {
				       em.close();
				     }
			  }

			  public Respuesta retrieveRespuesta(Respuesta respuesta) {

				EntityManager em = EMF.get().createEntityManager();

			    Respuesta respuesta2= null;
			    try {
			      respuesta2 = em.find(Respuesta.class, respuesta.getId());
			    }
			    finally {
			      em.close();
			    }
			    return respuesta2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Respuesta> retrieveRespuestas() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Respuesta> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Respuesta x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Respuesta updateRespuesta(Respuesta respuesta) {
				  
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
			    }
			    finally {
			      em.close();
			    }
			    return respuesta2;
			  }
			  
			  
			  public void deleteRespuesta(Respuesta respuesta) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(respuesta));
			      tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			  }

}
