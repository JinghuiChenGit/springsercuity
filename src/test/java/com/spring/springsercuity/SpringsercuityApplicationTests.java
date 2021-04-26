package com.spring.springsercuity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringsercuityApplicationTests {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {

		System.out.println(passwordEncoder.upgradeEncoding("$2a$10$MxeUQIIAYEYdrTsOvOGgS.1gljd0Yg1/EW/4/9IPiHxkPBLftwUoG"));
	}

}
