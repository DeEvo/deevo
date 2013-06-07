package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.PadreFamilia;


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
		


		public void createPadreFamilia(PadreFamilia padrefamilia) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(padrefamilia);
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

			  public PadreFamilia retrievePadreFamilia(PadreFamilia padrefamilia) {

				EntityManager em = EMF.get().createEntityManager();

			    PadreFamilia padrefamilia2= null;
			    try {
			      padrefamilia2 = em.find(PadreFamilia.class, padrefamilia.getPadCod());
			    }
			    finally {
			      em.close();
			    }
			    return padrefamilia2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<PadreFamilia> retrievePadreFamilias() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<PadreFamilia> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM PadreFamilia x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public PadreFamilia updatePadreFamilia(PadreFamilia padrefamilia) {
				  
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
			    }
			    finally {
			      em.close();
			    }
			    return padrefamilia2;
			  }
			  
			  
			  public void deletePadreFamilia(PadreFamilia padrefamilia) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(padrefamilia));
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
