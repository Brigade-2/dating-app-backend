package org.tinder.service;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.tinder.model.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Enumeration;

@Service
public class ProxyService {
    public ResponseEntity<String> processProxyRequest(HttpMethod method, HttpServletRequest request, HttpServletResponse response)
            throws URISyntaxException {
        String requestUrl = request.getRequestURI();
        System.out.println(request.getQueryString());

        URI uri = new URI("http", null, "fedozvpn.duckdns.org", 8090, "/api/collections/users/records", null, null);
        uri = UriComponentsBuilder.fromUri(uri)
                .query(request.getQueryString())
                .build(true).toUri();

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.set(headerName, request.getHeader(headerName));
        }

        System.out.println(uri.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.exchange(uri, method, httpEntity, String.class);
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
        }
    }

    public ResponseEntity<Void> processProxyRequestDelete(HttpMethod method, HttpServletRequest request, HttpServletResponse response, String id)
            throws URISyntaxException {
        String requestUrl = request.getRequestURI();
        System.out.println(request.getQueryString());

        URI uri = new URI("http", null, "fedozvpn.duckdns.org", 8090, "/api/collections/users/records", null, null);
        uri = UriComponentsBuilder.fromUri(uri)
                .path("/" + id)
                .query(request.getQueryString())
                .build(true).toUri();

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.set(headerName, request.getHeader(headerName));
        }

        System.out.println(uri.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.exchange(uri, method, httpEntity, String.class);
        } catch (HttpStatusCodeException e) {
            ResponseEntity.status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
        }
        return null;
    }
    public ResponseEntity<String> processProxyRequestGet(HttpMethod method, HttpServletRequest request, HttpServletResponse response, String id)
            throws URISyntaxException {
        String requestUrl = request.getRequestURI();
        System.out.println(request.getQueryString());

        URI uri = new URI("http", null, "fedozvpn.duckdns.org", 8090, "/api/collections/users/records", null, null);
        uri = UriComponentsBuilder.fromUri(uri)
                .path("/" + id)
                .query(request.getQueryString())
                .build(true).toUri();

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.set(headerName, request.getHeader(headerName));
        }

        System.out.println(uri.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.exchange(uri, method, httpEntity, String.class);
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
        }
    }
    public ResponseEntity<String> processProxyAuthWithPassword(String body, HttpMethod method, HttpServletRequest request, HttpServletResponse response)
            throws URISyntaxException {
        String requestUrl = request.getRequestURI();
        System.out.println(request.getQueryString());

        URI uri = new URI("http", null, "fedozvpn.duckdns.org", 8090, "/api/collections/users/auth-with-password", null, null);
        uri = UriComponentsBuilder.fromUri(uri)
                .query(request.getQueryString())
                .build(true).toUri();

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.set(headerName, request.getHeader(headerName));
        }

        System.out.println(uri.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.exchange(uri, method, httpEntity, String.class);
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
        }
    }
    public ResponseEntity<String> processProxyUpdateUser(String userId, String user, HttpMethod method, HttpServletRequest request,
                                                         HttpServletResponse response) throws URISyntaxException {
        String requestUrl = request.getRequestURI();
        System.out.println(request.getQueryString());

        URI uri = new URI("http", null, "fedozvpn.duckdns.org", 8090, "/api/collections/users/records", null, null);
        uri = UriComponentsBuilder.fromUri(uri)
                .path("/" + userId)
                .query(request.getQueryString())
                .build(true).toUri();

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.set(headerName, request.getHeader(headerName));
        }
        headers.set("X-HTTP-Method-Override", "PATCH");

        System.out.println(uri.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(user.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.exchange(uri, method, httpEntity, String.class);
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
        }
    }

    public ResponseEntity<String> processProxyCreateUser(String user, HttpMethod method, HttpServletRequest request,
                           HttpServletResponse response) throws URISyntaxException {
        String requestUrl = request.getRequestURI();
        System.out.println(request.getQueryString());

        URI uri = new URI("http", null, "fedozvpn.duckdns.org", 8090, "/api/collections/users/records", null, null);
        uri = UriComponentsBuilder.fromUri(uri)
                .query(request.getQueryString())
                .build(true).toUri();

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.set(headerName, request.getHeader(headerName));
        }

        System.out.println(uri.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(user.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.exchange(uri, method, httpEntity, String.class);
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
        }
    }
}