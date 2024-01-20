package org.example;

import org.example.beans.Alien;
import org.example.beans.AlienName;
import org.example.beans.Laptop;
import org.example.beans.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        /* uncomment this for 1 and 2
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();*/


        /* 1. basic demo to save objects. Change type of setaName and var in ALien to String rather than AlienName

        Alien alien1 = new Alien();
        alien1.setAlienId(1);
        alien1.setaName("don");
        alien1.setColor("Blue");

        Transaction transaction1 = session.beginTransaction();
        session.save(alien1);
        transaction1.commit();*/


       /* 2.demo to save embeddable object. Set type of setaName and var in Alien to AlienName rather than String

        AlienName alienName = new AlienName();
        alienName.setfName("first");
        alienName.setlName("last");
        alienName.setmName("mid");

        Alien alien = new Alien();
        alien.setAlienId(1);
        alien.setaName(alienName);
        alien.setColor("Green");

        Transaction transaction = session.beginTransaction();
        session.save(alien);
        transaction.commit();*/




        /*3. one to one demo

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Laptop laptop1 = new Laptop();
        laptop1.setlId(1);
        laptop1.setlName("HP");

        Laptop laptop2 = new Laptop();
        laptop2.setlId(2);
        laptop2.setlName("Dell");

        Transaction transaction1 = session.beginTransaction();
        session.save(laptop1);
        transaction1.commit();

        Transaction transaction2 = session.beginTransaction();
        session.save(laptop2);
        transaction2.commit();

        Student student1 = new Student();
        student1.setRollNo(1);
        student1.setsName("A");
        student1.setsMarks(40);
        student1.setLaptop(laptop1);

        Student student2 = new Student();
        student2.setRollNo(2);
        student2.setsName("B");
        student2.setsMarks(45);
        student2.setLaptop(laptop2);

        Transaction transaction3 = session.beginTransaction();
        session.save(student1);
        transaction3.commit();

        Transaction transaction4 = session.beginTransaction();
        session.save(student2);
        transaction4.commit();*/


         /*4. one to many demo with three tables
         student, laptop, student_laptop


        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Laptop laptop1 = new Laptop();
        laptop1.setlId(1);
        laptop1.setlName("HP");

        Laptop laptop2 = new Laptop();
        laptop2.setlId(2);
        laptop2.setlName("Dell");

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(laptop1);
        laptops.add(laptop2);

        Student student1 = new Student();
        student1.setRollNo(1);
        student1.setsName("A");
        student1.setsMarks(40);
        student1.setLaptop(laptops);

        Transaction transaction1 = session.beginTransaction();
        session.save(laptop1);
        session.save(laptop2);
        transaction1.commit();

        Transaction transaction2 = session.beginTransaction();
        session.save(student1);
        transaction2.commit();*/


         /*4. one to many demo with two tables
         student, laptop


        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Laptop laptop1 = new Laptop();
        laptop1.setlId(1);
        laptop1.setlName("HP");

        Laptop laptop2 = new Laptop();
        laptop2.setlId(2);
        laptop2.setlName("Dell");

        Laptop laptop3 = new Laptop();
        laptop3.setlId(3);
        laptop3.setlName("Mac");

        Student student1 = new Student();
        student1.setRollNo(1);
        student1.setsName("A");
        student1.setsMarks(40);
        student1.getLaptop().add(laptop1);
        student1.getLaptop().add(laptop2);

        Student student2 = new Student();
        student2.setRollNo(2);
        student2.setsName("B");
        student2.setsMarks(45);
        student2.getLaptop().add(laptop3);

        laptop1.setStudent(student1);
        laptop2.setStudent(student1);
        laptop3.setStudent(student2);


        Transaction transaction = session.beginTransaction();
        session.save(laptop1);
        session.save(laptop2);
        session.save(laptop3);
        session.save(student1);
        session.save(student2);
        transaction.commit(); */


        /*5. many to many demo

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Laptop laptop1 = new Laptop();
        laptop1.setlId(1);
        laptop1.setlName("HP");

        Student student1 = new Student();
        student1.setRollNo(1);
        student1.setsName("A");
        student1.setsMarks(40);

        student1.getLaptop().add(laptop1);

        laptop1.getStudent().add(student1);

        Transaction transaction = session.beginTransaction();
        session.save(laptop1);
        session.save(student1);
        transaction.commit(); */


        // 6. fetch methods eager and lazy


        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

//        Laptop laptop1 = new Laptop();
//        laptop1.setlId(1);
//        laptop1.setlName("HP");
//
//        Laptop laptop2 = new Laptop();
//        laptop2.setlId(2);
//        laptop2.setlName("Dell");
//
//        Laptop laptop3 = new Laptop();
//        laptop3.setlId(3);
//        laptop3.setlName("Mac");
//
//        Student student1 = new Student();
//        student1.setRollNo(1);
//        student1.setsName("A");
//        student1.setsMarks(40);
//        student1.getLaptop().add(laptop1);
//        student1.getLaptop().add(laptop2);
//
//        Student student2 = new Student();
//        student2.setRollNo(2);
//        student2.setsName("B");
//        student2.setsMarks(45);
//        student2.getLaptop().add(laptop3);
//
//        laptop1.setStudent(student1);
//        laptop2.setStudent(student1);
//        laptop3.setStudent(student2);
//
//
//        Transaction transaction = session.beginTransaction();
//        session.save(laptop1);
//        session.save(laptop2);
//        session.save(laptop3);
//        session.save(student1);
//        session.save(student2);
//        transaction.commit();

        Transaction transaction1 = session.beginTransaction();
       /* Lazy fetching values
        it is firing query for laptops only when we want it

        Student s1 = session.get(Student.class,1);
        System.out.println(s1.getsName());
        // above will only fetch values for Student and not laptops even though it has laptop
        Collection<Laptop> laps = s1.getLaptop();
        for(Laptop l : laps) {
            System.out.println(l.getlId()+" "+l.getlName());
        }*/

        // eager fetching values (added fetch = FetchType.EAGER in Student)
        Student s2 = session.get(Student.class,1);
        System.out.println(s2.getsName());
        transaction1.commit();
    }
}