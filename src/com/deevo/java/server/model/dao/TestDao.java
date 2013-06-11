package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.Test;


public class TestDao {

	
public boolean existeTest(Test test) {
		
		EntityManager em = EMF.get().createEntityManager();
		Test test2= null;
	    try {
	      test2 = em.find(Test.class, test);
	    }
	    finally {
	      em.close();
	    }
	    if(test2 == null) return false;
	    
	    return true;
		}
		


		public void createTest(Test test) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(test);
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

	  public Test retrieveTest(Test test)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    Test test2= null;
	    try {
	      test2 = em.find(Test.class, test.getTestCod());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return test2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<Test> retrieveTests() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<Test> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM Test x ";
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
	   
		  public Test updateTest(Test test)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    Test test2 = null;
		    try {
		     	tx.begin();
		     	test2 = em.merge(test);
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
		    return test2;
		  }


}
