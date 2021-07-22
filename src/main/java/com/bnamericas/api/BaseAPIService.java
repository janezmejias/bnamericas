package com.bnamericas.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author janezmejias.09@gmail.com
 * @version 1.0
 * @see
 */
public abstract class BaseAPIService {

    protected String url;
    private Retrofit retrofit;
    private Retrofit.Builder builder;
    private OkHttpClient.Builder httpClient;

    protected BaseAPIService() {
    }

    @Autowired
    MessageSource messageSource;

    @PostConstruct
    private void init() {
        this.builder
                = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create());
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS);
        this.retrofit = builder.build();
    }


    protected <S> S createService(Class<S> serviceClass) {
        builder.client(httpClient.build());
        retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

    protected <S> S createService(Class<S> serviceClass, final String token) {
        httpClient.interceptors().clear();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder builder1 = original.newBuilder();
            Request request = builder1.build();
            return chain.proceed(request);
        });
        builder.client(httpClient.build());
        retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

    public abstract void setUrl(String url);

    protected ResponseBase buildApiBaseResponse(Call<ResponseBase> retrofitCall) throws IOException {
        Response<ResponseBase> response = retrofitCall.execute();
        return response.body();
    }
}
