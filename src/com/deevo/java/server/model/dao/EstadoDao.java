package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.Estado;


public class EstadoDao {

	
	public boolean existeEstado(Estado estado) {
		
		EntityManager em = EMF.get().createEntityManager();
		Estado estado2= null;
	    try {
	      estado2 = em.find(Estado.class, estado.getId());
	    }
	    finally {
	      em.close();
	    }
	    if(estado2 == null) return false;
	    
	    return true;
			  }
		


		public void createEstado(Estado estado) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(estado);
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

			  public Estado retrieveEstado(Estado estado) {

				EntityManager em = EMF.get().createEntityManager();

			    Estado estado2= null;
			    try {
			      estado2 = em.find(Estado.class, estado.getId());
			    }
			    finally {
			      em.close();
			    }
			    return estado2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Estado> retrieveEstados() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Estado> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Estado x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Estado updateEstado(Estado estado) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    Estado estado2 = null;
			    try {
			     	tx.begin();
			     	estado2 = em.merge(estado);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return estado2;
			  }
			  
			  
			  public void deleteEstado(Estado estado) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(estado));
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
