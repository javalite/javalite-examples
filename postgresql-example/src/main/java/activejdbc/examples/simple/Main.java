package activejdbc.examples.simple;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.connection_config.DBConfiguration;

public class Main {

    public static void main(String[] args) {

        DBConfiguration.loadConfiguration("/database.properties");
        Base.open();

        System.out.println(Base.findAll("select * from people"));

        Person director  = new Person("Stephen Spielberg");
        director.saveIt();

        Person.findAll().dump();

        Base.close();
    }
}
