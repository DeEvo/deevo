package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.Alumno;


public class AlumnoDao {

	
	public boolean existeAlumno(Alumno alumno) {
		
		EntityManager em = EMF.get().createEntityManager();
		Alumno alumno2= null;
	    try {
	      alumno2 = em.find(Alumno.class, alumno.getAluCod());
	    }
	    finally {
	      em.close();
	    }
	    if(alumno2 == null) return false;
	    
	    return true;
			  }
		


		public void createAlumno(Alumno alumno) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(alumno);
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

			  public Alumno retrieveAlumno(Alumno alumno) {

				EntityManager em = EMF.get().createEntityManager();

			    Alumno alumno2= null;
			    try {
			      alumno2 = em.find(Alumno.class, alumno.getAluCod());
			    }
			    finally {
			      em.close();
			    }
			    return alumno2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Alumno> retrieveAlumnos() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Alumno> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Alumno x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Alumno updateAlumno(Alumno alumno) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    Alumno alumno2 = null;
			    try {
			     	tx.begin();
			     	alumno2 = em.merge(alumno);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return alumno2;
			  }
			  
			  
			  public void deleteAlumno(Alumno alumno) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(alumno));
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
