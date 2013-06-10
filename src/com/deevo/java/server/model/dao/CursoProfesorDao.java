package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.CursoProfesor;



public class CursoProfesorDao {

public boolean existeCursoProfesor(CursoProfesor cursoprofesor) {
		
		EntityManager em = EMF.get().createEntityManager();
		CursoProfesor cursoprofesor2= null;
	    try {
	      cursoprofesor2 = em.find(CursoProfesor.class, cursoprofesor);
	    }
	    finally {
	      em.close();
	    }
	    if(cursoprofesor2 == null) return false;
	    
	    return true;
		}
		


		public void createCursoProfesor(CursoProfesor cursoprofesor) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(cursoprofesor);
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

	  public CursoProfesor retrieveCursoProfesor(CursoProfesor cursoprofesor)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    CursoProfesor cursoprofesor2= null;
	    try {
	      cursoprofesor2 = em.find(CursoProfesor.class, cursoprofesor.getId());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return cursoprofesor2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<CursoProfesor> retrieveCursoProfesors() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<CursoProfesor> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM CursoProfesor x ";
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
	   
		  public CursoProfesor updateCursoProfesor(CursoProfesor cursoprofesor)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    CursoProfesor cursoprofesor2 = null;
		    try {
		     	tx.begin();
		     	cursoprofesor2 = em.merge(cursoprofesor);
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
		    return cursoprofesor2;
		  }

}
