package com.saasopen.api.examples;

import com.saasopen.api.client.OpenApiClientFactory;
import com.saasopen.api.client.OpenApiRestClient;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

/**
 * @author liyong E-mail:liam.li@qiyihuo.com
 * @version 创建时间：2022/11/3 10:55
 * @describe:
 */
public class BaseTest {
    public  static OpenApiClientFactory factory = OpenApiClientFactory.newInstance(ApiInfoConstants.appId,ApiInfoConstants.apiKey,ApiInfoConstants.secret,ApiInfoConstants.url);
    public  static OpenApiRestClient client = factory.newRestClient();
}
