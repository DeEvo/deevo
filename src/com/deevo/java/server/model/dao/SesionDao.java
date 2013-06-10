package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.share.Sesion;

public class SesionDao {

	
	public boolean existeSesion(Sesion sesion) {
		
		EntityManager em = EMF.get().createEntityManager();
		Sesion sesion2= null;
	    try {
	      sesion2 = em.find(Sesion.class, sesion.getIdSes());
	    }
	    finally {
	      em.close();
	    }
	    if(sesion2 == null) return false;
	    
	    return true;
			  }
		


		public void createSesion(Sesion sesion) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(sesion);
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

			  public Sesion retrieveSesion(Sesion sesion) {

				EntityManager em = EMF.get().createEntityManager();

			    Sesion sesion2= null;
			    try {
			      sesion2 = em.find(Sesion.class, sesion.getIdSes());
			    }
			    finally {
			      em.close();
			    }
			    return sesion2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Sesion> retrieveSesions() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Sesion> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Sesion x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Sesion updateSesion(Sesion sesion) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    Sesion sesion2 = null;
			    try {
			     	tx.begin();
			     	sesion2 = em.merge(sesion);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return sesion2;
			  }
			  
			  
			  public void deleteSesion(Sesion sesion) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(sesion));
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
