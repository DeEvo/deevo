package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

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
		


		public void createPeriodoAcademico(PeriodoAcademico periodoacademico) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(periodoacademico);
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

	  public PeriodoAcademico retrievePeriodoAcademico(PeriodoAcademico periodoacademico)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    PeriodoAcademico periodoacademico2= null;
	    try {
	      periodoacademico2 = em.find(PeriodoAcademico.class, periodoacademico.getCodPer());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return periodoacademico2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<PeriodoAcademico> retrievePeriodoAcademicos() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<PeriodoAcademico> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM PeriodoAcademico x ";
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
	   
		  public PeriodoAcademico updatePeriodoAcademico(PeriodoAcademico periodoacademico)  throws Throwable {
			  
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
		      throw t;
		    }
		    finally {
		      em.close();
		    }
		    return periodoacademico2;
		  }

}
