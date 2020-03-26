package hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

/**
 * @author Igor Polevoy
 */
public class InsertAllHibernate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        long start = System.currentTimeMillis();
        System.out.println("Deleted: " + session.createQuery("delete from Employee").executeUpdate() + " records in " + (System.currentTimeMillis() - start) + " milliseconds");


        start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            Employee e = new Employee();
            e.setFirstName("first_name: " + i);
            session.save(e);
        }
        tx.commit();
        System.out.println("Done in " + (System.currentTimeMillis() - start) + " milliseconds");
        session.close();
    }
}
