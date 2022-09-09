package com.example.skillsauditor.user.application.identity;

import com.example.skillsauditor.user.domain.common.UserDetails;
import com.example.skillsauditor.user.ui.identity.interfaces.INFIdentityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class IdentityService implements INFIdentityService {

    public String validateAndGetRole(UserDetails userDetails) {
        String URL = "http://localhost:8082/validateRole";
        return getResponseFromIdentityContext(userDetails, URL);
    }

    public String getID(UserDetails userDetails) {
        String URL = "http://localhost:8082/id";
        return getResponseFromIdentityContext(userDetails, URL);
    }

    private String getResponseFromIdentityContext(UserDetails userDetails, String URL){
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<UserDetails> request = new HttpEntity<>(
                new UserDetails(userDetails.getId(), userDetails.getToken(), userDetails.getUsername()));
        String response = restTemplate.postForObject(URL, request, String.class);
        return response;
    }

    public boolean isSpecifiedUser(UserDetails userDetails, String staffId){
        return getID(userDetails).equals(staffId);
    }


    public boolean isAdmin(UserDetails userDetails){
        return validateAndGetRole(userDetails).equals("ADMIN");
    }
}
