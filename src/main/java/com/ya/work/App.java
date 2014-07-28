package com.ya.work;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("manager");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Date d = new Date();
       SimpleDateFormat frmd = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        try {
            d= frmd.parse("22.12.2014 11:22");
        } catch (ParseException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        // User user= new User("IvanKA",d,2);
        //  entityManager.persist(user);
        List li = entityManager.createQuery("SELECT u FROM Department u").getResultList();
     
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }
}
