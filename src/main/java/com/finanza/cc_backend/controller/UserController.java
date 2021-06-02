package com.finanza.cc_backend.controller;

import com.finanza.cc_backend.domain.model.User;
import com.finanza.cc_backend.domain.service.UserService;
import com.finanza.cc_backend.resource.MortgageCreditResource;
import com.finanza.cc_backend.resource.SaveUserResource;
import com.finanza.cc_backend.resource.UserResource;
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

    @PostMapping("/user")
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource){
        return convertToResource(userService.createuser(convertToEntity(resource)));
    }

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
