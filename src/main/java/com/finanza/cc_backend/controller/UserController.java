package com.finanza.cc_backend.controller;

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

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Create User", description = "Create User with all fields", tags = {"users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User returned", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/user")
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource){
        return convertToResource(userService.createUser(convertToEntity(resource)));
    }

    @Operation(summary = "Get MortgageCredits by User", description = "Get all mortgage credits saved by the user", tags = {"users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All mortgage credits of an User returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/user/{userId}/mortgage")
    public Page<MortgageCreditResource> getMortgageCreditByUserId(@PathVariable Long userId){
        //return userService.getMortgageCreditByUserId();
        return null;
    }

    private User convertToEntity(SaveUserResource resource){
        return mapper.map(resource, User.class);
    }

    private UserResource convertToResource(User entity){
        return mapper.map(entity, UserResource.class);
    }
}
