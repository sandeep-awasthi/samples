package com.test.jpa21;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class EntityManagerUtil
{
   public static EntityManagerFactory getEntityManagerFactory()
   {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21unit");
      return emf;
   }
}