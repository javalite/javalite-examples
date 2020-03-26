package activejdbc_test;

import org.javalite.activejdbc.Base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Igor Polevoy
 */
public class JDBC {
    public static void main(String[] args) throws SQLException {

        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test", "root", "p@ssw0rd");


        long start = System.currentTimeMillis();
        Statement s = Base.connection().createStatement();
        ResultSet rs = s.executeQuery("select * from employees");
        for(int i = 0; rs.next();i++){
            String name = rs.getString("name");
            int id = rs.getInt("id");
            if(i % 1000 == 0) System.out.println("Name: " + name + ", id: " + id);
        }

        System.out.println("Fetched records in: " + (System.currentTimeMillis() - start));
        Base.close();
    }

}
