package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.AlertaPrivilegio;


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
		


		public void createAlertaPrivilegio(AlertaPrivilegio alertaprivilegio) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(alertaprivilegio);
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

			  public AlertaPrivilegio retrieveAlertaPrivilegio(AlertaPrivilegio alertaprivilegio)  throws Throwable{

				EntityManager em = EMF.get().createEntityManager();

			    AlertaPrivilegio alertaprivilegio2= null;
			    try {
			      alertaprivilegio2 = em.find(AlertaPrivilegio.class, alertaprivilegio.getId());
			    }catch (Throwable t) {
				       throw t;
				     }
			    finally {
			      em.close();
			    }
			    return alertaprivilegio2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<AlertaPrivilegio> retrieveAlertaPrivilegios() throws Throwable{
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<AlertaPrivilegio> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM AlertaPrivilegio x ";
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
			   
			  public AlertaPrivilegio updateAlertaPrivilegio(AlertaPrivilegio alertaprivilegio)  throws Throwable {
				  
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
			      throw t;
			    }
			    finally {
			      em.close();
			    }
			    return alertaprivilegio2;
			  }
			  
			  
			  public void deleteAlertaPrivilegio(AlertaPrivilegio alertaprivilegio)  throws Throwable  {
				  
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
			      throw t;
			    }
			    finally {
			      em.close();
			    }
			  }

}
