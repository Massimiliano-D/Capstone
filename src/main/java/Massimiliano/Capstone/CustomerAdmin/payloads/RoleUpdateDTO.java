package Massimiliano.Capstone.CustomerAdmin.payloads;

import Massimiliano.Capstone.CustomerAdmin.Role;
import Massimiliano.Capstone.CustomerAdmin.validator.ValidRole;

public record RoleUpdateDTO(
        @ValidRole(enumClass = Role.class, message = "The type of device must be one of these:" +
                "USER, ADMIN")
        String role) {
}
