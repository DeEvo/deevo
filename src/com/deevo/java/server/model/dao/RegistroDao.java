package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.share.Registro;

public class RegistroDao {

	
	public boolean existeRegistro(Registro registro) {
		
		EntityManager em = EMF.get().createEntityManager();
		Registro registro2= null;
	    try {
	      registro2 = em.find(Registro.class, registro.getIdReg());
	    }
	    finally {
	      em.close();
	    }
	    if(registro2 == null) return false;
	    
	    return true;
			  }
		


		public void createRegistro(Registro registro) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(registro);
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

			  public Registro retrieveRegistro(Registro registro) {

				EntityManager em = EMF.get().createEntityManager();

			    Registro registro2= null;
			    try {
			      registro2 = em.find(Registro.class, registro.getIdReg());
			    }
			    finally {
			      em.close();
			    }
			    return registro2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Registro> retrieveRegistros() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Registro> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Registro x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Registro updateRegistro(Registro registro) {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    Registro registro2 = null;
			    try {
			     	tx.begin();
			     	registro2 = em.merge(registro);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			    }
			    finally {
			      em.close();
			    }
			    return registro2;
			  }
			  
			  
			  public void deleteRegistro(Registro registro) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(registro));
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
