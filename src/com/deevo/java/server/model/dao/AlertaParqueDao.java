package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.AlertaParque;

public class AlertaParqueDao {

	
	public boolean existeAlertaParque(AlertaParque alertaparque) {
		
		EntityManager em = EMF.get().createEntityManager();
		AlertaParque alertaparque2= null;
	    try {
	      alertaparque2 = em.find(AlertaParque.class, alertaparque);
	    }
	    finally {
	      em.close();
	    }
	    if(alertaparque2 == null) return false;
	    
	    return true;
			  }
		


		public void createAlertaParque(AlertaParque alertaparque) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(alertaparque);
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

			  public AlertaParque retrieveAlertaParque(AlertaParque alerparque) {

				EntityManager em = EMF.get().createEntityManager();

			    AlertaParque alertaparque= null;
			    try {
			      alertaparque = em.find(AlertaParque.class, alerparque.getAleCod());
			    }
			    finally {
			      em.close();
			    }
			    return alertaparque;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<AlertaParque> retrieveAlertaParques() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<AlertaParque> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM AlertaParque x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public AlertaParque updateAlertaParque(AlertaParque alertaparque) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    AlertaParque alertaparque2 = null;
			    try {
			     	tx.begin();
			     	alertaparque2 = em.merge(alertaparque);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return alertaparque2;
			  }
			  
			  
			  public void deleteAlertaParque(AlertaParque alertaparque) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(alertaparque));
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
