package app.models;

import org.javalite.activejdbc.Model;

/**
 * @author Igor Polevoy on 10/26/14.
 */
public class Address extends Model {
    public Address(String addressType, String address1, String address2, String city, String state, String zip ){
        set("address_type", addressType, "address1", address1, "address2", address2, "city", city, "state", state, "zip", zip);
    }
    public Address(){}
}
