package com.ethereal.meta.node.p2p.sender;

import com.ethereal.meta.core.console.Console;
import com.ethereal.meta.core.entity.Error;
import com.ethereal.meta.core.entity.RequestMeta;
import com.ethereal.meta.core.entity.ResponseMeta;
import com.ethereal.meta.meta.Meta;
import com.ethereal.meta.request.core.RequestContext;
import com.ethereal.meta.util.SerializeUtil;
import io.netty.handler.codec.http.*;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: YiXian
 * @Package: com.xianyu.yixian.com.ethereal.client.Core.Model
 * @ClassName: EchoClient
 * @Description: TCP客户端
 * @Author: Jianxian
 * @CreateDate: 2020/11/16 20:17
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/11/16 20:17
 * @UpdateRemark: 类的第一次生成
 * @Version: 1.0
 */
public class HttpPostRequest extends com.ethereal.meta.node.core.Node {
    OkHttpClient client;

    private void send(Request request) {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                context.setResponseMeta(new ResponseMeta(new Error(Error.ErrorCode.HttpException,e.getMessage())));
                meta.getRequest().receive(context);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ResponseMeta responseMeta = new ResponseMeta();
                responseMeta.setError(SerializeUtil.gson.fromJson(response.headers().get("error"), Error.class));
                responseMeta.setProtocol(response.headers().get("protocol"));
                //instance 处理
                //省略
                ///////
                responseMeta.setInstance(responseMeta.getInstance());
                responseMeta.setResult(response.body().string());
                context.setResponseMeta(responseMeta);
                meta.getRequest().receive(context);
            }
        });
    }

    @Override
    public boolean send(Object data,int timeout) {
        client = new OkHttpClient.Builder().callTimeout(timeout, TimeUnit.MILLISECONDS).build();
        if(data instanceof RequestMeta){
            Console.debug(data.toString());
            RequestMeta requestMeta = (RequestMeta) data;
            RequestBody requestBody = RequestBody.create(SerializeUtil.gson.toJson(requestMeta.getParams()).getBytes(StandardCharsets.UTF_8));
            Request.Builder request = new Request.Builder()
                    .url(new HttpUrl.Builder()
                            .scheme("http")
                            .host(context.getRemote().getHost())
                            .port(Integer.parseInt(context.getRemote().getPort()))
                            .addPathSegments(requestMeta.getMapping().substring(1))
                            .build())
                    .post(requestBody)
                    .addHeader(HttpHeaderNames.CONTENT_TYPE.toString(),HttpHeaderValues.APPLICATION_JSON.toString())
                    .addHeader("protocol", requestMeta.getProtocol())
                    .addHeader("instance", requestMeta.getInstance())
                    .addHeader("host", requestMeta.getHost())
                    .addHeader("port", requestMeta.getPort());
            send(request.build());
            return true;
        }
        return false;
    }

}
