package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.share.Grado;


public class GradoDao {

	
	public boolean existeGrado(Grado grado) {
		
		EntityManager em = EMF.get().createEntityManager();
		Grado grado2= null;
	    try {
	      grado2 = em.find(Grado.class, grado.getCodGrado());
	    }
	    finally {
	      em.close();
	    }
	    if(grado2 == null) return false;
	    
	    return true;
			  }
		


		public void createGrado(Grado grado) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(grado);
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

			  public Grado retrieveGrado(Grado grado) {

				EntityManager em = EMF.get().createEntityManager();

			    Grado grado2= null;
			    try {
			      grado2 = em.find(Grado.class, grado.getCodGrado());
			    }
			    finally {
			      em.close();
			    }
			    return grado2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Grado> retrieveGrados() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Grado> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Grado x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Grado updateGrado(Grado grado) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    Grado grado2 = null;
			    try {
			     	tx.begin();
			     	grado2 = em.merge(grado);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return grado2;
			  }
			  
			  
			  public void deleteGrado(Grado grado) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(grado));
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
