package com.salomia.zk.service;

import com.salomia.zk.service.model.Message;
import com.salomia.zk.service.model.OpenAIRequest;
import com.salomia.zk.service.model.OpenAIResponse;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HazavaoService {

  private final WebClient webClient;

  private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

  public HazavaoService(WebClient.Builder webClientBuilder) {
    this.webClient =
        webClientBuilder
            .baseUrl(OPENAI_URL)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + System.getenv("API_KEY"))
            .build();
  }

  public Mono<String> getChatCompletion(String prompt) {
    OpenAIRequest request =
        new OpenAIRequest("gpt-3.5-turbo", List.of(new Message("user", prompt)), 0.7);
    System.out.println(webClient.post().bodyValue(request).retrieve());

    return webClient
        .post()
        .bodyValue(request)
        .retrieve()
        .bodyToMono(OpenAIResponse.class)
        .map(response -> response.getChoices().get(0).getMessage().content());
  }
}
