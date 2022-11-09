package com.saasopen.api.examples;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import com.saasopen.api.client.domain.PageRes;
import com.saasopen.api.client.domain.R;
import com.saasopen.api.client.domain.req.ShopQueryDto;
import com.saasopen.api.client.domain.res.ShopInfoRes;
import com.saasopen.api.client.domain.res.TenantGasAccountRes;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class PlatformTest extends BaseTest{
    @Test
    public void testGetPlatformGas() {
        R<TenantGasAccountRes> resR= client.getPlatformGas();
        System.out.println(JSONUtil.toJsonStr(resR));
    }
    @Test
    public void testPost() {
        ShopQueryDto shopQueryDto=new ShopQueryDto();
        shopQueryDto.setShopId("ssss");
        R<PageRes<ShopInfoRes>>  resR= client.testPost(shopQueryDto);
        System.out.println(JSONUtil.toJsonStr(resR));
    }
}
