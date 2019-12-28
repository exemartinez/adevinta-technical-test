package com.schibsted.spain.friends.legacy;

import com.schibsted.spain.friends.controllers.PersonManager;
import com.schibsted.spain.friends.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class just creates a new user
 */
@RestController
@RequestMapping("/signup")
public class SignupLegacyController {

    private final PersonManager personManager;

    public SignupLegacyController(PersonManager personManager) {
        this.personManager = personManager;
    }

    @PostMapping
    void signUp(@RequestParam("username") String username, @RequestHeader("X-Password") String password) {

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);

        personManager.save(user);

    }
}
