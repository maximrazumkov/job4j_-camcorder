package ru.job4j.camcoder.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class SimpleWebExecuter implements WebExecuter {

    public <T> T get(String url, Class<T> clazz) {
        T result = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpResponse response = client.execute(new HttpGet(url));
            String responseBody = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
            result = new ObjectMapper().readValue(responseBody, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
