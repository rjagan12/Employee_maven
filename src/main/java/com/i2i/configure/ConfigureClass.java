package com.i2i.configure;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.i2i.model.Trainer;
import com.i2i.model.Trainee;

public class ConfigureClass {

    private static SessionFactory factory;
    private static Logger logger = LoggerFactory.getLogger(ConfigureClass.class);

    public static SessionFactory getFactory() {

        try {
            factory = new Configuration().configure().
                             addPackage("com.i2i.model").
                             addAnnotatedClass(Trainee.class).
                             addAnnotatedClass(Trainer.class).buildSessionFactory();

        } catch (Throwable e) {
            logger.error("Failed to create sessoionFactory object"+"{}", e);
            throw new ExceptionInInitializerError(e);
        }
        return factory;
    }
}