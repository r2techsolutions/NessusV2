package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 06/01/12
 * Time: 10:05
 * To change this template use File | Settings | File Templates.
 */
public class HibernateFactory {
    private static SessionFactory sessionFactory;
  
    /**
     * Constructs a new Singleton SessionFactory
     * @return
     * @throws HibernateException
     */
    public static SessionFactory buildSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();  
        configuration.configure("hibernate.cfg.xml");  
         
        Properties properties = configuration.getProperties();
         
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();          
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
         
        return sessionFactory;  
    }

    /**
     * Builds a SessionFactory, if it hasn't been already.
     */
    public static SessionFactory buildIfNeeded() throws HibernateException {
        if (sessionFactory != null) {
            return sessionFactory;
        }
        
        return buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() throws HibernateException {
        buildIfNeeded();
        return sessionFactory.openSession();
    }

    public static void closeFactory() throws HibernateException {
        if (sessionFactory != null) {
           sessionFactory.close();        
        }
    }

    public static void close(Session session) throws HibernateException {
        if (session != null) {
            session.close();
        }
    }
    
    public static void rollback(Transaction tx) throws HibernateException {
        if (tx != null) {
            tx.rollback();
        }      
    }
    
}

