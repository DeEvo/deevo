package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.share.CursoProfesor;


public class CursoProfesorDao {

	
	public boolean existeCursoProfesor(CursoProfesor cursohabilitado) {
		
		EntityManager em = EMF.get().createEntityManager();
		CursoProfesor cursohabilitado2= null;
	    try {
	      cursohabilitado2 = em.find(CursoProfesor.class, cursohabilitado.getId());
	    }
	    finally {
	      em.close();
	    }
	    if(cursohabilitado2 == null) return false;
	    
	    return true;
			  }
		


		public void createCursoProfesor(CursoProfesor cursohabilitado) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(cursohabilitado);
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

			  public CursoProfesor retrieveCursoProfesor(CursoProfesor cursohabilitado) {

				EntityManager em = EMF.get().createEntityManager();

			    CursoProfesor cursohabilitado2= null;
			    try {
			      cursohabilitado2 = em.find(CursoProfesor.class, cursohabilitado.getId());
			    }
			    finally {
			      em.close();
			    }
			    return cursohabilitado2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<CursoProfesor> retrieveCursoProfesors() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<CursoProfesor> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM CursoProfesor x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public CursoProfesor updateCursoProfesor(CursoProfesor cursohabilitado) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    CursoProfesor cursohabilitado2 = null;
			    try {
			     	tx.begin();
			     	cursohabilitado2 = em.merge(cursohabilitado);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return cursohabilitado2;
			  }
			  
			  
			  public void deleteCursoProfesor(CursoProfesor cursohabilitado) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(cursohabilitado));
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
