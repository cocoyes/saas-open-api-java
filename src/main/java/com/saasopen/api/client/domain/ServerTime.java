package com.saasopen.api.client.domain;

/**
 * Time of the server running DidOpen's REST API.
 */
public class ServerTime {
  private Long serverTime;

  public Long getServerTime() {
    return serverTime;
  }

  public void setServerTime(Long serverTime) {
    this.serverTime = serverTime;
  }

  @Override
  public String toString() {
    return String.valueOf(serverTime);
  }
}
