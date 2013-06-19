package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.shared.Curso;



public class CursoDao {

	
public boolean existeCurso(Curso curso) {
		
		EntityManager em = EMF.get().createEntityManager();
		Curso curso2= null;
	    try {
	      curso2 = em.find(Curso.class, curso.getCodCur());
	    }
	    finally {
	      em.close();
	    }
	    if(curso2 == null) return false;
	    
	    return true;
		}
		


		public void createCurso(Curso curso) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(curso);
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

	  public Curso retrieveCurso(Curso curso)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Curso curso2= null;
	    try {
	      curso2 = em.find(Curso.class, curso.getCodCur());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return curso2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<Curso> retrieveCursos() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<Curso> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM Curso x ";
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
	   
		  public Curso updateCurso(Curso curso)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Curso curso2 = null;
		    try {
		     	tx.begin();
		     	curso2 = em.merge(curso);
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
		    return curso2;
		  }

}
