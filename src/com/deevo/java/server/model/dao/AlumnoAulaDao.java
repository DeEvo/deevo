package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.AlumnoAula;


public class AlumnoAulaDao {

	
	public boolean existeAlumnoAula(AlumnoAula alumnoaula) {
		
		EntityManager em = EMF.get().createEntityManager();
		AlumnoAula alumnoaula2= null;
	    try {
	      alumnoaula2 = em.find(AlumnoAula.class, alumnoaula.getId());
	    }
	    finally {
	      em.close();
	    }
	    if(alumnoaula2 == null) return false;
	    
	    return true;
			  }
		


		public void createAlumnoAula(AlumnoAula alumnoaula) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(alumnoaula);
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

			  public AlumnoAula retrieveAlumnoAula(AlumnoAula alumnoaula) {

				EntityManager em = EMF.get().createEntityManager();

			    AlumnoAula alumnoaula2= null;
			    try {
			      alumnoaula2 = em.find(AlumnoAula.class, alumnoaula.getId());
			    }
			    finally {
			      em.close();
			    }
			    return alumnoaula2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<AlumnoAula> retrieveAlumnoAulas() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<AlumnoAula> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM AlumnoAula x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public AlumnoAula updateAlumnoAula(AlumnoAula alumnoaula) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    AlumnoAula alumnoaula2 = null;
			    try {
			     	tx.begin();
			     	alumnoaula2 = em.merge(alumnoaula);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return alumnoaula2;
			  }
			  
			  
			  public void deleteAlumnoAula(AlumnoAula alumnoaula) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(alumnoaula));
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