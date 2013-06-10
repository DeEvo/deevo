package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.share.Curso;


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
		


		public void createCurso(Curso curso) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(curso);
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

			  public Curso retrieveCurso(Curso curso) {

				EntityManager em = EMF.get().createEntityManager();

			    Curso curso2= null;
			    try {
			      curso2 = em.find(Curso.class, curso.getCodCur());
			    }
			    finally {
			      em.close();
			    }
			    return curso2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Curso> retrieveCursos() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Curso> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Curso x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Curso updateCurso(Curso curso) {
				  
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
			    }
			    finally {
			      em.close();
			    }
			    return curso2;
			  }
			  
			  
			  public void deleteCurso(Curso curso) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(curso));
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
