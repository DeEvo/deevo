package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.share.Colegio;


public class ColegioDao {

	
	public boolean existeColegio(Colegio colegio) {
		
		EntityManager em = EMF.get().createEntityManager();
		Colegio colegio2= null;
	    try {
	      colegio2 = em.find(Colegio.class, colegio.getCodCol());
	    }
	    finally {
	      em.close();
	    }
	    if(colegio2 == null) return false;
	    
	    return true;
			  }
		


		public void createColegio(Colegio colegio) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(colegio);
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

			  public Colegio retrieveColegio(Colegio colegio) {

				EntityManager em = EMF.get().createEntityManager();

			    Colegio colegio2= null;
			    try {
			      colegio2 = em.find(Colegio.class, colegio.getCodCol());
			    }
			    finally {
			      em.close();
			    }
			    return colegio2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Colegio> retrieveColegios() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Colegio> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Colegio x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Colegio updateColegio(Colegio colegio) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    Colegio colegio2 = null;
			    try {
			     	tx.begin();
			     	colegio2 = em.merge(colegio);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return colegio2;
			  }
			  
			  
			  public void deleteColegio(Colegio colegio) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(colegio));
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
