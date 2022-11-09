package com.saasopen.api.client.impl;

import com.saasopen.api.client.constant.Constants;

import com.saasopen.api.client.constant.OpenApiConstants;
import com.saasopen.api.client.domain.*;
import com.saasopen.api.client.domain.req.ShopQueryDto;
import com.saasopen.api.client.domain.res.ShopInfoRes;
import com.saasopen.api.client.domain.res.TenantGasAccountRes;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * DidOpen's REST API URL mappings and endpoint security configuration.
 */
public interface OpenApiService {

  // General endpoints

  @GET(Constants.BASE_URI+"/open/v1/ping")
  Call<Void> ping();

  @GET(Constants.BASE_URI+"/open/v1/time")
  Call<ServerTime> getServerTime();

  @GET(Constants.BASE_URI+"/didapi/v1/platform/getPlatformGas")
  Call<R<TenantGasAccountRes>> getPlatformGas();

  @POST(Constants.BASE_URI+"/didapi/v1/platform/testPost")
  @Headers({OpenApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
  Call<R<PageRes<ShopInfoRes>>> testPost(@Body ShopQueryDto shopQueryDto);
}