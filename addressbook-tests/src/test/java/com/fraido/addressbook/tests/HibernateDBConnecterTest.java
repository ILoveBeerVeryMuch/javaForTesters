package com.fraido.addressbook.tests;

import com.fraido.addressbook.model.GroupData;
import com.fraido.addressbook.model.PersonData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class HibernateDBConnecterTest {

    private SessionFactory sessionFactory;

    @BeforeClass
    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    @Test
    public void HBConnectionGroupDataTest() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData> result = session.createQuery("from GroupData").list();
        for ( GroupData groupData : result ) {
            System.out.println(groupData);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void HBConnectionPersonDataTest() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<PersonData> result = session.createQuery("from PersonData where deprecated = '0000-00-00'").list();
        for ( PersonData personData : result ) {
            System.out.println(personData);
        }
        session.getTransaction().commit();
        session.close();
    }
}
