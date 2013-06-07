package com.deevo.java.server.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.deevo.java.server.EMF;
import com.deevo.java.server.model.entity.Test;

public class TestDao {

	
	public boolean existeTest(Test test) {
		
		EntityManager em = EMF.get().createEntityManager();
		Test test2= null;
	    try {
	      test2 = em.find(Test.class, test.getTestCod());
	    }
	    finally {
	      em.close();
	    }
	    if(test2 == null) return false;
	    
	    return true;
			  }
		


		public void createTest(Test test) {
			
			EntityManager em = EMF.get().createEntityManager();
			EntityTransaction tx = em.getTransaction();

			 try {
				       tx.begin();
				       em.persist(test);
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

			  public Test retrieveTest(Test test) {

				EntityManager em = EMF.get().createEntityManager();

			    Test test2= null;
			    try {
			      test2 = em.find(Test.class, test.getTestCod());
			    }
			    finally {
			      em.close();
			    }
			    return test2;
			  }   
			  
			  
			  @SuppressWarnings("unchecked")
			public List<Test> retrieveTests() {
				  
			    EntityManager em = EMF.get().createEntityManager();	
			    List<Test> list = null;
			   
			    try {
			    	String qery = "SELECT x FROM Test x ";
		            list= em.createQuery(qery).getResultList();
		          //  list = q.getResultList();
			    }catch(Throwable t){
			    	t.printStackTrace();
		        } finally {
		            em.close();
		        }
		        return list;
			  }
			   
			  public Test updateTest(Test test) {
				  
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
			    }
			    finally {
			      em.close();
			    }
			    return test2;
			  }
			  
			  
			  public void deleteTest(Test test) {
				  
			  EntityManager em = EMF.get().createEntityManager();
			  EntityTransaction tx = em.getTransaction();
			    
			    try {
			      tx.begin();
			      em.remove(em.merge(test));
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
