package com.example.identity.service;

import com.example.identity.controller.INFUserService;
import com.example.identity.repo.AppUserJpa;
import com.example.identity.repo.INFUserRepository;
import com.example.identity.service.DTO.AppUserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements INFUserService {

    private INFUserRepository userRepository;

    @Override
    public Optional<AppUserDTO> authenticate(String username, String password) {
        Optional<AppUserJpa> result = userRepository.findUserByUsernameAndPassword(username, password);
        return result.map(this::convertToDTO);
    }

    private AppUserDTO convertToDTO(AppUserJpa user){
        return new AppUserDTO(user.getUserUUID(),
                user.getUserName(),
                user.getPassword(),
                user.getFirstName(),
                user.getSurname(),
                user.getJobRole().toString());
    }
}
