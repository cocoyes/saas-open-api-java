package com.saasopen.api.client.security;

import cn.hutool.json.JSONUtil;
import com.saasopen.api.client.constant.OpenApiConstants;
import com.saasopen.api.client.utils.RSAUtils;
import lombok.SneakyThrows;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * A request interceptor that injects the API Key Header into requests, and signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {
    private final String appId;
    private final String apiKey;

    private final String secret;

    public AuthenticationInterceptor(String appId,String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.appId = appId;
    }

    @SneakyThrows
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();
        RequestBody requestBody=newRequestBuilder.build().body();
        boolean isSignatureRequired = original.header(OpenApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED) != null;

        newRequestBuilder.removeHeader(OpenApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED)
            .removeHeader(OpenApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED);
        newRequestBuilder.addHeader(OpenApiConstants.API_APPID_HEADER, appId);
        String type = original.method();
        // Endpoint requires signing the payload
        if (isSignatureRequired) {
            if(type.equals(OpenApiConstants.POST)){
                //json通信，增加 时间戳+appKey 对其进行签名
                Map<String,Object> map= JSONUtil.toBean(bodyToString(requestBody),Map.class);
                String signStr= parseParamsPost(map);
                String signature = RSAUtils.sign(signStr, RSAUtils.getPrivateKey(secret));
                HttpUrl signedUrl = original.url().newBuilder().addQueryParameter("signature", signature).build();
                newRequestBuilder.url(signedUrl);
            }else {
                String payload = original.url().query();
                if (!StringUtils.isEmpty(payload)) {
                    //排序，字典序
                    String[] arr=payload.split("&");
                    List<String> pv=new ArrayList<>(arr.length);
                    Collections.addAll(pv,arr);

                    int size = pv.size();
                    String [] arrayToSort = pv.toArray(new String[size]);
                    Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i < size; i ++) {
                        sb.append(arrayToSort[i]);
                    }
                    String payLoadParams=StringUtils.join(arrayToSort, "&");
                    String signature =RSAUtils.sign(payLoadParams, RSAUtils.getPrivateKey(secret));
                    HttpUrl signedUrl = original.url().newBuilder().addQueryParameter("signature", signature).build();
                    newRequestBuilder.url(signedUrl);
                }
            }

        }
        // Build new request after adding the necessary authentication information
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    private String parseParamsPost( Map<String, Object> map){
        ArrayList<String> list = new ArrayList<String>();
        for (String key : map.keySet()) {
            if(map.get(key)==null||StringUtils.isEmpty(map.get(key).toString())||map.get(key).toString().equals("null")){
                continue;
            }
            String values = map.get(key).toString();
            if(!OpenApiConstants.SIGNATURE.equalsIgnoreCase(key)){
                list.add(key + "=" + values + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        if(result.lastIndexOf("&")==result.length()-1){
            result=result.substring(0,result.lastIndexOf("&"));
        }
        return result;
    }

    /**
     * Extracts the request body into a String.
     *
     * @return request body as a string
     */
    private static String bodyToString(RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null) {
                copy.writeTo(buffer);
            } else {
                return "";
            }
            return buffer.readUtf8();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}