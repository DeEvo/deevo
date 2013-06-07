package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.GradoSeccion;


public class GradoSeccionDao {

	
	public boolean existeGradoSeccion(GradoSeccion gradoseccion) {
		
		EntityManager em = EMF.get().createEntityManager();
		GradoSeccion gradoseccion2= null;
	    try {
	      gradoseccion2 = em.find(GradoSeccion.class, gradoseccion.getId());
	    }
	    finally {
	      em.close();
	    }
	    if(gradoseccion2 == null) return false;
	    
	    return true;
			  }
		


		public void createGradoSeccion(GradoSeccion gradoseccion) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(gradoseccion);
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

			  public GradoSeccion retrieveGradoSeccion(GradoSeccion gradoseccion) {

				EntityManager em = EMF.get().createEntityManager();

			    GradoSeccion gradoseccion2= null;
			    try {
			      gradoseccion2 = em.find(GradoSeccion.class, gradoseccion.getId());
			    }
			    finally {
			      em.close();
			    }
			    return gradoseccion2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<GradoSeccion> retrieveGradoSeccions() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<GradoSeccion> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM GradoSeccion x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public GradoSeccion updateGradoSeccion(GradoSeccion gradoseccion) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    GradoSeccion gradoseccion2 = null;
			    try {
			     	tx.begin();
			     	gradoseccion2 = em.merge(gradoseccion);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return gradoseccion2;
			  }
			  
			  
			  public void deleteGradoSeccion(GradoSeccion gradoseccion) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(gradoseccion));
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
