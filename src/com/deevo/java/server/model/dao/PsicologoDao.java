package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.Psicologo;


public class PsicologoDao {

	
public boolean existePsicologo(Psicologo psicologo) {
		
		EntityManager em = EMF.get().createEntityManager();
		Psicologo psicologo2= null;
	    try {
	      psicologo2 = em.find(Psicologo.class, psicologo);
	    }
	    finally {
	      em.close();
	    }
	    if(psicologo2 == null) return false;
	    
	    return true;
		}
		


		public void createPsicologo(Psicologo psicologo) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(psicologo);
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

	  public Psicologo retrievePsicologo(Psicologo psicologo)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Psicologo psicologo2= null;
	    try {
	      psicologo2 = em.find(Psicologo.class, psicologo.getPsiCod());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return psicologo2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<Psicologo> retrievePsicologos() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<Psicologo> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM Psicologo x ";
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
	   
		  public Psicologo updatePsicologo(Psicologo psicologo)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Psicologo psicologo2 = null;
		    try {
		     	tx.begin();
		     	psicologo2 = em.merge(psicologo);
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
		    return psicologo2;
		  }


}
