package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.RoleDto;
import com.application.bamcoreport.DTO.models.UserDto;

import java.util.List;

public interface IRoleService {
    List<RoleDto> getRoles();
}
