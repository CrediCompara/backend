package com.finanza.cc_backend.controller;

import com.finanza.cc_backend.domain.model.MortgageCredit;
import com.finanza.cc_backend.domain.model.User;
import com.finanza.cc_backend.domain.service.UserService;
import com.finanza.cc_backend.resource.MortgageCreditResource;
import com.finanza.cc_backend.resource.SaveUserResource;
import com.finanza.cc_backend.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Register an User", description = "Create User with all fields", tags = {"Security"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User returned", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/auth/sign-up")
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource){
        return convertToResource(userService.createUser(convertToEntity(resource)));
    }

    @Operation(summary = "Get MortgageCredits by User", description = "Get all mortgage credits saved by the user", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All mortgage credits of an User returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/users/{userId}/mortgages")
    public List<MortgageCreditResource> getMortgageCreditByUserId(@PathVariable Long userId){
        return userService.getMortgageCreditsById(userId).stream()
                .map(this::convertToResourceMortagage)
                .collect(Collectors.toList());
    }

    private MortgageCreditResource convertToResourceMortagage(MortgageCredit mortgageCredit){
        return mapper.map(mortgageCredit, MortgageCreditResource.class);
    }
    private User convertToEntity(SaveUserResource resource){
        return mapper.map(resource, User.class);
    }

    private UserResource convertToResource(User entity){
        return mapper.map(entity, UserResource.class);
    }
}
