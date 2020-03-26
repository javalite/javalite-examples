package app.config;

import org.javalite.activeweb.AbstractRouteConfig;
import org.javalite.activeweb.AppContext;

/**
 * @author Igor Polevoy on 7/28/14.
 */

public class RouteConfig extends AbstractRouteConfig {
    public void init(AppContext appContext) {
        ignore("/bootstrap.css").exceptIn("development");
    }
}
