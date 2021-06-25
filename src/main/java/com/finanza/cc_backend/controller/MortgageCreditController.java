package com.finanza.cc_backend.controller;

import com.finanza.cc_backend.domain.model.MortgageCredit;
import com.finanza.cc_backend.domain.model.User;
import com.finanza.cc_backend.domain.service.MortgageCreditService;
import com.finanza.cc_backend.resource.SaveMortgageCreditResource;
import com.finanza.cc_backend.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MortgageCreditController {
    @Autowired
    MortgageCreditService mortgageCreditService;

    @Autowired
    ModelMapper mapper;

    @Operation(summary = "Create MortgageCredit", description = "Save a Mortgage Credit by User Id", tags = {"Mortgage Credits"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User returned", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/mortgages/users/{userId}")
    public UserResource saveMortgageByUserId(
            @Valid @RequestBody SaveMortgageCreditResource saveMortgageCreditResource,
            @PathVariable Long userId){
        MortgageCredit mg = convertToEntity(saveMortgageCreditResource);
        return convertToResource(mortgageCreditService.saveMortgageCreditByUserId(mg, userId));
    }

    private MortgageCredit convertToEntity(SaveMortgageCreditResource resource){
        return mapper.map(resource, MortgageCredit.class);
    }

    private UserResource convertToResource(User entity){
        return mapper.map(entity, UserResource.class);
    }
}
