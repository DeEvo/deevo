package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.Psicologo;

public class PsicologoDao {

	
	public boolean existePsicologo(Psicologo psicologo) {
		
		EntityManager em = EMF.get().createEntityManager();
		Psicologo psicologo2= null;
	    try {
	      psicologo2 = em.find(Psicologo.class, psicologo.getPsiCod());
	    }
	    finally {
	      em.close();
	    }
	    if(psicologo2 == null) return false;
	    
	    return true;
			  }
		


		public void createPsicologo(Psicologo psicologo) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(psicologo);
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

			  public Psicologo retrievePsicologo(Psicologo psicologo) {

				EntityManager em = EMF.get().createEntityManager();

			    Psicologo psicologo2= null;
			    try {
			      psicologo2 = em.find(Psicologo.class, psicologo.getPsiCod());
			    }
			    finally {
			      em.close();
			    }
			    return psicologo2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Psicologo> retrievePsicologos() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Psicologo> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Psicologo x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Psicologo updatePsicologo(Psicologo psicologo) {
				  
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
			    }
			    finally {
			      em.close();
			    }
			    return psicologo2;
			  }
			  
			  
			  public void deletePsicologo(Psicologo psicologo) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(psicologo));
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
