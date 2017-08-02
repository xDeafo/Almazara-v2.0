package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UtilesHibernate {

    private static final SessionFactory sessionFactory;

    static {
        try {

            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Inicia una transacci�n sobre la sesi�n en curso
     */
    public static void inicio() {
        Session sesion = getSession();
        if (!sesion.getTransaction().isActive()) {
            sesion.beginTransaction();
        }
    }

    /**
     * Realiza commit sobre la transacci�n actual
     */
    public static void commit() {
        if (getTransaction().isActive()) {
            getTransaction().commit();
        }
    }

    /**
     * Realiza el rollback sobre la transacci�n actual
     */
    public static void rollback() {
        if (getTransaction().isActive()) {
            getTransaction().rollback();
        }
    }

    /**
     * Devuelve la Session actual
     *
     * @return la sesion
     */
    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    /**
     * Devuelve la transacci�n en curso
     *
     * @return la transacci�n en curso
     */
    public static Transaction getTransaction() {
        return getSession().getTransaction();
    }

}
