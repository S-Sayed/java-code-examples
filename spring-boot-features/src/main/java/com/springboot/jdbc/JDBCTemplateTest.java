package com.springboot.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot.jdbc")
public class JDBCTemplateTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(JDBCTemplateTest.class, args);
		new JDBCTemplateTest().getUsers();
	}

	private void getUsers() {
		List<Map<String, Object>> user = jdbcTemplate.queryForList("SELCT * FROM USERS");
		System.out.println(user);
	}

}
