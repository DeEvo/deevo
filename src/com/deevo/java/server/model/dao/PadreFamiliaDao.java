package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.PadreFamilia;



public class PadreFamiliaDao {

	
public boolean existePadreFamilia(PadreFamilia padrefamilia) {
		
		EntityManager em = EMF.get().createEntityManager();
		PadreFamilia padrefamilia2= null;
	    try {
	      padrefamilia2 = em.find(PadreFamilia.class, padrefamilia.getPadCod());
	    }
	    finally {
	      em.close();
	    }
	    if(padrefamilia2 == null) return false;
	    
	    return true;
		}
		


		public void createPadreFamilia(PadreFamilia padrefamilia) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(padrefamilia);
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

	  public PadreFamilia retrievePadreFamilia(PadreFamilia padrefamilia)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    PadreFamilia padrefamilia2= null;
	    try {
	      padrefamilia2 = em.find(PadreFamilia.class, padrefamilia.getPadCod());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return padrefamilia2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<PadreFamilia> retrievePadreFamilias() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<PadreFamilia> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM PadreFamilia x ";
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
	   
		  public PadreFamilia updatePadreFamilia(PadreFamilia padrefamilia)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    PadreFamilia padrefamilia2 = null;
		    try {
		     	tx.begin();
		     	padrefamilia2 = em.merge(padrefamilia);
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
		    return padrefamilia2;
		  }
}
