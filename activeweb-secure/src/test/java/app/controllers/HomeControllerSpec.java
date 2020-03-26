package app.controllers;

import org.javalite.activeweb.ControllerSpec;
import org.junit.Test;


public class HomeControllerSpec extends ControllerSpec {

    @Test
    public void shouldShowHomePage() {
        request().get("index");
        a(statusCode()).shouldBeEqual(200);
        a(responseContent()).shouldContain("<h1>ActiveWeb Secure site</h1>");
    }

}