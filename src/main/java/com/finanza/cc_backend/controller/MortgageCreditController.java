package com.finanza.cc_backend.controller;

import com.finanza.cc_backend.domain.model.MortgageCredit;
import com.finanza.cc_backend.domain.service.MortgageCreditService;
import com.finanza.cc_backend.resource.MortgageCreditResource;
import com.finanza.cc_backend.resource.SaveMortgageCreditResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public MortgageCreditResource saveMortgageByUserId(
            @Valid @RequestBody SaveMortgageCreditResource saveMortgageCreditResource,
            @PathVariable Long userId){
        MortgageCredit mg = convertToEntity(saveMortgageCreditResource);
        return convertToResource(mortgageCreditService.saveMortgageCreditByUserId(mg, userId));
    }

    @Operation(summary = "Delete MortgageCredit", description = "Delete a Mortgage Credit by Id", tags = {"Mortgage Credits"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("/mortgages/{mortgageId}")
    public ResponseEntity<?> deleteMortgageById(@PathVariable Long mortgageId){
        mortgageCreditService.deleteMortgageById(mortgageId);
        return ResponseEntity.ok().build();
    }

    private MortgageCredit convertToEntity(SaveMortgageCreditResource resource){
        return mapper.map(resource, MortgageCredit.class);
    }

    private MortgageCreditResource convertToResource(MortgageCredit entity){
        return mapper.map(entity, MortgageCreditResource.class);
    }
}
