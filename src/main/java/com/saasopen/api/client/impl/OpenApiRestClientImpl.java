package com.saasopen.api.client.impl;

import com.saasopen.api.client.OpenApiRestClient;
import com.saasopen.api.client.domain.PageRes;
import com.saasopen.api.client.domain.R;
import com.saasopen.api.client.domain.req.ShopQueryDto;
import com.saasopen.api.client.domain.res.ShopInfoRes;
import com.saasopen.api.client.domain.res.TenantGasAccountRes;


/**
 * Implementation of DidOpen's REST API using Retrofit with synchronous/blocking method calls.
 */
public class OpenApiRestClientImpl implements OpenApiRestClient {

  private final OpenApiService openApiService;

  public OpenApiRestClientImpl(String appId,String apiKey, String secret, String url) {
    openApiService = new OpenApiServiceGenerator().createService(OpenApiService.class,appId, apiKey, secret,url);
  }


  @Override
  public R<TenantGasAccountRes> getPlatformGas() {
    return OpenApiServiceGenerator.executeSync(openApiService.getPlatformGas());
  }

  @Override
  public R<PageRes<ShopInfoRes>> testPost(ShopQueryDto shopQueryDto) {
    return OpenApiServiceGenerator.executeSync(openApiService.testPost(shopQueryDto));
  }
}
