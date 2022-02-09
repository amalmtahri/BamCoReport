package com.application.bamcoreport.controller;


import com.application.bamcoreport.DTO.models.RejetDto;
import com.application.bamcoreport.service.RejetService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rejet")
@SecurityRequirement(name = "bearerAuth")
public class RejetController {

    @Autowired
    private RejetService service;


    public RejetDto addRejet(@RequestBody RejetDto rejetDto){
        return service.saveRejet(rejetDto);
    }
}
