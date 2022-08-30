package com.example.identity.controller;

import com.example.identity.service.DTO.UserDTO;

import java.util.Optional;

public interface INFUserService {

    Optional<UserDTO> authenticate(String username, String password);
}
