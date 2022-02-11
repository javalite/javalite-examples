package app.controllers;

import org.javalite.activeweb.AppController;
import static org.javalite.common.Util.readResource;

public class OpenapiController extends AppController {
    public void index(){
            respond(readResource("/openapi.json")).contentType("application/json");
    }
}
