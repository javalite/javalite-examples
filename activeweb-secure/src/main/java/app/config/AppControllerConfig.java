package app.config;

import app.controllers.authorization.AuthorizationFilter;
import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.controller_filters.RequestParamsLogFilter;
import org.javalite.activeweb.controller_filters.RequestPropertiesLogFilter;

public class AppControllerConfig extends AbstractControllerConfig {

    public void init(AppContext context) {
        add(new AuthorizationFilter(), new RequestParamsLogFilter(), new RequestPropertiesLogFilter());
    }
}
