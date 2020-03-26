package app.controllers;

import app.controllers.authorization.Protected;
import org.javalite.activeweb.AppController;

@Protected
public class SecureController extends AppController {
    public void index(){}
}
