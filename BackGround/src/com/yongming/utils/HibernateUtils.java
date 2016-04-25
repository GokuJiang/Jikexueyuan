package com.yongming.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by jiangyongming on 4/24/16.
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory;
    private static Session session;

    static {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry  = builder.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    /**
     * 获取session对象
     */
    public static Session getSession(){
        return sessionFactory.openSession();
    }
    /**
     * 关闭session对象
     */
    public static void closeSession(){
        if(session!=null&&session.isOpen()){
            session.close();
        }
    }

    public static void closeSession(Session session){
        if(session!=null&&session.isOpen()){
            session.close();
        }
    }
}
