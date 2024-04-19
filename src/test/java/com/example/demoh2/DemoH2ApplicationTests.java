package com.example.demoh2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class DemoH2ApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("hello, world");
	}

}
