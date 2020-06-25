package com.example.petrolapp;

import android.content.ContentValues;


import java.io.IOException;
import org.jetbrains.annotations.NotNull;

import android.app.Activity;
import android.app.Person;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Connection {
    private String url;
    private String file;
    private OkHttpClient client=new OkHttpClient();

    public Connection(String prefix){
        url=prefix;

    }

    public void fetchInfo(final Activity a, String f, ContentValues params, final RequestHandler requestHandler){
        file=f+".php";


        FormBody.Builder builder= new FormBody.Builder();

        for(String key:params.keySet()){
            builder.add(key,params.getAsString(key));
        }
        Request request=new Request.Builder().url(url+file).post(builder.build()).build();

        client.newCall(request).enqueue(new Callback() {
                                            @Override
                                            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                                                e.printStackTrace();
                                            }

                                            @Override
                                            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                                                final String responseDate=response.body().string();
                                                a.runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        requestHandler.processResponse(responseDate);
                                                    }
                                                });

                                            }
                                        }
        );
    }

}
