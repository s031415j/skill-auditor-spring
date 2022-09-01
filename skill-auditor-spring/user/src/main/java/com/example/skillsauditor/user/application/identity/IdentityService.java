package com.example.skillsauditor.user.application.identity;

import com.example.skillsauditor.user.ui.identity.interfaces.INFIdentityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IdentityService implements INFIdentityService {

    private JwtTokenUtil jwtTokenUtil;

     public boolean isSpecifiedUser(String token, String user_id){
        return getUserId(token).equals(user_id);
    }

    public boolean isAdmin(String token){
        return getJobRole(token).equals("ADMIN");
    }

    private String getUserId(String token){
        return jwtTokenUtil.getClaimFromToken(token, UserDTO.ID);
    }

    private String getJobRole(String token) {
        return jwtTokenUtil.getClaimFromToken(token, UserDTO.JOB_ROLE);
    }
}
