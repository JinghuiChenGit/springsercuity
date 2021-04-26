package com.spring.springsercuity;

import com.spring.springsercuity.mapper.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringsercuityApplicationTests {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserInfoMapper userInfoMapper;

	@Test
	void contextLoads() {

		System.out.println(userInfoMapper.fingUserRoleByName("admin"));
	}

}
