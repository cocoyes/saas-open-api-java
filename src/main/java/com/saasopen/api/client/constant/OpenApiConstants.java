package com.saasopen.api.client.constant;

/**
 * Constants used throughout DidOpen's API.
 */
public class OpenApiConstants {

  /**
   * REST API base URL.
   */
  public static  String API_BASE_URL = "https://rarefy.vip/";

  /**
   * Streaming API base URL.
   */
  public static final String WS_API_BASE_URL = "wss://stream.DidOpen.com:9443/ws";

  /**
   * HTTP Header to be used for API-KEY authentication.
   */
  public static final String API_APPID_HEADER = "X-OPEN-APPID";

  /**
   * Decorator to indicate that an endpoint requires an API key.
   */
  public static final String ENDPOINT_SECURITY_TYPE_APIKEY = "APIKEY";
  public static final String ENDPOINT_SECURITY_TYPE_APIKEY_HEADER = ENDPOINT_SECURITY_TYPE_APIKEY + ": #";

  /**
   * Decorator to indicate that an endpoint requires a signature.
   */
  public static final String ENDPOINT_SECURITY_TYPE_SIGNED = "SIGNED";
  public static final String ENDPOINT_SECURITY_TYPE_SIGNED_HEADER = ENDPOINT_SECURITY_TYPE_SIGNED + ": #";
  public static final String GET =   "GET";
  public static final String POST =   "POST";
  /**
   * API KEY
   */
  public static final String SIGNATURE = "signature";

  /**
   * Default receiving window.
   */
  public static final long DEFAULT_RECEIVING_WINDOW = 6_000_000L;
}
