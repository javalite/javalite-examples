package app.models;


import org.javalite.activejdbc.Model;

/**
 * @author Igor Polevoy on 11/23/14.
 */
public class Person extends Model {

    public Person(){}

    public Person(String firstName, String lastName){
        set("first_name", firstName, "last_name", lastName);
    }
}
