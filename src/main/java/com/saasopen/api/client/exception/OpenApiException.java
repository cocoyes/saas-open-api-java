package com.saasopen.api.client.exception;

import cn.hutool.json.JSONObject;
import com.saasopen.api.client.OpenApiError;
import org.apache.commons.lang3.StringUtils;

/**
 * An exception which can occur while invoking methods of the DID API.
 */
public class OpenApiException extends RuntimeException {

  /**
   * Error response object returned by DID API.
   */
  private OpenApiError error;

  /**
   * Instantiates a new DID API exception.
   *
   * @param error an error response object
   */
  public OpenApiException(OpenApiError error) {
    this.error = error;
  }

  /**
   * Instantiates a new DID API exception.
   */
  public OpenApiException() {
    super();
  }

  /**
   * Instantiates a new DID API exception.
   *
   * @param message the message
   */
  public OpenApiException(String message) {
    super(message);
  }

  /**
   * Instantiates a new DID API exception.
   *
   * @param cause the cause
   */
  public OpenApiException(Throwable cause) {
    super(cause);
  }

  /**
   * Instantiates a new DID API exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public OpenApiException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * @return the response error object from DID API, or null if no response object was returned (e.g. server returned 500).
   */
  public OpenApiError getError() {
    return error;
  }

  @Override
  public String getMessage() {
    if (error != null) {
      if(StringUtils.isNotEmpty(error.getError())){
        return error.getError();
      }
      if(StringUtils.isNotEmpty(error.getMsg())){
        return error.getMsg();
      }
      return new JSONObject(error).toString();
    }
    return super.getMessage();
  }
}
