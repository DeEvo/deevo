package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.ColegioProfesor;


public class ColegioProfesorDao {

	
	public boolean existeColegioProfesor(ColegioProfesor colegioprofesor) {
		
		EntityManager em = EMF.get().createEntityManager();
		ColegioProfesor colegioprofesor2= null;
	    try {
	      colegioprofesor2 = em.find(ColegioProfesor.class, colegioprofesor.getId());
	    }
	    finally {
	      em.close();
	    }
	    if(colegioprofesor2 == null) return false;
	    
	    return true;
			  }
		


		public void createColegioProfesor(ColegioProfesor colegioprofesor) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(colegioprofesor);
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

			  public ColegioProfesor retrieveColegioProfesor(ColegioProfesor colegioprofesor) {

				EntityManager em = EMF.get().createEntityManager();

			    ColegioProfesor colegioprofesor2= null;
			    try {
			      colegioprofesor2 = em.find(ColegioProfesor.class, colegioprofesor.getId());
			    }
			    finally {
			      em.close();
			    }
			    return colegioprofesor2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<ColegioProfesor> retrieveColegioProfesors() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<ColegioProfesor> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM ColegioProfesor x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public ColegioProfesor updateColegioProfesor(ColegioProfesor colegioprofesor) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    ColegioProfesor colegioprofesor2 = null;
			    try {
			     	tx.begin();
			     	colegioprofesor2 = em.merge(colegioprofesor);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return colegioprofesor2;
			  }
			  
			  
			  public void deleteColegioProfesor(ColegioProfesor colegioprofesor) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(colegioprofesor));
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
