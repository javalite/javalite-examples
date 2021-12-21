package app.websockets;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CustomServerAppConfigProvider// implements ServerApplicationConfig
 {

    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> endpointClasses) {
        Set<ServerEndpointConfig> result = new HashSet();
        for (Class endpointClass : endpointClasses) {
            //need to ignore Client endpoint class
            if (endpointClass.equals(EchoEndpoint.class)) {
                ServerEndpointConfig sec = ServerEndpointConfig.Builder.create(endpointClass, "/echo").build();
                result.add(sec);

                System.out.println("Registered: " + endpointClass);
            }
        }
        return result;
    }

    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
        return Collections.emptySet();
    }
}