package com.aliyun.gp.utils;

import lombok.SneakyThrows;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;


public class RestTemplateUtil {


    public static String httpPostRequest(String url, String jsonParam) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
        headers.setContentType(type);
        HttpEntity<String> entity = new HttpEntity<String>(jsonParam, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        return response.getBody();
    }


    public static String httpGetRequest(String url, String jsonParam) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
        headers.setContentType(type);
        HttpEntity<String> entity = new HttpEntity<String>(jsonParam, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        return response.getBody();
    }

    public static String httpGetRequest(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        int code = forEntity.getStatusCode().value();
        return forEntity.getBody();
    }


    @SneakyThrows
    public static String convertUrl(String path,Map<String, String> param) {
        //uri的构造器
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("https")
                .setHost("stockapi.com.cn")
                .setPath(path);
        param.forEach((k, v) -> uriBuilder.addParameter(k, v));
        URI uri = uriBuilder.build();
        return uri.toString();
    }
}
