package app.controllers;

import org.javalite.activeweb.AppController;

public class SocketsController extends AppController {

    public void index(){
        session("name", param("name"));
    }

    public void index2(){}
}
