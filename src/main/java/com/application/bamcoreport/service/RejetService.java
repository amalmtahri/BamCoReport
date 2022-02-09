package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.RejetDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Rejet;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.RejetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RejetService implements IRejetService{

    @Autowired
    private RejetRepository repository;

    @Autowired
    IMapClassWithDto<Rejet, RejetDto> rejetMapping;

    @Autowired
    private UserService userService;

    @Override
    public List<RejetDto> getRejets() {
        List<Rejet> rejets = repository.findAll();
        List<RejetDto> rejetDtos = rejetMapping.convertListToListDto(rejets,RejetDto.class);
        return rejetDtos;
    }

    public RejetDto saveRejet(RejetDto rejetDto){
        // convert DTO to entity
        Rejet rejetRequest = rejetMapping.convertToEntity(rejetDto,Rejet.class);
        User getUserData = userService.getUserById(rejetRequest.getTakenBy().getId());
        rejetRequest.setTakenBy(getUserData);
        log.info("Saving new Rejet {} to database",rejetRequest.getId());
        Rejet rejet = repository.save(rejetRequest);
        // convert entity to DTO
        RejetDto rejetResponse = rejetMapping.convertToDto(rejet, RejetDto.class);
        return rejetResponse;
    }
}
