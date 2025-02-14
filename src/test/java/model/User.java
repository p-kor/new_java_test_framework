package model;

import lombok.Builder;

@Builder
public record User(
        int id,
        String username,
        String firstName,
        String lastName,
        String email,
        String password,
        String phone,
        int userStatus) {
}