package com.saasopen.api.client.impl;

import com.saasopen.api.client.OpenApiWebSocketClient;
import okhttp3.OkHttpClient;

import java.io.Closeable;
import java.io.IOException;

/**
 * DID API WebSocket client implementation using OkHttp.
 */
public class OpenApiWebSocketClientImpl implements OpenApiWebSocketClient, Closeable {

  private OkHttpClient client;

  public OpenApiWebSocketClientImpl() {
    this.client = new OkHttpClient();
  }



  @Override
  public void close() throws IOException {
    client.dispatcher().executorService().shutdown();
  }
}
