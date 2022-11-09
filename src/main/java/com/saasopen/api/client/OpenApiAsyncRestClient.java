package com.saasopen.api.client;



import com.saasopen.api.client.domain.ServerTime;


/**
 * DID API façade, supporting asynchronous/non-blocking access DidOpen's REST API.
 */
public interface OpenApiAsyncRestClient {

  // General endpoints

  /**
   * Test connectivity to the Rest API.
   */
  void ping(OpenApiCallback<Void> callback);

  /**
   * Check server time.
   */
  void getServerTime(OpenApiCallback<ServerTime> callback);
}