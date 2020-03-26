package activejdbc_test;

import org.javalite.activejdbc.Base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Igor Polevoy
 */
public class JDBCvsMongo {


    public static void main(String[] args) throws SQLException {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test", "root", "p@ssw0rd");


        long start = System.currentTimeMillis();
        int deleted = Employee.deleteAll();
        System.out.println("Deleted " + deleted + " in " + (System.currentTimeMillis() - start) + " milliseconds");

        start = System.currentTimeMillis();

        Statement s = Base.connection().createStatement();
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 100000; i++) {
                s.addBatch("insert into employees(name) values ('employee" + j + "_" + i + "')");                
            }
            s.executeBatch();
            System.out.println("Executed batch: " + j);
        }


        System.out.println("Done in " + (System.currentTimeMillis() - start) + " milliseconds");
        Base.close();
    }

}
