package com.example.app2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class WelcomeResource {

    public final static String ID_HEADER = "idOperation";

    @Value("${welcome.message}")
    private String welcomeMessage;
    @Value("${api.message}")
    private String apiMessage;


    /**
     * http://localhost:9091/welcome
     * http://localhost:8080/spring-rest/welcome
     *
     * @return
     */
    @GetMapping("/welcome")
    public String retrieveWelcomeMessage() {
        // Complex Method
        return welcomeMessage;
    }

    /**
     * https://www.baeldung.com/rest-template
     * https://dzone.com/articles/caching-with-apache-http-client-and-spring-resttem
     * https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/spring-mvc-request-header.html
     * <p>
     * http://localhost:9091/api/v2/surname
     *
     * @return
     */
    @GetMapping("/api/v2/surname")
    public ResponseEntity<String> retrieveMessage(
            @RequestHeader HttpHeaders httpHeaders) {

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(apiMessage);
    }


}
