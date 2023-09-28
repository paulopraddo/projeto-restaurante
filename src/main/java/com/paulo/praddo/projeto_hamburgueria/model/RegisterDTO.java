package com.paulo.praddo.projeto_hamburgueria.model;

import com.paulo.praddo.projeto_hamburgueria.entity.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
