package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.MetodoCalificacion;


public class MetodoCalificacionDao {

	
	public boolean existeMetodoCalificacion(MetodoCalificacion metodocalificacion) {
		
		EntityManager em = EMF.get().createEntityManager();
		MetodoCalificacion metodocalificacion2= null;
	    try {
	      metodocalificacion2 = em.find(MetodoCalificacion.class, metodocalificacion.getMetCod());
	    }
	    finally {
	      em.close();
	    }
	    if(metodocalificacion2 == null) return false;
	    
	    return true;
			  }
		


		public void createMetodoCalificacion(MetodoCalificacion metodocalificacion) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(metodocalificacion);
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

			  public MetodoCalificacion retrieveMetodoCalificacion(MetodoCalificacion metodocalificacion) {

				EntityManager em = EMF.get().createEntityManager();

			    MetodoCalificacion metodocalificacion2= null;
			    try {
			      metodocalificacion2 = em.find(MetodoCalificacion.class, metodocalificacion.getMetCod());
			    }
			    finally {
			      em.close();
			    }
			    return metodocalificacion2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<MetodoCalificacion> retrieveMetodoCalificacions() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<MetodoCalificacion> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM MetodoCalificacion x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public MetodoCalificacion updateMetodoCalificacion(MetodoCalificacion metodocalificacion) {
				  
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
			    }
			    finally {
			      em.close();
			    }
			    return metodocalificacion2;
			  }
			  
			  
			  public void deleteMetodoCalificacion(MetodoCalificacion metodocalificacion) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(metodocalificacion));
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
