package Massimiliano.Capstone.authorization;

import Massimiliano.Capstone.CustomerAdmin.User;
import Massimiliano.Capstone.CustomerAdmin.payloads.UserDTO;
import Massimiliano.Capstone.CustomerAdmin.payloads.UserLoginDTO;
import Massimiliano.Capstone.CustomerAdmin.payloads.UserSuccessLoginDTO;
import Massimiliano.Capstone.Exeption.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public UserSuccessLoginDTO login(@RequestBody UserLoginDTO body) throws Exception {
        return new UserSuccessLoginDTO(authService.authenticateUser(body));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Validated UserDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException("", validation.getAllErrors());
        } else {
            return authService.save(body);
        }
    }
    

}
