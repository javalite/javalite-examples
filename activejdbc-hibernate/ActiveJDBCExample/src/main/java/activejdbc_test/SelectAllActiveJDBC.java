package activejdbc_test;

import org.javalite.activejdbc.Base;

import java.util.List;

public class SelectAllActiveJDBC {
    public static void main(String[] args) {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test", "root", "p@ssw0rd");
        Employee.count();
        long start = System.currentTimeMillis();
        List<Employee> employees = Employee.findAll();
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            String name = e.getString("first_name");
            if (i % 1000 == 0) System.out.println(e);
        }
        long size = employees.size();
        System.out.println("ActiveJDBC: Fetched " + size + " records in: " + (System.currentTimeMillis() - start) + " milliseconds");
        Base.close();
    }
}
