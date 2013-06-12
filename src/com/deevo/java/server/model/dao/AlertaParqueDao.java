package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.AlertaParque;


public class AlertaParqueDao {

	
public boolean existeAlertaParque(AlertaParque alertaparque) {
		
		EntityManager em = EMF.get().createEntityManager();
		AlertaParque alertaparque2= null;
	    try {
	      alertaparque2 = em.find(AlertaParque.class, alertaparque.getAleCod());
	    }
	    finally {
	      em.close();
	    }
	    if(alertaparque2 == null) return false;
	    
	    return true;
			  }
		


		public void createAlertaParque(AlertaParque alertaparque) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(alertaparque);
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

			  public AlertaParque retrieveAlertaParque(AlertaParque alertaparque)  throws Throwable{

				EntityManager em = EMF.get().createEntityManager();

			    AlertaParque alertaparque2= null;
			    try {
			      alertaparque2 = em.find(AlertaParque.class, alertaparque.getAleCod());
			    }catch (Throwable t) {
				       throw t;
				     }
			    finally {
			      em.close();
			    }
			    return alertaparque2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<AlertaParque> retrieveAlertaParques() throws Throwable{
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<AlertaParque> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM AlertaParque x ";
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
			   
			  public AlertaParque updateAlertaParque(AlertaParque alertaparque)  throws Throwable {
				  
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
			      throw t;
			    }
			    finally {
			      em.close();
			    }
			    return alertaparque2;
			  }
			  
			  
			  public void deleteAlertaParque(AlertaParque alertaparque)  throws Throwable  {
				  
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
			      throw t;
			    }
			    finally {
			      em.close();
			    }
			  }

}
