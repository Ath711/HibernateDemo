package org.example;

import org.example.beans.Alien;
import org.example.constants.JDBCConstants;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.sql.*;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {



        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();


        Alien alien = new Alien();
        alien.setAlienId(1);
        alien.setaName("tom");
        alien.setColor("Green");

        Alien alien1 = new Alien();
        alien1.setAlienId(2);
        alien1.setaName("don");
        alien1.setColor("Blue");

        Transaction transaction = session.beginTransaction();
        session.save(alien);
        transaction.commit();

        Transaction transaction1 = session.beginTransaction();
        session.save(alien1);
        transaction1.commit();



//        Connection connection = DriverManager.getConnection(JDBCConstants.url, JDBCConstants.username, JDBCConstants.password);
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("Select * from alien");
//
//        while (resultSet.next()) {
//            System.out.println(resultSet.getInt(1) + "\n");
//            System.out.println(resultSet.getString(2) + "\n");
//            System.out.println(resultSet.getString(3));
//        }


    }
}
