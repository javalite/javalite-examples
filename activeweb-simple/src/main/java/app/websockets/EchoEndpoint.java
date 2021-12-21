package app.websockets;

import org.javalite.activeweb.websockets.AppEndpoint;

/**
 * Spring testing example:
 *
 *  https://rieckpil.de/write-integration-tests-for-your-spring-websocket-endpoints/
 */
public class EchoEndpoint extends AppEndpoint {

    private int counter = 0;
    @Override
    public void onMessage(String message) {
        try{
            System.out.println("---------------------");
            sendMessage(greeting6() + message + " and the count: " + counter++);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String greeting6(){
        return "You sent me again!!!: ";
    }
}
