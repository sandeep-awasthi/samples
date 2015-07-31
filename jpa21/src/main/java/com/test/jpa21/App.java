package com.test.jpa21;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
 
public class App {
    public static void main(String[] args) {
        EntityManager em = null;
        try {
            em = EntityManagerUtil.getEntityManagerFactory()
                    .createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
 
            Dept d1 = new Dept();
            d1.setDeptName("Production");
 
            Dept d2 = new Dept();
            d2.setDeptName("Marketing");
 
            Emp e1 = new Emp();
            e1.setFirstName("First Name 1");
            e1.setLastName("Last Name 1");
            e1.setDept(d1);
 
            Emp e2 = new Emp();
            e1.setFirstName("First Name 2");
            e1.setLastName("Last Name 2");
            e1.setDept(d1);
            e2.setDept(d2);
 
            em.persist(d1); // Department d1 must be persisted before employee
                            // because employee e1 refers department
            em.persist(d2);
            em.persist(e1);
            em.persist(e2);
            transaction.commit();
            
            System.out.println("Object 0");
            System.out.println("Generated ID is: " + e1.getEmpId());
        } finally {
            if (em != null)
                try {
                    em.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }
    }
}