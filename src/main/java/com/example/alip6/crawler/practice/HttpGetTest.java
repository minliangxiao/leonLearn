package com.example.alip6.crawler.practice;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpGetTest {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");
        CloseableHttpResponse response = null;
        try {
             response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String resposeString = EntityUtils.toString(response.getEntity(), "utf8");
                System.out.println(resposeString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            httpClient.close();
            response.close();
        }

    }
}
