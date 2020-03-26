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
import org.javalite.activeweb.FormItem;
import org.javalite.activeweb.annotations.POST;
import org.javalite.common.Util;

import java.io.IOException;
import java.util.*;

/**
 * @author Igor Polevoy
 */
public class UploadController extends AppController {

    public void index() {}

    @POST
    public void save() throws IOException {
        List<FormItem> items = multipartFormItems();
        List<String> messages = new ArrayList<String>();

        for (FormItem item : items) {
            if(item.isFile()){
                messages.add("Found file: " + item.getFileName() + " with size: " + Util.read(item.getInputStream()).length());
            }else{
                messages.add("Found field: " + item.getFieldName() + " with value: " + item.getStreamAsString());
            }
        }
        flash("messages", messages);
        redirect(UploadController.class);
    }
}

