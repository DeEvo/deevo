package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.shared.CursoHabilitado;



public class CursoHabilitadoDao {

	
public boolean existeCursoHabilitado(CursoHabilitado cursohabilitado) {
		
		EntityManager em = EMF.get().createEntityManager();
		CursoHabilitado cursohabilitado2= null;
	    try {
	      cursohabilitado2 = em.find(CursoHabilitado.class, cursohabilitado.getCurHabCod());
	    }
	    finally {
	      em.close();
	    }
	    if(cursohabilitado2 == null) return false;
	    
	    return true;
		}
		


		public void createCursoHabilitado(CursoHabilitado cursohabilitado) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(cursohabilitado);
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

	  public CursoHabilitado retrieveCursoHabilitado(CursoHabilitado cursohabilitado)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    CursoHabilitado cursohabilitado2= null;
	    try {
	      cursohabilitado2 = em.find(CursoHabilitado.class, cursohabilitado.getCurHabCod());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return cursohabilitado2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<CursoHabilitado> retrieveCursoHabilitados() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<CursoHabilitado> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM CursoHabilitado x ";
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
	   
		  public CursoHabilitado updateCursoHabilitado(CursoHabilitado cursohabilitado)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    CursoHabilitado cursohabilitado2 = null;
		    try {
		     	tx.begin();
		     	cursohabilitado2 = em.merge(cursohabilitado);
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
		    return cursohabilitado2;
		  }

}
