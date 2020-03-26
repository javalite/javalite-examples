package app.controllers;

import org.javalite.activeweb.CSRF;
import org.javalite.activeweb.ControllerSpec;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnobtrusiveControllerSpec extends ControllerSpec {

    @BeforeClass
    public static void beforeClass() {
        CSRF.enableVerification();
    }

    @AfterClass
    public static void afterClass() {
        CSRF.disableVerification();
    }

    @Test
    public void shouldShowIndexPage() {
        request().get("index");

        a(responseContent()).shouldContain("data-csrf-token");
        a(responseContent()).shouldContain(CSRF.token());

    }



}
