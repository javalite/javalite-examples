package hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
public class SelectAllHibernate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();        
        long start = System.currentTimeMillis();
        List<Employee> employees = session.createQuery("select e from Employee as e").list();
        for(int i = 0; i < employees.size(); i++){
            Employee e = employees.get(i);
            String name = e.getFirstName();
            if(i % 1000 == 0) System.out.println(e);
        }
        long size =  employees.size();
        System.out.println("Hibernate: Fetched " + size + " records in: " + (System.currentTimeMillis() - start) + " milliseconds");
        session.close();
    }
}
