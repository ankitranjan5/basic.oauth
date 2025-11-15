package com.example.oauth.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/jira")
public class JiraController {



    @GetMapping("getissue/{issueId}")
    public String getIssue(@PathVariable String issueId, @RegisteredOAuth2AuthorizedClient("jira") OAuth2AuthorizedClient authorizedClient) throws JsonProcessingException {

        String accessToken = authorizedClient.getAccessToken().getTokenValue();

        System.out.println("token scopes = " + authorizedClient.getAccessToken().getScopes());
        System.out.println("expires at = " + authorizedClient.getAccessToken().getExpiresAt());


        String accessibleJson = WebClient.create()
                .get()
                .uri("https://api.atlassian.com/oauth/token/accessible-resources")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ObjectMapper om = new ObjectMapper();
        JsonNode arr = om.readTree(accessibleJson);
        String cloudId = arr.get(0).get("id").asText();

        return WebClient.builder()
                .build()
                .get()
                .uri("https://api.atlassian.com/ex/jira/" + cloudId + "/rest/api/3/issue/" + issueId)
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
