package database.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.util.Properties;
import java.util.function.Function;

/**
 * Created by Xyrephon on 4/19/2017.
 */
public class HibernateUtil {
    private static SessionFactory factory;

    private static void init()
    {
        Configuration config = new Configuration();
        config.addAnnotatedClass(ContactInfo.class);
        config.addAnnotatedClass(Participant.class);
        Properties props = config.getProperties();
        props.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        props.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/survey?zeroDateTimeBehaviour=convertToNull");
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.setProperty("hibernate.connection.username", "surveyApp");
        props.setProperty("hibernate.connection.password", "$t@rcr@ft2");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(props);
        factory = config.buildSessionFactory(ssrb.build());
    }

    public static SessionFactory getFactory()
    {
        if(factory == null)
        {
            init();
        }
        return factory;
    }

    public interface QueryInput<R>
    {
        R query(Session session) throws Exception;
    }

    public static <R> R query(QueryInput<R> process) throws Exception
    {
        Session session = null;
        Transaction tx = null;

        try
        {
            session = getFactory().openSession();
            tx = session.beginTransaction();
            R rez = process.query(session);
            tx.commit();
            tx = null;

            return rez;
        }
        catch(Exception error)
        {
            if(tx != null)
            {
                tx.rollback();
            }
            throw error;
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }
    }

    public static <R> R notifyQuery(QueryInput<R> process)
    {
        try
        {
            return query(process);
        }
        catch(Exception error)
        {
            JOptionPane.showMessageDialog(null, error.getMessage());
            error.printStackTrace();
        }
        return null;
    }
}
