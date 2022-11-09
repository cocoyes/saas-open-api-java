package com.saasopen.api.client.impl;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.saasopen.api.client.constant.OpenApiConstants;
import com.saasopen.api.client.domain.R;
import com.saasopen.api.client.exception.OpenApiException;
import com.saasopen.api.client.security.AuthenticationInterceptor;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Generates a DID API implementation based on @see {@link OpenApiService}.
 */
public class OpenApiServiceGenerator {

    public  <S> S createService(Class<S> serviceClass,String appId, String apiKey, String secret,String url) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(OpenApiConstants.API_BASE_URL).addConverterFactory(JacksonConverterFactory.create());
        Retrofit retrofit = builder.build();
        builder.baseUrl(url);
        if (!StringUtils.isEmpty(apiKey) && !StringUtils.isEmpty(secret)) {
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(appId,apiKey, secret);
            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);
                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }
        return retrofit.create(serviceClass);
    }


    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> R<T> executeSync(Call<R<T>> call) {
        try {
            Response<R<T>> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                if(response!=null&&response.errorBody()!=null){
                    JSONObject jsonObject= JSONUtil.parseObj(response.errorBody().string());
                    return R.failed(jsonObject.getInt("code"),jsonObject.getStr("msg"));
                }
               return R.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new OpenApiException("网络异常"+e.getMessage());
        }
    }
}