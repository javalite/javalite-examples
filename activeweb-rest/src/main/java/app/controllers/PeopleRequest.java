package app.controllers;

import org.javalite.json.JSONBase;
import org.javalite.json.JSONValidator;
import org.javalite.validation.ValidatorAdapter;

import java.util.Map;


public class PeopleRequest extends JSONBase {

    public PeopleRequest(Map jsonMap) {
        super(jsonMap);
        validateList("people");
    }
}