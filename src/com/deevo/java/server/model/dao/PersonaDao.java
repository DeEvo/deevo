package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.Persona;

public class PersonaDao {

	
	public boolean existePersona(Persona persona) {
		
		EntityManager em = EMF.get().createEntityManager();
		Persona persona2= null;
	    try {
	      persona2 = em.find(Persona.class, persona.getPerDni());
	    }
	    finally {
	      em.close();
	    }
	    if(persona2 == null) return false;
	    
	    return true;
			  }
		


		public void createPersona(Persona persona) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(persona);
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

			  public Persona retrievePersona(Persona persona) {

				EntityManager em = EMF.get().createEntityManager();

			    Persona persona2= null;
			    try {
			      persona2 = em.find(Persona.class, persona.getPerNom());
			    }
			    finally {
			      em.close();
			    }
			    return persona2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Persona> retrievePersonas() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Persona> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Persona x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Persona updatePersona(Persona persona) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    Persona persona2 = null;
			    try {
			     	tx.begin();
			     	persona2 = em.merge(persona);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return persona2;
			  }
			  
			  
			  public void deletePersona(Persona persona) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(persona));
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
