package com.joke2017.smile2017.utils;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 111 on 2017/9/25.
 */

public class OkhttpRequest {
    public static <T> void getHttp(String url, final Class<T> clazz, final CallBackToData callBackToData) {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url(url).get().build();

        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override

            public void onFailure(Call call, IOException e) {


            }


            @Override

            public void onResponse(Call call, Response response) throws IOException {

                String json = response.body().string();

                Gson gson = new Gson();

                T homeData = gson.fromJson(json, clazz);

                callBackToData.backData(homeData);

            }


        });

    }

    public interface CallBackToData<T> {

        void backData(T data);

    }


}
