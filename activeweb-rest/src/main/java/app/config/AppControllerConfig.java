package app.config;

import app.controllers.CatchAllFilter;
import app.controllers.PeopleController;
import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.controller_filters.DBConnectionFilter;

public class AppControllerConfig extends AbstractControllerConfig {

    public void init(AppContext context) {
        add(new CatchAllFilter(), new DBConnectionFilter()).to(PeopleController.class);
    }
}
