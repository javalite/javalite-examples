package app.controllers;

import org.javalite.activeweb.controller_filters.AppControllerFilter;
import org.javalite.logging.Context;

import java.util.UUID;

public class RequestContextFilter extends AppControllerFilter {
    @Override
    public void before() {
        Context.put("request_id", UUID.randomUUID().toString());
    }
}
