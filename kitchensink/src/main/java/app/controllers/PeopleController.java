package app.controllers;

import app.models.Person;
import org.javalite.activejdbc.Paginator;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

import static org.javalite.common.Convert.toInteger;

/**
 * @author Igor Polevoy on 11/23/14.
 */
public class PeopleController extends AppController {


    public void index() {
        Paginator p = paginator();
        int pageIndex = blank("page") ? 1 : toInteger(param("page"));
        int nextIndex = (pageIndex == p.getCount()) ? -1 : pageIndex + 1;
        int prevIndex = (pageIndex == 1) ? -1 : pageIndex - 1;

        view("people", p.getPage(pageIndex));
        view("next_index", nextIndex);
        view("prev_index", prevIndex);
    }

    /**
     * Will create paginator if one does not exist
     *
     * @return paginator
     */
    @SuppressWarnings("unchecked")
    private Paginator paginator() {
        Paginator<Person> paginator;
        if (sessionHas("paginator")) {
            paginator = (Paginator) session("paginator");
        } else {
            paginator = new Paginator(Person.class, 20, "*");
            paginator.orderBy("id");
            session("paginator", paginator);
        }
        return paginator;
    }

    @POST
    public void createPeople() {
        String firstName = "John";
        String lastName = "Doe";
        for (int i = 0; i < 1000; i++) {
            Person p = new Person(firstName + i, lastName + i);
            p.saveIt();
        }
        redirect(PeopleController.class);
    }
}
