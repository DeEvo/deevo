package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.share.Pregunta;

public class PreguntaDao {

	
	public boolean existePregunta(Pregunta pregunta) {
		
		EntityManager em = EMF.get().createEntityManager();
		Pregunta pregunta2= null;
	    try {
	      pregunta2 = em.find(Pregunta.class, pregunta.getPregCod());
	    }
	    finally {
	      em.close();
	    }
	    if(pregunta2 == null) return false;
	    
	    return true;
			  }
		


		public void createPregunta(Pregunta pregunta) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(pregunta);
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

			  public Pregunta retrievePregunta(Pregunta pregunta) {

				EntityManager em = EMF.get().createEntityManager();

			    Pregunta pregunta2= null;
			    try {
			      pregunta2 = em.find(Pregunta.class, pregunta.getPregCod());
			    }
			    finally {
			      em.close();
			    }
			    return pregunta2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Pregunta> retrievePreguntas() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Pregunta> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Pregunta x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Pregunta updatePregunta(Pregunta pregunta) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    Pregunta pregunta2 = null;
			    try {
			     	tx.begin();
			     	pregunta2 = em.merge(pregunta);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return pregunta2;
			  }
			  
			  
			  public void deletePregunta(Pregunta pregunta) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(pregunta));
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
