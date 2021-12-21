package app.config;

import app.websockets.EchoEndpoint;
import org.javalite.activeweb.websockets.AbstractWebSocketConfig;

public class WebSocketConfig extends AbstractWebSocketConfig {
    @Override
    protected void init() {
        route("/echo").to(EchoEndpoint.class);
    }
}
