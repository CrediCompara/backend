package com.finanza.cc_backend.controller;

import com.finanza.cc_backend.domain.model.User;
import com.finanza.cc_backend.domain.service.DefaultUserDetailsService;
import com.finanza.cc_backend.domain.service.UserService;
import com.finanza.cc_backend.resource.UserResource;
import com.finanza.cc_backend.service.communication.AuthenticationRequest;
import com.finanza.cc_backend.service.communication.AuthenticationResponse;
import com.finanza.cc_backend.util.JwtCenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtCenter tokenCenter;
    @Autowired
    private DefaultUserDetailsService userDetailsService;
    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Login User", description = "Authenticates an User", tags = {"Security"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authenticated success", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/sign-in")
    public ResponseEntity<?> generateAuthenticationToken(
            @RequestBody AuthenticationRequest request)
            throws Exception {
        authenticate(request.getUsername(), request.getPassword());
        final UserDetails userDetails =
                userDetailsService.loadUserByUsername(request.getUsername());
        System.out.println("Password: " + request.getPassword());
        String token = tokenCenter.generateToken(userDetails);
        User user = userService.findUserByEmail(userDetails.getUsername());
        return ResponseEntity.ok(new
                AuthenticationResponse(convertToResource(user), token));
    }

    private void authenticate(String username, String password)
            throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    private UserResource convertToResource(User user){
        return mapper.map(user, UserResource.class);
    }
}