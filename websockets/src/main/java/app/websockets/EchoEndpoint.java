package app.websockets;

import org.javalite.activeweb.websockets.AppEndpoint;

import java.io.IOException;

public class EchoEndpoint extends AppEndpoint {
    @Override
    public void onMessage(String message) {
        try {
            System.out.println("Got message again lala: " +  message + ", object: " + this);
            this.sendMessage("Got: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
