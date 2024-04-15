package org.example.todo_demo.common;

import okhttp3.*;

import java.io.IOException;

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

    private static Response sendGet(String body) {
        RequestBody formattedBody = RequestBody.create(
                body, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url("http://localhost:5000/add_todo")
                .post(formattedBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
            return response;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
