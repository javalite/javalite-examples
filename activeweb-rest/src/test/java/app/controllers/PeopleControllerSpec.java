package app.controllers;

import app.models.Address;
import app.models.Person;
import app.util.JsonHelper;
import org.javalite.activeweb.DBControllerSpec;
import org.javalite.common.Util;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author Igor Polevoy on 10/26/14.
 */
public class PeopleControllerSpec extends DBControllerSpec {

    @Test
    public void shouldRenderPeople(){

        //add test data:
        Person p = new Person("Marylin", "Monroe");
        p.saveIt();
        p.add(new Address("residential", "123 Pine St", "Apt 3", "Chicago", "IL", "60606"));
        p.add(new Address("shipping", "135 S LaSalle St", "", "Chicago", "IL", "60604"));

        //call controller
        request().get("index");

        the(contentType()).shouldBeEqual("application/json");
        Map[] peopleMaps = JsonHelper.toMaps(responseContent());

        the(peopleMaps.length).shouldBeEqual(1);
        Map person = peopleMaps[0];

        the(person.get("first_name")).shouldBeEqual("Marylin");
        the(person.get("last_name")).shouldBeEqual("Monroe");

        List<Map> addresses = (List<Map>) person.get("addresses");

        the(addresses.get(0).get("address_type")).shouldBeEqual("residential");
        the(addresses.get(0).get("address1")).shouldBeEqual("123 Pine St");
        the(addresses.get(0).get("address2")).shouldBeEqual("Apt 3");
        the(addresses.get(0).get("city")).shouldBeEqual("Chicago");
        the(addresses.get(0).get("state")).shouldBeEqual("IL");
        the(addresses.get(0).get("zip")).shouldBeEqual("60606");

        the(addresses.get(1).get("address_type")).shouldBeEqual("shipping");
        the(addresses.get(1).get("address1")).shouldBeEqual("135 S LaSalle St");
        the(addresses.get(1).get("address2")).shouldBeEqual("");
        the(addresses.get(1).get("city")).shouldBeEqual("Chicago");
        the(addresses.get(1).get("state")).shouldBeEqual("IL");
        the(addresses.get(1).get("zip")).shouldBeEqual("60604");
    }

    @Test
    public void shouldCreateNewPeopleWithAddresses(){

        String json = Util.readResource("/people.json");
        request().content(json.getBytes()).contentType("application/json").post("create"); // <--- need to call "create" according to REST routing

        Map response = JsonHelper.toMap(responseContent());

        the(response.get("code")).shouldBeEqual(200);
        the(response.get("message")).shouldBeEqual("successfully created people and addresses");

        request().get("index");
        Map[] peopleMaps = JsonHelper.toMaps(responseContent());

        the(peopleMaps.length).shouldBeEqual(2);
        Map person = peopleMaps[0];
        the(person.get("first_name")).shouldBeEqual("Marylin");
        the(person.get("last_name")).shouldBeEqual("Monroe");

        person = peopleMaps[1];
        the(person.get("first_name")).shouldBeEqual("John");
        the(person.get("last_name")).shouldBeEqual("Kennedy");
        //can write more tests to get to addresses, but it is obvious how to...
    }
    @Test
    public void shouldRenderSpecificPersonById(){

        //add test data:
        Person p = new Person("Marylin", "Monroe");
        p.saveIt();
        p.add(new Address("residential", "123 Pine St", "Apt 3", "Chicago", "IL", "60606"));
        p.add(new Address("shipping", "135 S LaSalle St", "", "Chicago", "IL", "60604"));

        //call controller with ID
        request().id(p.getId()).get("show"); // <--- need to call "show" with ID according to REST routing

        Map person = JsonHelper.toMap(responseContent());
        the(person.get("first_name")).shouldBeEqual("Marylin");
        the(person.get("last_name")).shouldBeEqual("Monroe");
        // and so on...
    }
}
