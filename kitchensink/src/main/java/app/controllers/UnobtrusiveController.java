/*
Copyright 2009-2010 Igor Polevoy 

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at 

http://www.apache.org/licenses/LICENSE-2.0 

Unless required by applicable law or agreed to in writing, software 
distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions and 
limitations under the License. 
*/

package app.controllers;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.DELETE;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.PUT;

import java.util.Map;

/**
 * @author Igor Polevoy
 */
public class UnobtrusiveController extends AppController {
    @GET
    @SuppressWarnings("unchecked")
    public void index() {
        Map<String, String> params = session().get("flasher", Map.class);
        if (params != null) {
            view(params);
        }
    }

    @GET
    public void doSimpleGet() {
        redirect2index("GET");
    }
    @POST
    public void doSimplePost() {
        redirect2index("POST");
    }
    @PUT
    public void doSimplePut() {
        redirect2index("PUT");
    }
    @DELETE
    public void doSimpleDelete() {
        redirect2index("DELETE");
    }

    private void  redirect2index(String method) {
        Map<String, String> params = params1st();
        params.put("result", "this is  " + method + ", data: " + params);
        flash(params);
        redirect();
    }

    @GET
    public void doGet() {
        respond("this is  GET, data: " + params());
    }

    @POST
    public void doPost() {
        respond("this is  POST, data: " + params());
    }

    @DELETE
    public void doDelete() {
        respond("this is  DELETE, data: " + params());
    }

    @PUT
    public void doPut() {
        respond("this is  PUT, data: " + params());
    }
}
