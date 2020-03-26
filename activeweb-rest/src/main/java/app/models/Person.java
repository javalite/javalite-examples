package app.models;

import org.javalite.activejdbc.Model;

import java.util.List;

/**
 * @author Igor Polevoy on 10/25/14.
 */
public class Person extends Model {
    public Person(String firstName, String lastName){
        set("first_name", firstName, "last_name", lastName);
    }
    public Person(){}

    public List<Address> getAddresses(){
        return getAll(Address.class);
    }
}
