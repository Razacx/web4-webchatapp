package com.razacx.web;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class ChatSocketConfigurator extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        //Set Person from session to ServerEndpointConfig attributes
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        sec.getUserProperties().put("person", httpSession.getAttribute("person"));
    }

}