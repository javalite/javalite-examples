package app.controllers;

import org.javalite.activeweb.controller_filters.HttpSupportFilter;

import static org.javalite.common.Collections.map;

/**
 * @author Igor Polevoy on 10/28/14.
 */
public class CatchAllFilter extends HttpSupportFilter {
    @Override
    public void onException(Exception e) {
        if(e.getCause() instanceof org.codehaus.jackson.JsonParseException){
            render("/people/message", map("message", "malformed JSON format", "code", 500));
        }else{
            // this is an exception thrown from any controller on purpose.
            render("/people/message", map("message", e.getMessage(), "code", 500));
        }
    }
}
