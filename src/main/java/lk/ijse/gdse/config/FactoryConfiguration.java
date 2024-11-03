package lk.ijse.gdse.config;

import lk.ijse.gdse.Entity.Course;
import lk.ijse.gdse.Entity.Student;
import lk.ijse.gdse.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;
    private FactoryConfiguration(){
        Configuration configuration  = new Configuration().configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration == null)?
                factoryConfiguration = new FactoryConfiguration():factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
