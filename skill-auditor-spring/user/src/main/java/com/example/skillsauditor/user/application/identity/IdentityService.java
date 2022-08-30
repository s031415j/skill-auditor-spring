package com.example.skillsauditor.user.application.identity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IdentityService{

    private JwtTokenUtil jwtTokenUtil;

    private boolean isSpecifiedUser(String token, String user_id){
        return getUserId(token).equals(user_id);
    }

    private boolean isAdmin(String token){
        return getJobRole(token).equals("ADMIN");
    }

    private String getUserId(String token){
        return jwtTokenUtil.getClaimFromToken(token, UserDTO.ID);
    }

    private String getJobRole(String token) {
        return jwtTokenUtil.getClaimFromToken(token, UserDTO.JOB_ROLE);
    }
}
