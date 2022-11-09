package com.saasopen.api.client.impl;

import com.saasopen.api.client.OpenApiAsyncRestClient;
import com.saasopen.api.client.OpenApiCallback;
import com.saasopen.api.client.constant.OpenApiConstants;
import com.saasopen.api.client.domain.ServerTime;



/**
 * Implementation of DidOpen's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class OpenApiAsyncRestClientImpl implements OpenApiAsyncRestClient {

  private final OpenApiService openApiService;

  public OpenApiAsyncRestClientImpl(String appId,String apiKey, String secret) {
    openApiService =new OpenApiServiceGenerator().createService(OpenApiService.class, appId,apiKey, secret, OpenApiConstants.API_BASE_URL);
  }

  // General endpoints

  @Override
  public void ping(OpenApiCallback<Void> callback) {
    openApiService.ping().enqueue(new OpenApiCallbackAdapter<>(callback));
  }

  @Override
  public void getServerTime(OpenApiCallback<ServerTime> callback) {
    openApiService.getServerTime().equals(new OpenApiCallbackAdapter<>(callback));
  }


}