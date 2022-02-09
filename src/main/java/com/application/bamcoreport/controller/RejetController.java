package com.application.bamcoreport.controller;


import com.application.bamcoreport.DTO.models.RejetDto;
import com.application.bamcoreport.service.RejetService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rejet")
@SecurityRequirement(name = "bearerAuth")
public class RejetController {

    @Autowired
    private RejetService service;

    @PostMapping("/addRejet")
    public RejetDto addRejet(@RequestBody RejetDto rejetDto){
        return service.saveRejet(rejetDto);
    }


    @GetMapping("/getOne/{id}")
    public RejetDto getRejetById(@PathVariable Long id){
        return service.getRejetById(id);
    }

    @GetMapping("/allRejet")
    public ResponseEntity<List<RejetDto>> getAllRejets(){
        List<RejetDto> rejetDto = service.getRejets();
        return ResponseEntity.ok(rejetDto);
    }

    @DeleteMapping("/deleteRejet/{id}")
    public String deleteRejet(@PathVariable Long id){
        return service.deleteRejet(id);
    }

    @PutMapping("/updateRejet")
    public RejetDto updateRejet(@RequestBody RejetDto rejetDto){
        return service.updateRejet(rejetDto);
    }


}
