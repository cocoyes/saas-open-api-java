package com.saasopen.api.client;

import com.saasopen.api.client.impl.OpenApiAsyncRestClientImpl;
import com.saasopen.api.client.impl.OpenApiRestClientImpl;
import com.saasopen.api.client.impl.OpenApiWebSocketClientImpl;

/**
 * A factory for creating DidOpenApi client objects.
 */
public class OpenApiClientFactory {
  /**
   * API appId
   */
  private String appId;
  /**
   * API Key
   */
  private String apiKey;

  /**
   * Secret.
   */
  private String secret;

  /**
   * url.
   */
  private String url;

  /**
   * Instantiates a new DID API client factory.
   *
   * @param apiKey the API key
   * @param secret the Secret
   */
  private OpenApiClientFactory(String appId,String apiKey, String secret) {
    this.appId = appId;
    this.apiKey = apiKey;
    this.secret = secret;
  }
  private OpenApiClientFactory(String appId,String apiKey, String secret, String url) {
    this.appId = appId;
    this.apiKey = apiKey;
    this.secret = secret;
    this.url = url;
  }

  /**
   * New instance.
   *
   * @param apiKey the API key
   * @param secret the Secret
   *
   * @return the DID API client factory
   */
  public static OpenApiClientFactory newInstance(String appId,String apiKey, String secret) {
    return new OpenApiClientFactory(appId,apiKey, secret);
  }

  public static OpenApiClientFactory newInstance(String appId,String apiKey, String secret, String url) {
    return new OpenApiClientFactory(appId,apiKey, secret,url);
  }

  /**
   * New instance without authentication.
   *
   * @return the DID API client factory
   */
  public static OpenApiClientFactory newInstance() {
    return new OpenApiClientFactory(null, null,null);
  }

  /**
   * Creates a new synchronous/blocking REST client.
   */
  public OpenApiRestClient newRestClient() {
    return new OpenApiRestClientImpl(appId,apiKey, secret,url);
  }


  /**
   * Creates a new asynchronous/non-blocking REST client.
   */
  public OpenApiAsyncRestClient newAsyncRestClient() {return new OpenApiAsyncRestClientImpl(appId,apiKey, secret);
  }

  /**
   * Creates a new web socket client used for handling data streams.
   */
  public OpenApiWebSocketClient newWebSocketClient() {
    return new OpenApiWebSocketClientImpl();
  }
}
