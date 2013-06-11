package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.deevo.java.server.EMF;
import com.deevo.java.share.TestPrivilegio;

public class TestPrivilegioDao {

	
public boolean existeTestPrivilegio(TestPrivilegio testprivilegio) {
		
		EntityManager em = EMF.get().createEntityManager();
		TestPrivilegio testprivilegio2= null;
	    try {
	      testprivilegio2 = em.find(TestPrivilegio.class, testprivilegio);
	    }
	    finally {
	      em.close();
	    }
	    if(testprivilegio2 == null) return false;
	    
	    return true;
		}
		


		public void createTestPrivilegio(TestPrivilegio testprivilegio) throws EntityExistsException , Throwable {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();
		
			 try {
				       tx.begin();
				       em.persist(testprivilegio);
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

	  public TestPrivilegio retrieveTestPrivilegio(TestPrivilegio testprivilegio)  throws Throwable{

		EntityManager em = EMF.get().createEntityManager();

	    TestPrivilegio testprivilegio2= null;
	    try {
	      testprivilegio2 = em.find(TestPrivilegio.class, testprivilegio.getId());
	    }catch (Throwable t) {
		       throw t;
		     }
	    finally {
	      em.close();
	    }
	    return testprivilegio2;
	  }   
	  
	  
		  @SuppressWarnings("unchecked")
		public List<TestPrivilegio> retrieveTestPrivilegios() throws Throwable{
			  
		    EntityManager em = EMF.get().createEntityManager();	
		    List<TestPrivilegio> list = null;
		   
		    try {
		    	String qery = "SELECT x FROM TestPrivilegio x ";
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
	   
		  public TestPrivilegio updateTestPrivilegio(TestPrivilegio testprivilegio)  throws Throwable {
			  
			EntityManager em = EMF.get().createEntityManager();
		    EntityTransaction tx = em.getTransaction();
		    TestPrivilegio testprivilegio2 = null;
		    try {
		     	tx.begin();
		     	testprivilegio2 = em.merge(testprivilegio);
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
		    return testprivilegio2;
		  }


}
