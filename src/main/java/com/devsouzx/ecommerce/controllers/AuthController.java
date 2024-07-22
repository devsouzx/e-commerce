package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.domain.user.dto.LoginDTO;
import com.devsouzx.ecommerce.domain.user.dto.UserRequestDTO;
import com.devsouzx.ecommerce.domain.user.User;
import com.devsouzx.ecommerce.domain.user.dto.UserResponseDTO;
import com.devsouzx.ecommerce.domain.user.dto.TokenResponseDTO;
import com.devsouzx.ecommerce.infra.security.TokenService;
import com.devsouzx.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO body) {
        if (this.userService.findByEmail(body.email()) != null) return ResponseEntity.badRequest().build();

        User user = userService.register(body);

        return ResponseEntity.ok(new UserResponseDTO(user));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginDTO body) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(body.email(), body.password());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new TokenResponseDTO(token));
    }
}
