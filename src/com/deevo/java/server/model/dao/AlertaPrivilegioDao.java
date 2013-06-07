package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.AlertaPrivilegio;

public class AlertaPrivilegioDao {

	
	public boolean existeAlertaPrivilegio(AlertaPrivilegio alertaprivilegio) {
		
		EntityManager em = EMF.get().createEntityManager();
		AlertaPrivilegio alertaprivilegio2= null;
	    try {
	      alertaprivilegio2 = em.find(AlertaPrivilegio.class, alertaprivilegio.getId());
	    }
	    finally {
	      em.close();
	    }
	    if(alertaprivilegio2 == null) return false;
	    
	    return true;
			  }
		


		public void createAlertaPrivilegio(AlertaPrivilegio alertaprivilegio) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(alertaprivilegio);
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

			  public AlertaPrivilegio retrieveAlertaPrivilegio(AlertaPrivilegio alertaprivilegio) {

				EntityManager em = EMF.get().createEntityManager();

			    AlertaPrivilegio alertaprivilegio2= null;
			    try {
			      alertaprivilegio2 = em.find(AlertaPrivilegio.class, alertaprivilegio.getId());
			    }
			    finally {
			      em.close();
			    }
			    return alertaprivilegio2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<AlertaPrivilegio> retrieveAlertaPrivilegios() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<AlertaPrivilegio> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM AlertaPrivilegio x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public AlertaPrivilegio updateAlertaPrivilegio(AlertaPrivilegio alertaprivilegio) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    AlertaPrivilegio alertaprivilegio2 = null;
			    try {
			     	tx.begin();
			     	alertaprivilegio2 = em.merge(alertaprivilegio);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return alertaprivilegio2;
			  }
			  
			  
			  public void deleteAlertaPrivilegio(AlertaPrivilegio alertaprivilegio) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(alertaprivilegio));
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
