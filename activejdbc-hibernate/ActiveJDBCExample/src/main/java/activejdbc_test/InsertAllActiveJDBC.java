package activejdbc_test;

import org.javalite.activejdbc.Base;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Igor Polevoy
 */
public class InsertAllActiveJDBC {
    public static void main(String[] args) throws SQLException {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test", "root", "p@ssw0rd");
        Base.connection().setAutoCommit(false);

        long start = System.currentTimeMillis();
        int deleted = Employee.deleteAll();
        System.out.println("Deleted " + deleted  + " in " + (System.currentTimeMillis() - start) + " milliseconds");

        start = System.currentTimeMillis();
        for(int i = 0; i < 50000; i++){
            Employee.createIt("first_name", "name: " + i);
            //if (i % 1000 == 0) System.out.println(i);
        }
        Base.connection().commit();
        System.out.println("Done in " + (System.currentTimeMillis() - start) + " milliseconds");
        Base.close();
    }
}
