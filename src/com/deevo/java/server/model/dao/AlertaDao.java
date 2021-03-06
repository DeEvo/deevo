package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.shared.Alerta;

public class AlertaDao {

	
	public boolean existeAlerta(Alerta alerta) {
		
		EntityManager em = EMF.get().createEntityManager();
		Alerta alerta2= null;
	    try {
	      alerta2 = em.find(Alerta.class, alerta.getAleCod());
	    }
	    finally {
	      em.close();
	    }
	    if(alerta2 == null) return false;
	    
	    return true;
			  }
		


		public void createAlerta(Alerta alerta) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(alerta);
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

			  public Alerta retrieveAlerta(Alerta alerta)  throws Throwable{

				EntityManager em = EMF.get().createEntityManager();

			    Alerta alerta2= null;
			    try {
			      alerta2 = em.find(Alerta.class, alerta.getAleCod());
			    }catch (Throwable t) {
				       throw t;
				     }
			    finally {
			      em.close();
			    }
			    return alerta2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Alerta> retrieveAlertas() throws Throwable{
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Alerta> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Alerta x ";
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
			   
			  public Alerta updateAlerta(Alerta alerta)  throws Throwable {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    Alerta alerta2 = null;
			    try {
			     	tx.begin();
			     	alerta2 = em.merge(alerta);
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
			    return alerta2;
			  }
			  
			  
			  public void deleteAlerta(Alerta alerta)  throws Throwable  {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(alerta));
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
