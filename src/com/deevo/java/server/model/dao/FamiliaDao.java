package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.Familia;

public class FamiliaDao {
	
public boolean existeFamilia(Familia familia) {
		
		EntityManager em = EMF.get().createEntityManager();
		Familia familia2= null;
	    try {
	      familia2 = em.find(Familia.class, familia.getId());
	    }
	    finally {
	      em.close();
	    }
	    if(familia2 == null) return false;
	    
	    return true;
			  }
		


		public void createFamilia(Familia familia) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(familia);
				       tx.commit();
				     }catch ( EntityExistsException | RollbackException e){
						 throw new EntityExistsException();
				     }
				     catch (Throwable t) {
				       t.printStackTrace();
				       tx.rollback();
				       throw t;
				     }
				     finally {
				       em.close();
				     }
			  }

			  public Familia retrieveFamilia(Familia familia)  throws Throwable{

				EntityManager em = EMF.get().createEntityManager();

			    Familia familia2= null;
			    try {
			      familia2 = em.find(Familia.class, familia.getId());
			    }catch (Throwable t) {
				       throw t;
				     }
			    finally {
			      em.close();
			    }
			    return familia2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Familia> retrieveFamilias() throws Throwable{
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Familia> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Familia x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
			        throw t;
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Familia updateFamilia(Familia familia)  throws Throwable {
				  
				EntityManager em = EMF.get().createEntityManager();
			    EntityTransaction tx = em.getTransaction();
			    Familia familia2 = null;
			    try {
			     	tx.begin();
			     	familia2 = em.merge(familia);
			     	tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			      throw t;
			    }
			    finally {
			      em.close();
			    }
			    return familia2;
			  }
			  
			  
			  public void deleteFamilia(Familia familia)  throws Throwable  {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(familia));
			      tx.commit();
			    }
			    catch (Throwable t) {
			      t.printStackTrace();
			      tx.rollback();
			      throw t;
			    }
			    finally {
			      em.close();
			    }
			  }


}
