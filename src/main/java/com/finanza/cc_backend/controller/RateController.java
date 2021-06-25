package com.finanza.cc_backend.controller;

import com.finanza.cc_backend.domain.model.Rate;
import com.finanza.cc_backend.domain.service.RateService;
import com.finanza.cc_backend.resource.RateResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RateController {
    @Autowired
    RateService rateService;

    @Autowired
    ModelMapper mapper;

    @Operation(summary = "Get Rates", description = "Get All Rates based on Term and Property Values", tags = {"Rates"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All rates based on Term and Property Value", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/rates/{term}/{pvalue}/{currency}")
    public List<RateResource> getRatesByTermAndValue(
            @PathVariable double term, @PathVariable double pvalue, @PathVariable String currency){
       return rateService.getRatesByTermAndValue(term, pvalue, currency)
               .stream()
               .map(this::convertToResource)
               .collect(Collectors.toList());
    }

    private RateResource convertToResource(Rate rate){
        RateResource resource = mapper.map(rate, RateResource.class);
        resource.setBank_id(rate.getBank().getId());
        resource.setTerm_id(rate.getTerm().getId());
        resource.setValue_id(rate.getValue().getId());
        return resource;
    }
}

