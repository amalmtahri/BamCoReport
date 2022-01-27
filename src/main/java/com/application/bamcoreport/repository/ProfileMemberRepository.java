package com.application.bamcoreport.repository;

import com.application.bamcoreport.DTO.models.ProfileMemberDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProfileMemberRepository  extends JpaRepository<ProfileMemberDto,Long> {
}
