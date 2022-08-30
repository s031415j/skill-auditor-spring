package com.example.identity.controller;

import com.example.identity.service.DTO.AppUserDTO;

import java.util.Optional;

public interface INFUserService {

    Optional<AppUserDTO> authenticate(String username, String password);
}
