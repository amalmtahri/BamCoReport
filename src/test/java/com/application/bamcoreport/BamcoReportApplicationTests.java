package com.application.bamcoreport;

import com.application.bamcoreport.controller.UserController;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class BamcoReportApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testMethod(){
        User user = new User(1,true,"amalmtahri","amal","amal","mtahri","developer","developer web",null,null);
        User result = userRepository.save(user);
        assertThat(result.getFirstname()).isEqualTo("amal");

    }


}
