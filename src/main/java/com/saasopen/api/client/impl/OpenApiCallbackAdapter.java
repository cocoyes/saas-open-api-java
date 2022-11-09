package com.saasopen.api.client.impl;

import com.saasopen.api.client.OpenApiCallback;
import com.saasopen.api.client.exception.OpenApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * An adapter/wrapper which transforms a Callback from Retrofit into a DidOpenApiCallback which is exposed to the client.
 */
public class OpenApiCallbackAdapter<T> implements Callback<T> {

  private final OpenApiCallback<T> callback;

  public OpenApiCallbackAdapter(OpenApiCallback<T> callback) {
    this.callback = callback;
  }

  public void onResponse(Call<T> call, Response<T> response) {
    if (response.isSuccessful()) {
      callback.onResponse(response.body());
    } else {
      throw new OpenApiException("系统异常");
    }
  }

  @Override
  public void onFailure(Call<T> call, Throwable throwable) {
    throw new OpenApiException(throwable);
  }
}
