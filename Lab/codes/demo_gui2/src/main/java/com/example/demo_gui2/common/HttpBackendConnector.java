package com.example.demo_gui2.common;

import java.io.IOException;
import okhttp3.*;

public class HttpBackendConnector {
    private static HttpBackendConnector instance;
    HttpBackendConnector() {

    }
    // Singleton
    public static synchronized HttpBackendConnector getInstance() {
        if (instance == null) {
            instance = new HttpBackendConnector();
        }
        return instance;
    }
    // Singleton

    static OkHttpClient client = new OkHttpClient();

    public Response sendPost(String body, String url) {
        RequestBody formattedBody = RequestBody.create(
                body, MediaType.parse("application/json; " +
                        "charset=utf-8"));


        Request request = new Request.Builder()
                .url(String.format("http://127.0.0.1:5000/" + url))
                .post(formattedBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}