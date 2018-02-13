package haoru.cisco.com.asyncmethod.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import haoru.cisco.com.asyncmethod.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GitHubLookupService {

    private final RestTemplate restTemplate;

    private final HttpEntity<String> entity;

    private final HttpHeaders headers;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        headers = new HttpHeaders();
        headers.add("user-agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        entity = new HttpEntity<>(headers);
    }

    @Async
    public CompletableFuture<User> findUser(String user) throws InterruptedException {
        log.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User result = restTemplate.exchange(url, HttpMethod.GET, entity, User.class).getBody();
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(result);
    }

}