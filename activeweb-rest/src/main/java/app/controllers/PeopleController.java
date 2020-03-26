package app.controllers;

import app.models.Address;
import app.models.Person;
import app.util.JsonHelper;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.RESTful;
import org.javalite.common.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Igor Polevoy on 10/26/14.
 */
@RESTful @SuppressWarnings("unchecked")
public class PeopleController extends APIController {

    public void index(){
        view("people", Person.findAll().include(Address.class).orderBy("id"));
        render().contentType("application/json");
    }

    public void create() throws IOException {
        Map[] people = JsonHelper.toMaps(Util.read(getRequestInputStream()));
        for (Map personMap : people) {
            Person p = new Person();
            p.fromMap(personMap);
            p.saveIt();
            List<Map> addresses  = (List<Map>) personMap.get("addresses");
            for (Map addressMap : addresses) {
                Address address = new Address();
                address.fromMap(addressMap);
                p.add(address);
            }
        }
        view("message", "successfully created people and addresses", "code", 200);
        render("message");
    }

    public void show(){

        List<Person> people = Person.where("id = ?", getId()).include(Address.class);
        if(people.size() == 0)
            throw  new RuntimeException("could not find person with id: " + getId()); //catch by filter

        view("person", people.get(0));
        render("_person"); // unusual use of a partial - we are doing it for reuse
    }
}
