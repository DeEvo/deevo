package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.TestPrivilegio;

public class TestPrivilegioDao {

	
	public boolean existeTestPrivilegio(TestPrivilegio testprivilegio) {
		
		EntityManager em = EMF.get().createEntityManager();
		TestPrivilegio testprivilegio2= null;
	    try {
	      testprivilegio2 = em.find(TestPrivilegio.class, testprivilegio.getId());
	    }
	    finally {
	      em.close();
	    }
	    if(testprivilegio2 == null) return false;
	    
	    return true;
			  }
		


		public void createTestPrivilegio(TestPrivilegio testprivilegio) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(testprivilegio);
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

			  public TestPrivilegio retrieveTestPrivilegio(TestPrivilegio testprivilegio) {

				EntityManager em = EMF.get().createEntityManager();

			    TestPrivilegio testprivilegio2= null;
			    try {
			      testprivilegio2 = em.find(TestPrivilegio.class, testprivilegio.getId());
			    }
			    finally {
			      em.close();
			    }
			    return testprivilegio2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<TestPrivilegio> retrieveTestPrivilegios() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<TestPrivilegio> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM TestPrivilegio x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public TestPrivilegio updateTestPrivilegio(TestPrivilegio testprivilegio) {
				  
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
			    }
			    finally {
			      em.close();
			    }
			    return testprivilegio2;
			  }
			  
			  
			  public void deleteTestPrivilegio(TestPrivilegio testprivilegio) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(testprivilegio));
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
