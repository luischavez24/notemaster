package com.notemaster.api.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(
            OAuth2AccessToken accessToken,
            OAuth2Authentication authentication) {
        NotemasterUser userDetails = (NotemasterUser) authentication.getPrincipal();

        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("firstName", userDetails.getFirstName());
        additionalInfo.put("lastName", userDetails.getLastName());
        additionalInfo.put("middleName", userDetails.getMiddleName());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(
                additionalInfo);
        return accessToken;
    }
}