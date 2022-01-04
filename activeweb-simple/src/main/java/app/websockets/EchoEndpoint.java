package app.websockets;

import org.javalite.activeweb.websockets.AppEndpoint;

import javax.websocket.CloseReason;

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
            sendMessage(greeting6() + ", and the message:  " +  message + " and the count: " + counter++);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String greeting6(){
        return "Name from HTTP session:   " + getHttpSession().getAttribute("name");
    }

    @Override
    public void onClose(CloseReason closeReason) {
        logInfo("Wahwah, closing for:  " + getHttpSession().getAttribute("name"));
    }
}
