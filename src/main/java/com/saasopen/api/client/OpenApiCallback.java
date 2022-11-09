package com.saasopen.api.client;

import com.saasopen.api.client.exception.OpenApiException;

/**
 * DidOpenApiCallback is a functional interface used together with the DidOpenApiAsyncClient to provide a non-blocking REST client.
 *
 * @param <T> the return type from the callback
 */
public interface OpenApiCallback<T> {

    /**
     * Called whenever a response comes back from the DID API.
     *
     * @param response the expected response object
     * @throws OpenApiException if it is not possible to obtain the expected response object (e.g. incorrect API-KEY).
     */
    void onResponse(T response) throws OpenApiException;
}