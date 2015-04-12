package com.test.websocket;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoEndPoint {

    @OnMessage
    public String onMessage(Session session, String message) {
        System.out.println("Server Method1 >>> Received message "+message);
       try { session.getBasicRemote().sendText("From Server Method 2"+message+ "\n"); 
        } catch (IOException e) { 
        System.out.println("Exception "+e);
        }
        return " echo from server "+message;
    }
    /*@OnMessage 
    public void onMessage(Session session, String message) { 
         System.out.println("Server Method2 >>> Received message "+message);
        try { session.getBasicRemote().sendText("From Server Method 2"+message); 
        } catch (IOException e) { 
        System.out.println("Exception "+e);
        } 
    }*/
    
}
