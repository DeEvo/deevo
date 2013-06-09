package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.share.Aula;


public class AulaDao {

	
	public boolean existeAula(Aula aula) {
		
		EntityManager em = EMF.get().createEntityManager();
		Aula aula2= null;
	    try {
	      aula2 = em.find(Aula.class, aula.getCodAula());
	    }
	    finally {
	      em.close();
	    }
	    if(aula2 == null) return false;
	    
	    return true;
			  }
		


		public void createAula(Aula aula) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(aula);
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

			  public Aula retrieveAula(Aula aula) {

				EntityManager em = EMF.get().createEntityManager();

			    Aula aula2= null;
			    try {
			      aula2 = em.find(Aula.class, aula.getCodAula());
			    }
			    finally {
			      em.close();
			    }
			    return aula2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Aula> retrieveAulas() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Aula> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Aula x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Aula updateAula(Aula aula) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    Aula aula2 = null;
			    try {
			     	tx.begin();
			     	aula2 = em.merge(aula);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return aula2;
			  }
			  
			  
			  public void deleteAula(Aula aula) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(aula));
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
