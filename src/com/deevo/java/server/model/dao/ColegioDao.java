package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

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
		


		public void createColegio(Colegio colegio) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(colegio);
				       em.flush();
				       em.refresh(colegio);
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

	  public Colegio retrieveColegio(Colegio colegio)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Colegio colegio2= null;
	    try {
	      colegio2 = em.find(Colegio.class, colegio.getCodCol());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return colegio2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<Colegio> retrieveColegios() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<Colegio> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM Colegio x ";
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
	   
		  public Colegio updateColegio(Colegio colegio)  throws Throwable {
			  
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
		      throw t;
		    }
		    finally {
		      em.close();
		    }
		    return colegio2;
		  }

}
