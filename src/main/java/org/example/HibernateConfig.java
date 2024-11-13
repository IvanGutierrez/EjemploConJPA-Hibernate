package org.example;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateConfig {

    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final String CONFIG_PATH = "src/main/resources/hibernate.properties";
    private static SessionFactory buildSessionFactory(){
        var properties = new Properties();
        try {
            properties.load(new FileInputStream(CONFIG_PATH));
            return new Configuration()
                    .mergeProperties(properties)
                    .buildSessionFactory();
        } catch (Throwable throwable){
            System.err.println(throwable.getMessage());
            throw new ExceptionInInitializerError(throwable);
        }
    }

    public static void shutdown(){
        getSessionFactory().close();
    }

}
