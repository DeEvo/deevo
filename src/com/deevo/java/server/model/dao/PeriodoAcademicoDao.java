package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.share.PeriodoAcademico;


public class PeriodoAcademicoDao {

	
	public boolean existePeriodoAcademico(PeriodoAcademico periodoacademico) {
		
		EntityManager em = EMF.get().createEntityManager();
		PeriodoAcademico periodoacademico2= null;
	    try {
	      periodoacademico2 = em.find(PeriodoAcademico.class, periodoacademico.getCodPer());
	    }
	    finally {
	      em.close();
	    }
	    if(periodoacademico2 == null) return false;
	    
	    return true;
			  }
		


		public void createPeriodoAcademico(PeriodoAcademico periodoacademico) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(periodoacademico);
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

			  public PeriodoAcademico retrievePeriodoAcademico(PeriodoAcademico periodoacademico) {

				EntityManager em = EMF.get().createEntityManager();

			    PeriodoAcademico periodoacademico2= null;
			    try {
			      periodoacademico2 = em.find(PeriodoAcademico.class, periodoacademico.getCodPer());
			    }
			    finally {
			      em.close();
			    }
			    return periodoacademico2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<PeriodoAcademico> retrievePeriodoAcademicos() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<PeriodoAcademico> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM PeriodoAcademico x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public PeriodoAcademico updatePeriodoAcademico(PeriodoAcademico periodoacademico) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    PeriodoAcademico periodoacademico2 = null;
			    try {
			     	tx.begin();
			     	periodoacademico2 = em.merge(periodoacademico);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return periodoacademico2;
			  }
			  
			  
			  public void deletePeriodoAcademico(PeriodoAcademico periodoacademico) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(periodoacademico));
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
