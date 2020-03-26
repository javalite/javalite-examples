package app.controllers;

import org.javalite.activeweb.AppController;

/**
 * @author Igor Polevoy on 10/28/14.
 */
public abstract class APIController extends AppController{
    @Override
    protected String getContentType() {
        return "application/json";
    }

    @Override
    protected String getLayout() {
        return null;
    }

}
