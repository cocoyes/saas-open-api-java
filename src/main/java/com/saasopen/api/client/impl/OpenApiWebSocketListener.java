package com.saasopen.api.client.impl;

import com.saasopen.api.client.OpenApiCallback;
import com.saasopen.api.client.exception.OpenApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.io.IOException;

/**
 * DID API WebSocket listener.
 */
public class OpenApiWebSocketListener<T> extends WebSocketListener {

  private OpenApiCallback<T> callback;

  private Class<T> eventClass;

  public OpenApiWebSocketListener(OpenApiCallback<T> callback, Class<T> eventClass) {
    this.callback = callback;
    this.eventClass = eventClass;
  }

  @Override
  public void onMessage(WebSocket webSocket, String text) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      T event = mapper.readValue(text, eventClass);
      callback.onResponse(event);
    } catch (IOException e) {
      throw new OpenApiException(e);
    }
  }

  @Override
  public void onFailure(WebSocket webSocket, Throwable t, Response response) {
    throw new OpenApiException(t);
  }
}