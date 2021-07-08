package app.controllers;

import app.models.Address;
import app.models.Person;
import app.util.JsonHelper;
import org.javalite.activeweb.annotations.RESTful;
import org.javalite.common.Util;
import org.javalite.json.JSONList;
import org.javalite.json.JSONMap;

import java.io.IOException;
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

    public void create(PeopleRequest peopleRequest)  {
        JSONList people  = peopleRequest.getList("people");

        for (int i = 0; i < people.size(); i++) {
            JSONMap personMap = people.getMap(i);
            Person person = new Person();
            person.fromMap(personMap).saveIt();
            JSONList addresses  =  personMap.getList("addresses");
            for (int j = 0; j < addresses.size(); j++) {
                JSONMap addressMap = addresses.getMap(j);
                Address address = new Address();
                address.fromMap(addressMap);
                person.add(address);
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
