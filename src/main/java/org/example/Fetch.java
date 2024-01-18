package org.example;

import org.example.beans.Alien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Fetch {

    public static void main(String[] args) {

        Alien alien; // here Hibernate is responsible for initializing the alien object by fetching it from the database
        // Hibernate retrieves the entity from the database. If it doesn't find the entity with the given ID, it returns null.
        // In this case, since the ID is 1, and we have previously saved an Alien object with ID 1 in the App class, the alien variable in the Fetch class is assigned a non-null value.
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        alien = session.get(Alien.class, 1);
        transaction.commit();
        System.out.println(alien.getAlienId() + " " + alien.getaName() + " " + alien.getColor());

    }
}
