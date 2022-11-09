package com.saasopen.api.client;


import com.saasopen.api.client.domain.PageRes;
import com.saasopen.api.client.domain.R;
import com.saasopen.api.client.domain.req.ShopQueryDto;
import com.saasopen.api.client.domain.res.ShopInfoRes;
import com.saasopen.api.client.domain.res.TenantGasAccountRes;

/**
 * DID API façade, supporting synchronous/blocking access DidOpen's REST API.
 */
public interface OpenApiRestClient {

  R<TenantGasAccountRes> getPlatformGas();

  R<PageRes<ShopInfoRes>> testPost(ShopQueryDto shopQueryDto);
}